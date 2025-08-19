package br.com.alura.challange.literatura;

import br.com.alura.challange.literatura.dto.LivroGutendex;
import br.com.alura.challange.literatura.model.Autor;
import br.com.alura.challange.literatura.model.Livro;
import br.com.alura.challange.literatura.service.LiteraturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

    @Autowired
    private LiteraturaService literaturaService;

    public static void main(String[] args) {
        SpringApplication.run(LiteraturaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
            
            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo(scanner);
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresPorAno(scanner);
                    break;
                case 5:
                    listarLivrosPorIdioma(scanner);
                    break;
                case 6:
                    listarTop10Livros();
                    break;
                case 7:
                    buscarAutorPorNome(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
            
            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine();
        }
    }
    
    private void exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           LITERALURA - CATÁLOGO DE LIVROS");
        System.out.println("=".repeat(50));
        System.out.println("1 - Buscar livro pelo título");
        System.out.println("2 - Listar livros registrados");
        System.out.println("3 - Listar autores");
        System.out.println("4 - Listar autores em determinado ano");
        System.out.println("5 - Listar livros em determinado idioma");
        System.out.println("6 - Top 10 livros mais baixados");
        System.out.println("7 - Buscar autor por nome");
        System.out.println("0 - Sair");
        System.out.println("=".repeat(50));
        System.out.print("Escolha uma opção: ");
    }
    
    private void buscarLivroPorTitulo(Scanner scanner) {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        
        System.out.println("Buscando livros...");
        List<LivroGutendex> livros = literaturaService.buscarLivrosPorTitulo(titulo);
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado com esse título.");
            return;
        }
        
        System.out.println("\nLivros encontrados:");
        for (int i = 0; i < livros.size(); i++) {
            LivroGutendex livro = livros.get(i);
            System.out.printf("%d - %s\n", i + 1, livro.titulo());
            if (!livro.autores().isEmpty()) {
                System.out.printf("   Autor: %s\n", livro.autores().get(0).nome());
            }
            System.out.printf("   Idioma: %s\n", livro.idiomas().isEmpty() ? "N/A" : livro.idiomas().get(0));
            System.out.printf("   Downloads: %d\n", livro.downloads());
            System.out.println();
        }
        
        System.out.print("Escolha o número do livro para salvar (0 para cancelar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        
        if (escolha > 0 && escolha <= livros.size()) {
            try {
                Livro livroSalvo = literaturaService.salvarLivro(livros.get(escolha - 1));
                System.out.println("Livro salvo com sucesso: " + livroSalvo.getTitulo());
            } catch (Exception e) {
                System.out.println("Erro ao salvar livro: " + e.getMessage());
            }
        }
    }
    
    private void listarLivrosRegistrados() {
        List<Livro> livros = literaturaService.listarLivrosRegistrados();
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado no sistema.");
            return;
        }
        
        System.out.println("\nLivros registrados:");
        for (Livro livro : livros) {
            System.out.printf("- %s\n", livro.getTitulo());
            System.out.printf("  Autor: %s\n", livro.getAutor().getNome());
            System.out.printf("  Idioma: %s\n", livro.getIdioma());
            System.out.printf("  Downloads: %d\n", livro.getDownloads());
            System.out.println();
        }
    }
    
    private void listarAutores() {
        List<Autor> autores = literaturaService.listarAutores();
        
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor registrado no sistema.");
            return;
        }
        
        System.out.println("\nAutores registrados:");
        for (Autor autor : autores) {
            System.out.printf("- %s\n", autor.getNome());
            System.out.printf("  Nascimento: %s\n", autor.getAnoNascimento() != null ? autor.getAnoNascimento().toString() : "N/A");
            System.out.printf("  Falecimento: %s\n", autor.getAnoFalecimento() != null ? autor.getAnoFalecimento().toString() : "N/A");
            System.out.printf("  Livros: %s\n", autor.getLivros().stream().map(Livro::getTitulo).toList());
            System.out.println();
        }
    }
    
    private void listarAutoresPorAno(Scanner scanner) {
        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        
        List<Autor> autores = literaturaService.listarAutoresVivosNoAno(ano);
        
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor estava vivo em " + ano + ".");
            return;
        }
        
        System.out.println("\nAutores vivos em " + ano + ":");
        for (Autor autor : autores) {
            System.out.printf("- %s\n", autor.getNome());
            System.out.printf("  Nascimento: %s\n", autor.getAnoNascimento() != null ? autor.getAnoNascimento().toString() : "N/A");
            System.out.printf("  Falecimento: %s\n", autor.getAnoFalecimento() != null ? autor.getAnoFalecimento().toString() : "N/A");
            System.out.println();
        }
    }
    
    private void listarLivrosPorIdioma(Scanner scanner) {
        System.out.println("Idiomas disponíveis:");
        System.out.println("PT - Português");
        System.out.println("EN - Inglês");
        System.out.println("ES - Espanhol");
        System.out.println("FR - Francês");
        System.out.print("Digite o código do idioma: ");
        String idioma = scanner.nextLine().toUpperCase();
        
        List<Livro> livros = literaturaService.listarLivrosPorIdioma(idioma);
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado no idioma " + idioma + ".");
            return;
        }
        
        System.out.println("\nLivros em " + idioma + ":");
        for (Livro livro : livros) {
            System.out.printf("- %s\n", livro.getTitulo());
            System.out.printf("  Autor: %s\n", livro.getAutor().getNome());
            System.out.printf("  Downloads: %d\n", livro.getDownloads());
            System.out.println();
        }
    }
    
    private void listarTop10Livros() {
        List<Livro> livros = literaturaService.listarTop10Livros();
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado no sistema.");
            return;
        }
        
        System.out.println("\nTop 10 livros mais baixados:");
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            System.out.printf("%d - %s\n", i + 1, livro.getTitulo());
            System.out.printf("   Autor: %s\n", livro.getAutor().getNome());
            System.out.printf("   Downloads: %d\n", livro.getDownloads());
            System.out.println();
        }
    }
    
    private void buscarAutorPorNome(Scanner scanner) {
        System.out.print("Digite o nome do autor: ");
        String nome = scanner.nextLine();
        
        var autor = literaturaService.buscarAutorPorNome(nome);
        
        if (autor.isEmpty()) {
            System.out.println("Autor não encontrado.");
            return;
        }
        
        Autor autorEncontrado = autor.get();
        System.out.println("\nAutor encontrado:");
        System.out.printf("Nome: %s\n", autorEncontrado.getNome());
        System.out.printf("Nascimento: %s\n", autorEncontrado.getAnoNascimento() != null ? autorEncontrado.getAnoNascimento().toString() : "N/A");
        System.out.printf("Falecimento: %s\n", autorEncontrado.getAnoFalecimento() != null ? autorEncontrado.getAnoFalecimento().toString() : "N/A");
        System.out.printf("Livros: %s\n", autorEncontrado.getLivros().stream().map(Livro::getTitulo).toList());
    }
}

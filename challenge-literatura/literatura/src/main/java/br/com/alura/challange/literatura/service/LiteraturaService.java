package br.com.alura.challange.literatura.service;

import br.com.alura.challange.literatura.dto.AutorGutendex;
import br.com.alura.challange.literatura.dto.LivroGutendex;
import br.com.alura.challange.literatura.model.Autor;
import br.com.alura.challange.literatura.model.Livro;
import br.com.alura.challange.literatura.repository.AutorRepository;
import br.com.alura.challange.literatura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiteraturaService {
    
    @Autowired
    private GutendexService gutendexService;
    
    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private AutorRepository autorRepository;
    
    public List<LivroGutendex> buscarLivrosPorTitulo(String titulo) {
        return gutendexService.buscarLivrosPorTitulo(titulo);
    }
    
    public Livro salvarLivro(LivroGutendex livroGutendex) {
        if (livroGutendex.autores().isEmpty()) {
            throw new RuntimeException("Livro sem autor não pode ser salvo");
        }
        
        AutorGutendex autorGutendex = livroGutendex.autores().get(0);
        
        // Verificar se o autor já existe
        Optional<Autor> autorExistente = autorRepository.findByNomeContainingIgnoreCase(autorGutendex.nome());
        Autor autor;
        
        if (autorExistente.isPresent()) {
            autor = autorExistente.get();
        } else {
            autor = new Autor(autorGutendex.nome(), autorGutendex.anoNascimento(), autorGutendex.anoFalecimento());
            autor = autorRepository.save(autor);
        }
        
        // Verificar se o livro já existe
        if (livroRepository.existsByTituloContainingIgnoreCase(livroGutendex.titulo())) {
            throw new RuntimeException("Livro já cadastrado no sistema");
        }
        
        // Pegar o primeiro idioma da lista
        String idioma = livroGutendex.idiomas().isEmpty() ? "N/A" : livroGutendex.idiomas().get(0);
        
        Livro livro = new Livro(
                livroGutendex.titulo(),
                idioma,
                livroGutendex.downloads(),
                autor
        );
        
        return livroRepository.save(livro);
    }
    
    public List<Livro> listarLivrosRegistrados() {
        return livroRepository.findAll();
    }
    
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }
    
    public List<Autor> listarAutoresVivosNoAno(Integer ano) {
        return autorRepository.findAutoresVivosNoAnoOuVivos(ano);
    }
    
    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroRepository.findByIdiomaIgnoreCase(idioma);
    }
    
    public List<Livro> listarTop10Livros() {
        List<Livro> livros = livroRepository.findTop10ByDownloads();
        return livros.stream().limit(10).toList();
    }
    
    public Optional<Autor> buscarAutorPorNome(String nome) {
        return autorRepository.findByNomeContainingIgnoreCase(nome);
    }
}

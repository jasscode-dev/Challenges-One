# LiterAlura - Catálogo de Livros

Projeto desenvolvido para o desafio LiterAlura da Alura, que consiste em um catálogo de livros que consome a API Gutendex e persiste os dados em um banco PostgreSQL.

## 🚀 Funcionalidades

- **Buscar livro pelo título**: Consulta a API Gutendex e salva o livro no banco de dados
- **Listar livros registrados**: Exibe todos os livros salvos no banco
- **Listar autores**: Mostra todos os autores cadastrados com seus livros
- **Listar autores em determinado ano**: Busca autores que estavam vivos em um ano específico
- **Listar livros por idioma**: Filtra livros por idioma (PT, EN, ES, FR)
- **Top 10 livros mais baixados**: Ranking dos livros mais populares
- **Buscar autor por nome**: Busca específica de autores

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## 📋 Pré-requisitos

- Java 17 ou superior
- PostgreSQL instalado e configurado
- Maven

## ⚙️ Configuração

### 1. Banco de Dados

1. Instale o PostgreSQL em sua máquina
2. Crie um banco de dados chamado `literatura`:
   ```sql
   CREATE DATABASE literatura;
   ```
3. Crie um usuário ou use o usuário padrão `postgres` com senha `postgres`

### 2. Configuração da Aplicação

O arquivo `application.properties` já está configurado com as seguintes configurações padrão:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literatura
spring.datasource.username=postgres
spring.datasource.password=postgres
```

Se suas configurações do PostgreSQL forem diferentes, edite o arquivo `src/main/resources/application.properties`.

## 🚀 Como Executar

1. Clone o repositório
2. Configure o banco de dados conforme descrito acima
3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
4. A aplicação iniciará e mostrará o menu interativo no terminal

## 📖 Como Usar

Após executar a aplicação, você verá um menu com as seguintes opções:

```
==================================================
           LITERALURA - CATÁLOGO DE LIVROS
==================================================
1 - Buscar livro pelo título
2 - Listar livros registrados
3 - Listar autores
4 - Listar autores em determinado ano
5 - Listar livros em determinado idioma
6 - Top 10 livros mais baixados
7 - Buscar autor por nome
0 - Sair
==================================================
```

### Exemplos de Uso

1. **Buscar e salvar um livro**:
   - Escolha opção 1
   - Digite "Dom Casmurro" ou "Emma"
   - Escolha o livro da lista e confirme

2. **Listar livros salvos**:
   - Escolha opção 2

3. **Ver autores vivos em 1800**:
   - Escolha opção 4
   - Digite "1800"

4. **Buscar livros em português**:
   - Escolha opção 5
   - Digite "PT"

## 🗄️ Estrutura do Banco de Dados

O projeto cria automaticamente as seguintes tabelas:

- **autores**: Armazena informações dos autores
- **livros**: Armazena informações dos livros com relacionamento para autores

## 🔧 API Externa

O projeto consome a API [Gutendex](https://gutendex.com/), que fornece dados de mais de 70 mil livros gratuitos.

## 📝 Funcionalidades Extras Implementadas

- Top 10 livros mais baixados
- Busca de autor por nome
- Interface amigável no terminal
- Tratamento de erros
- Validações de dados

## 🤝 Contribuição

Este projeto foi desenvolvido como parte do desafio LiterAlura da Alura. Sinta-se à vontade para contribuir com melhorias e funcionalidades adicionais.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

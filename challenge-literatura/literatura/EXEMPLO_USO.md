# Exemplos de Uso do LiterAlura

Este arquivo contém exemplos práticos de como usar o sistema LiterAlura.

## 🚀 Iniciando o Sistema

1. Configure o PostgreSQL conforme o README.md
2. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
3. Aguarde a inicialização e o menu aparecerá

## 📚 Exemplos de Busca de Livros

### Exemplo 1: Dom Casmurro (Livro Nacional)

1. Escolha opção **1** - Buscar livro pelo título
2. Digite: `Dom Casmurro`
3. Aguarde a busca na API
4. Escolha o livro da lista (geralmente o primeiro)
5. Confirme a escolha

**Resultado esperado:**
- Título: Dom Casmurro
- Autor: Machado de Assis
- Idioma: pt
- Downloads: [número de downloads]

### Exemplo 2: Emma (Livro Internacional)

1. Escolha opção **1** - Buscar livro pelo título
2. Digite: `Emma`
3. Aguarde a busca na API
4. Escolha o livro da lista
5. Confirme a escolha

**Resultado esperado:**
- Título: Emma
- Autor: Jane Austen
- Idioma: en
- Downloads: [número de downloads]

## 📋 Exemplos de Consultas no Banco

### Listar Livros Registrados

1. Escolha opção **2** - Listar livros registrados
2. Veja todos os livros salvos no sistema

### Listar Autores

1. Escolha opção **3** - Listar autores
2. Veja todos os autores com seus livros

### Autores Vivos em 1800

1. Escolha opção **4** - Listar autores em determinado ano
2. Digite: `1800`
3. Veja autores que estavam vivos nesse ano

**Resultado esperado:**
- Jane Austen (nascida em 1775, falecida em 1817)

### Livros em Português

1. Escolha opção **5** - Listar livros em determinado idioma
2. Digite: `PT`
3. Veja livros em português

**Resultado esperado:**
- Dom Casmurro (se foi salvo anteriormente)

### Livros em Francês (sem resultados)

1. Escolha opção **5** - Listar livros em determinado idioma
2. Digite: `FR`
3. Veja a mensagem de que não há livros nesse idioma

## 🏆 Funcionalidades Extras

### Top 10 Livros Mais Baixados

1. Escolha opção **6** - Top 10 livros mais baixados
2. Veja o ranking dos livros por número de downloads

### Buscar Autor por Nome

1. Escolha opção **7** - Buscar autor por nome
2. Digite: `Machado` ou `Jane`
3. Veja os detalhes do autor encontrado

## 🔄 Fluxo Completo de Exemplo

1. **Buscar Dom Casmurro** (opção 1)
2. **Listar livros registrados** (opção 2) - confirme que foi salvo
3. **Listar autores** (opção 3) - veja Machado de Assis
4. **Buscar Emma** (opção 1)
5. **Listar livros registrados** (opção 2) - veja os dois livros
6. **Listar autores** (opção 3) - veja os dois autores
7. **Autores vivos em 1800** (opção 4) - veja Jane Austen
8. **Livros em português** (opção 5) - veja Dom Casmurro
9. **Top 10 livros** (opção 6) - veja o ranking
10. **Buscar autor Machado** (opção 7) - veja os detalhes

## ⚠️ Observações Importantes

- O sistema só busca na API na opção 1
- As demais opções usam apenas o banco de dados local
- Livros duplicados não são permitidos
- A API pode demorar alguns segundos para responder
- Alguns livros podem não ter todos os dados completos

## 🎯 Dicas de Uso

- Use títulos exatos para melhores resultados
- Teste diferentes idiomas (PT, EN, ES, FR)
- Experimente anos históricos para autores (1800, 1900, etc.)
- O sistema é case-insensitive para buscas
- Pressione ENTER após cada operação para continuar

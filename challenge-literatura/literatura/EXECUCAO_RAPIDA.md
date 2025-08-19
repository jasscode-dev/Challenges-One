# 🚀 Execução Rápida - LiterAlura

## ⚡ Passos para Executar Rapidamente

### 1. Pré-requisitos
- Java 17+ instalado
- PostgreSQL instalado e rodando
- Maven instalado

### 2. Configurar Banco de Dados
```sql
-- Execute no PostgreSQL
CREATE DATABASE literatura;
```

### 3. Executar o Projeto
```bash
# No terminal, na pasta do projeto
mvn spring-boot:run
```

### 4. Usar o Sistema
- O menu aparecerá automaticamente
- Siga as instruções na tela
- Teste com "Dom Casmurro" e "Emma"

## 🎯 Teste Rápido

1. **Opção 1** → Digite "Dom Casmurro" → Escolha o livro → Confirme
2. **Opção 2** → Veja o livro salvo
3. **Opção 3** → Veja o autor Machado de Assis
4. **Opção 1** → Digite "Emma" → Escolha o livro → Confirme
5. **Opção 4** → Digite "1800" → Veja Jane Austen
6. **Opção 5** → Digite "PT" → Veja Dom Casmurro

## 🔧 Configurações

Se precisar alterar as configurações do banco:
- Edite: `src/main/resources/application.properties`
- Usuário padrão: `postgres`
- Senha padrão: `postgres`
- Banco: `literatura`

## 📚 Funcionalidades Disponíveis

- ✅ Buscar livros na API Gutendex
- ✅ Salvar livros no banco PostgreSQL
- ✅ Listar livros registrados
- ✅ Listar autores
- ✅ Buscar autores por ano
- ✅ Filtrar livros por idioma
- ✅ Top 10 livros mais baixados
- ✅ Buscar autor por nome

## 🆘 Solução de Problemas

**Erro de conexão com banco:**
- Verifique se o PostgreSQL está rodando
- Confirme as credenciais no `application.properties`

**Erro na API:**
- Verifique a conexão com a internet
- A API pode estar temporariamente indisponível

**Erro de compilação:**
- Verifique se o Java 17+ está instalado
- Execute: `mvn clean install`

## 📞 Suporte

- Consulte o `README.md` para documentação completa
- Veja `EXEMPLO_USO.md` para exemplos detalhados
- Verifique `database-setup.sql` para configuração do banco

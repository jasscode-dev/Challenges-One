-- Script para configurar o banco de dados do projeto LiterAlura
-- Execute este script no PostgreSQL

-- Criar o banco de dados
CREATE DATABASE literatura;

-- Conectar ao banco de dados (execute no terminal)
-- \c literatura

-- As tabelas serão criadas automaticamente pelo Hibernate quando a aplicação for executada
-- Tabelas que serão criadas:
-- - autores (id, nome, ano_nascimento, ano_falecimento)
-- - livros (id, titulo, idioma, downloads, autor_id)

-- Para verificar se as tabelas foram criadas:
-- \dt

-- Para ver a estrutura das tabelas:
-- \d autores
-- \d livros

# ForumHub - API REST para Fórum

Uma API REST completa para gerenciamento de tópicos de fórum com autenticação JWT, desenvolvida em Spring Boot.

## Funcionalidades

- ✅ Autenticação JWT
- ✅ Registro e login de usuários
- ✅ CRUD completo de tópicos
- ✅ Validação de dados
- ✅ Persistência com H2 Database
- ✅ Arquitetura MVC
- ✅ Segurança com Spring Security

## Tecnologias Utilizadas

- **Spring Boot 3.5.4**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database**
- **JWT (JSON Web Tokens)**
- **Maven**
- **Java 17**

## Estrutura do Projeto

```
ForumHub/
├── src/main/java/br/com/alura/ForumHub/
│   ├── config/           # Configurações (Security, Authentication)
│   ├── controller/       # Controladores REST
│   ├── dto/             # Data Transfer Objects
│   ├── model/           # Entidades JPA
│   ├── repository/      # Repositórios JPA
│   ├── security/        # Filtros de segurança
│   └── service/         # Lógica de negócio
└── src/main/resources/
    └── application.properties
```

## Como Executar

1. **Clone o repositório**
2. **Execute o projeto:**
   ```bash
   mvn spring-boot:run
   ```
3. **Acesse a aplicação:**
   - API: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console

## Endpoints da API

### Autenticação

#### Registro
```http
POST /api/auth/register
Content-Type: application/json

{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456"
}
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "joao@email.com",
  "senha": "123456"
}
```

### Tópicos

#### Criar Tópico
```http
POST /api/topicos
Authorization: Bearer {token}
Content-Type: application/json

{
  "titulo": "Dúvida sobre Spring Boot",
  "nomeCurso": "Spring Boot",
  "mensagem": "Estou com dúvida sobre como configurar o Spring Security..."
}
```

#### Listar Todos os Tópicos
```http
GET /api/topicos
Authorization: Bearer {token}
```

#### Buscar Tópico por ID
```http
GET /api/topicos/{id}
Authorization: Bearer {token}
```

#### Buscar Tópicos por Curso
```http
GET /api/topicos/curso/{nomeCurso}
Authorization: Bearer {token}
```

#### Buscar Meus Tópicos
```http
GET /api/topicos/meus-topicos
Authorization: Bearer {token}
```

#### Atualizar Tópico
```http
PUT /api/topicos/{id}
Authorization: Bearer {token}
Content-Type: application/json

{
  "titulo": "Título atualizado",
  "nomeCurso": "Curso atualizado",
  "mensagem": "Mensagem atualizada..."
}
```

#### Deletar Tópico
```http
DELETE /api/topicos/{id}
Authorization: Bearer {token}
```

## Estrutura de Dados

### Usuario
- `id` (Long)
- `nome` (String, obrigatório, 2-100 caracteres)
- `email` (String, obrigatório, único)
- `senha` (String, obrigatório, mínimo 6 caracteres)
- `dataCriacao` (LocalDateTime)

### Topico
- `id` (Long)
- `titulo` (String, obrigatório, 5-200 caracteres)
- `nomeCurso` (String, obrigatório, 2-100 caracteres)
- `mensagem` (String, obrigatório, 10-2000 caracteres)
- `dataCriacao` (LocalDateTime)
- `autor` (Usuario, obrigatório)

## Validações

### Usuario
- Nome: 2-100 caracteres
- Email: formato válido e único
- Senha: mínimo 6 caracteres

### Topico
- Título: 5-200 caracteres
- Nome do curso: 2-100 caracteres
- Mensagem: 10-2000 caracteres

## Segurança

- Autenticação JWT obrigatória para endpoints de tópicos
- Senhas criptografadas com BCrypt
- Validação de autorização para edição/deleção de tópicos
- Apenas o autor pode editar/deletar seus próprios tópicos

## Banco de Dados

- **H2 Database** (memória)
- **Console H2**: http://localhost:8080/h2-console
- **JDBC URL**: jdbc:h2:mem:forumdb
- **Usuário**: sa
- **Senha**: password

## Exemplos de Uso

### 1. Registrar usuário
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria Silva",
    "email": "maria@email.com",
    "senha": "123456"
  }'
```

### 2. Fazer login
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "maria@email.com",
    "senha": "123456"
  }'
```

### 3. Criar tópico
```bash
curl -X POST http://localhost:8080/api/topicos \
  -H "Authorization: Bearer {seu_token}" \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Como usar Spring Boot?",
    "nomeCurso": "Spring Boot",
    "mensagem": "Preciso de ajuda para começar com Spring Boot..."
  }'
```

## Status Codes

- `200 OK`: Sucesso
- `201 Created`: Recurso criado
- `204 No Content`: Sucesso sem retorno
- `400 Bad Request`: Dados inválidos
- `401 Unauthorized`: Não autenticado
- `403 Forbidden`: Não autorizado
- `404 Not Found`: Recurso não encontrado
- `500 Internal Server Error`: Erro interno

## Desenvolvimento

Para executar em modo desenvolvimento:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Testes

Para executar os testes:

```bash
mvn test
```

## Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature
3. Commit suas mudanças
4. Push para a branch
5. Abra um Pull Request

## Licença

Este projeto está sob a licença MIT. 
# Conversor de Moedas

Uma aplicação Java simples e intuitiva para conversão de moedas em tempo real, utilizando a API ExchangeRate-API para obter cotações atualizadas.

## 📋 Funcionalidades

- Conversão entre múltiplas moedas com taxas de câmbio em tempo real
- Interface de linha de comando interativa
- Suporte para as seguintes conversões:
    - Dólar Americano (USD) ⇄ Peso Argentino (ARS)
    - Dólar Americano (USD) ⇄ Real Brasileiro (BRL)
    - Dólar Americano (USD) ⇄ Peso Colombiano (COP)
- Tratamento robusto de erros e validação de entrada
- Formatação decimal para valores monetários

## 🛠️ Tecnologias Utilizadas

- **Java 11+**
- **Gson** - Para deserialização JSON
- **ExchangeRate-API** - API de cotações de moedas
- **Dotenv** - Gerenciamento de variáveis de ambiente
- **HttpClient** - Cliente HTTP nativo do Java

## 📦 Estrutura do Projeto

```
src/
├── Main.java                 # Classe principal com interface do usuário
├── models/
│   ├── ConvertCurrency.java  # Modelo para dados de conversão
│   └── Exchange.java         # Record para resposta da API
└── service/
    └── ExchangeService.java  # Serviço de comunicação com a API
```

## ⚙️ Configuração

### Pré-requisitos

- Java 11 ou superior
- Maven ou Gradle (para gerenciamento de dependências)
- Chave da API do ExchangeRate-API

### Dependências Maven

```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
    <dependency>
        <groupId>io.github.cdimascio</groupId>
        <artifactId>dotenv-java</artifactId>
        <version>3.0.0</version>
    </dependency>
</dependencies>
```

### Configuração da API

1. Registre-se em [ExchangeRate-API](https://www.exchangerate-api.com/)
2. Obtenha sua chave da API gratuita
3. Crie um arquivo `.env` na raiz do projeto:

```env
API_KEY=sua_chave_da_api_aqui
```

## 🚀 Como Executar

1. Clone o repositório
2. Configure as dependências e a chave da API
3. Compile o projeto:
   ```bash
   javac -cp ".:lib/*" Main.java
   ```
4. Execute a aplicação:
   ```bash
   java -cp ".:lib/*" Main
   ```

## 💡 Como Usar

1. Execute a aplicação
2. Escolha uma das opções de conversão (1-6)
3. Digite o valor que deseja converter
4. Veja o resultado da conversão
5. Repita o processo ou digite 7 para sair

### Exemplo de Uso

```
***************************************
Seja bem-vindo/a ao Conversor de Moeda =]
***************************************
1) Dólar >>> Peso argentino
2) Peso argentino >>> Dólar
3) Dólar >>> Real brasileiro
4) Real brasileiro >>> Dólar
5) Dólar >>> Peso colombiano
6) Peso colombiano >>> Dólar
7) Sair

Escolha uma opção válida: 3
Digite o valor que deseja converter: 100
Valor 100,00 [USD] corresponde ao valor final de => 518,50 [BRL]
```

## 🏗️ Arquitetura

### Componentes Principais

- **Main**: Interface do usuário com menu interativo
- **ExchangeService**: Gerencia requisições HTTP para a API
- **Exchange**: Record que representa a resposta da API
- **ConvertCurrency**: Modelo que encapsula dados da conversão com formatação

### Padrões Utilizados

- **Service Layer**: Separação da lógica de negócio
- **Data Transfer Objects**: Records para transferência de dados
- **Environment Variables**: Configuração segura da API key

## 🔧 Tratamento de Erros

A aplicação possui tratamento robusto para:
- Entradas inválidas do usuário
- Falhas na comunicação com a API
- Códigos de status HTTP não sucessos
- Exceções de rede e parsing JSON


## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.


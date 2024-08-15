[Versão em Português](#versão-em-português) | [English Version](#english-version)

# Construção de uma API RESTful com Spring Boot

## Versão em Português

### O que há nesse projeto

- Ecossistema Spring
- Products API RESTful
- Conexão com a base de dados Postgres
- Model e mapeamento da entidade Product
- Criação do Repository com JpaRepository

  #### Métodos do Controller:

  - **`POST /products`**: Cria um novo produto com base nos dados fornecidos no corpo da requisição. Os dados são validados e, se corretos, são salvos no banco de dados.
  - **`GET /products`**: Retorna uma lista de todos os produtos cadastrados. Cada produto na lista inclui um link para visualizar os detalhes do produto específico.
  - **`GET /products/{id}`**: Retorna os detalhes de um produto específico com base no `id` fornecido na URL. Se o produto não for encontrado, retorna um erro 404.
  - **`PUT /products/{id}`**: Atualiza as informações de um produto existente com base no `id` fornecido na URL e nos dados fornecidos no corpo da requisição. Se o produto não for encontrado, retorna um erro 404.
  - **`DELETE /products/{id}`**: Exclui um produto específico com base no `id` fornecido na URL. Se o produto não for encontrado, retorna um erro 404.

### Preparação do Ambiente

Antes de começar, certifique-se de ter os seguintes componentes configurados:

- **Maven**: Para gerenciar dependências.
- **Postman**: Para testar as requisições HTTP.
- **PgAdmin** (Postgres): Para gerenciar o banco de dados PostgreSQL.
- **IDE** (IntelliJ, STS, Eclipse, etc): Para caso queira fazer alguma alteração no código do projeto.

## English Version

### What is in this project

- Spring Ecosystem
- Products RESTful API
- Connection to Postgres database
- Model and mapping of the Product entity
- Repository creation with JpaRepository

  #### Controller Methods:

  - **`POST /products`**: Creates a new product based on the data provided in the request body. The data is validated and, if correct, is saved to the database.
  - **`GET /products`**: Returns a list of all registered products. Each product in the list includes a link to view the specific product details.
  - **`GET /products/{id}`**: Returns the details of a specific product based on the `id` provided in the URL. If the product is not found, it returns a 404 error.
  - **`PUT /products/{id}`**: Updates the information of an existing product based on the `id` provided in the URL and the data provided in the request body. If the product is not found, it returns a 404 error.
  - **`DELETE /products/{id}`**: Deletes a specific product based on the `id` provided in the URL. If the product is not found, it returns a 404 error.

### Environment Setup

Before starting, make sure you have the following components configured:

- **Maven**: To manage dependencies.
- **Postman**: To test HTTP requests.
- **PgAdmin** (Postgres): To manage the PostgreSQL database.
- **IDE** (IntelliJ, STS, Eclipse, etc): In case you want to make any changes to the project code.

# Construção de uma API RESTful com Spring Boot

## O que há nesse projeto

- Ecossistema Spring
- Products API RESTful
- Conexão com a base de dados Postgres
- Model e mapeamento da entidade Product
- Criação do Repository com JpaRepository

  ### Métodos do Controller:

  - **`POST /products`**: Cria um novo produto com base nos dados fornecidos no corpo da requisição. Os dados são validados e, se corretos, são salvos no banco de dados.
  - **`GET /products`**: Retorna uma lista de todos os produtos cadastrados. Cada produto na lista inclui um link para visualizar os detalhes do produto específico.
  - **`GET /products/{id}`**: Retorna os detalhes de um produto específico com base no `id` fornecido na URL. Se o produto não for encontrado, retorna um erro 404.
  - **`PUT /products/{id}`**: Atualiza as informações de um produto existente com base no `id` fornecido na URL e nos dados fornecidos no corpo da requisição. Se o produto não for encontrado, retorna um erro 404.
  - **`DELETE /products/{id}`**: Exclui um produto específico com base no `id` fornecido na URL. Se o produto não for encontrado, retorna um erro 404.

## Preparação do Ambiente

Antes de começar, certifique-se de ter os seguintes componentes configurados:

- **Maven**: Para gerenciar dependências.
- **Postman**: Para testar as requisições HTTP.
- **PgAdmin** (Postgres): Para gerenciar o banco de dados PostgreSQL.
- **IDE** (IntelliJ, STS, Eclipse, etc): Para desenvolver o projeto.

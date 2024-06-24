# 

<h1 align="center">
  BookStore
</h1>


API REST de uma livraria usando boas praticas de patterns


## Tecnologias
 
- [Spring Boot]
- [Spring MVC]
- [Spring Data JPA]
- [SpringDoc OpenAPI 3]
- [PostgresSQL]
- [Spring Validation]
- [Lombok]


## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/bookstore-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

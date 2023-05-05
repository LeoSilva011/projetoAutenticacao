

# Projeto de Autenticação e Geração de Bearer Token com Spring#

Este projeto é uma implementação de um sistema de autenticação e geração de Bearer Token para APIs utilizando o framework Spring.

## O sistema foi construído utilizando as seguintes tecnologias:

- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JSON Web Tokens (JWT)


## Funcionalidades
O sistema possui as seguintes funcionalidades:

- Registro de usuários
- Autenticação de usuários
- Geração de Bearer Token
- Verificação de autenticação em rotas protegidas


Após configurar o sistema, você pode realizar as seguintes operações:

## Registro de Usuários
Para registrar um usuário, envie uma requisição POST para a rota /salvar com o seguinte corpo:
*** Exemplo: localhost:8080/usuarios/salvar ***

*** Exemplo json para cadastro ***

```
{
  "name": "Nome do Usuário",
  "email": "email@exemplo.com",
  "password": "senha123"
}
```
## Autenticação de Usuários
Para autenticar um usuário, envie uma requisição POST para a rota /login com o seguinte corpo:
*** Exemplo: localhost:8080/usuarios/login ***
*** Exemplo json para autenticação ***

```
{
  "email": "email@exemplo.com",
  "password": "senha123"
}
```

Se as credenciais estiverem corretas, o sistema retornará um Bearer Token que pode ser utilizado em requisições posteriores.

## Listar Usuarios utilizando o Token
Para fazer um teste com o token gerado na autenticação tem um endpoint de listar todos os usuarios cadastrados.

Requisição GET /listar.

*** Exemplo: localhost:8080/usuarios/listar ***

Se o token estiver correto, o sistema retornará uma resposta com o status 200 OK. Caso contrário, a resposta terá o status 403 Forbidden.

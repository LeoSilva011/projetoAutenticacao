

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

**Exemplo: localhost:8080/usuarios/salvar**

**Exemplo json para cadastro**

```
{
  "name": "Nome do Usuário",
  "email": "email@exemplo.com",
  "password": "senha123"
}
```
## Autenticação de Usuários
Para autenticar um usuário, envie uma requisição POST para a rota /login com o seguinte corpo:

**Exemplo: localhost:8080/usuarios/login**

**Exemplo json para autenticação**

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

**Exemplo: localhost:8080/usuarios/listar**

O token deve ser inserido no headers da requisição da seguinte forma:

**Authorization Bearer token**

![image](https://user-images.githubusercontent.com/62224303/236489217-53bede32-02fe-4000-8f77-39fb6efc63c9.png)

ou da seguinte forma 

![image](https://user-images.githubusercontent.com/62224303/236489582-6b309612-94e5-47ce-accd-fd5119b3b3a2.png)
No postman existe a aba authorization que permite a utilização do token de forma mais simplificada, basta selecionar a aba authorization e selecionar o tipo de autenticação Beared Token, em seguida basta colar o token no campo sem a necessidade de colocar a palavra Bearer no campo.

 

Se o token estiver correto, o sistema retornará uma resposta com o status 200 OK. Caso contrário, a resposta terá o status 403 Forbidden.

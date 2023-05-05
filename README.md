

#Projeto de Autenticação e Geração de Bearer Token com Spring#

Este projeto é uma implementação de um sistema de autenticação e geração de Bearer Token para APIs utilizando o framework Spring.

O sistema foi construído utilizando as seguintes tecnologias:

-Spring Boot
-Spring Security
-Spring Data JPA
-Hibernate
-JSON Web Tokens (JWT)


##Funcionalidades
O sistema possui as seguintes funcionalidades:

Registro de usuários
Autenticação de usuários
Geração de Bearer Token
Verificação de autenticação em rotas protegidas
Configuração
Para configurar o sistema, siga as instruções abaixo:

Clone este repositório para o seu computador.
Certifique-se de ter o Java e o Maven instalados na sua máquina.
Configure as credenciais de acesso ao banco de dados no arquivo application.properties na pasta src/main/resources.
Execute o comando mvn clean install para instalar as dependências do projeto e compilar o código.
Execute o comando mvn spring-boot:run para iniciar o servidor.
Uso
Após configurar o sistema, você pode realizar as seguintes operações:

Registro de Usuários
Para registrar um usuário, envie uma requisição POST para a rota /register com o seguinte corpo:

exemplo json

`{
  "name": "Nome do Usuário",
  "email": "email@exemplo.com",
  "password": "senha123"
}`
Autenticação de Usuários
Para autenticar um usuário, envie uma requisição POST para a rota /login com o seguinte corpo:

exemplo json

`{
  "email": "email@exemplo.com",
  "password": "senha123"
}`

Se as credenciais estiverem corretas, o sistema retornará um Bearer Token que pode ser utilizado em requisições posteriores.

Verificação de Autenticação
Para verificar se um usuário está autenticado, envie uma requisição GET para uma rota protegida (por exemplo, /protected) com o seguinte cabeçalho:

makefile
Copy code
Authorization: Bearer <token>
Substitua <token> pelo Bearer Token gerado na autenticação do usuário.

Se o token estiver correto, o sistema retornará uma resposta com o status 200 OK. Caso contrário, a resposta terá o status 401 Unauthorized.

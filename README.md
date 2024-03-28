# API REST em Spring para Gerenciamento de Pessoas

![Captura de tela 2024-03-28 165933](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/ed0bb619-853b-4b79-8fc0-d06ed60a826c)

API REST em Spring Boot para cadastro de pessoas, utilizando os métodos HTTP GET, POST, PUT e DELETE.

## Tecnologias utilizadas no desenvolvimento da API
- Java 17
- Spring Framework
- Postman
- SQLlite

## Configuração do Ambiente

Antes de começar, certifique-se de ter o ambiente de desenvolvimento configurado com as seguintes ferramentas:
- Java 17
- Maven
- IDE de sua preferência (Eclipse, IntelliJ, etc.)
- Postman

## Estrutura do Projeto

A estrutura do projeto segue os padrões do Spring Boot, incluindo os pacotes para entidades, repositórios, serviços e controladores.

## Método GET
- Utilizar "localhost:8080/pessoas" no postman para listar todas as pessoas cadastradas no banco em formato JSON. Exemplo:

![Captura de tela 2024-03-28 165933](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/55679855-70fb-4598-9b04-82dd3ebec7de)

## Método POST
- Utilizar "localhost:8080/pessoas" no postman para cadastrar uma nova pessoa, lembre-se de passar os campos nome; sobrenome; cpf e status_id. Obs: o Status 1 significa que a pessoa está "ativa" e 2 "inativa". Exemplo:

![Captura de tela 2024-03-28 170043](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/8512d9c6-c765-4f56-8c92-c9a418614429)

## Método PUT
- Utilizar "localhost:8080/pessoas" + o número do id da pessoa para atualizar o cadastro. Lembre-se de passar os campos nome; sobrenome; cpf e status_id para efetuar a atualização do cadastro. Exemplo:

![Captura de tela 2024-03-28 164601](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/d7855a5d-746c-4a7a-a9c9-74b519a176f7)

![Captura de tela 2024-03-28 164626](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/6205350e-5073-4720-8b7d-70077e5a1c62)

![Captura de tela 2024-03-28 164643](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/079ded11-76e2-4ac5-8de3-1a3ed96bc967)

## Método DELETE
- Utilizar "localhost:8080/pessoa" + o número do id da pessoa para deletar o cadastro. Exemplo:

![Captura de tela 2024-03-28 164859](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/e030091a-73a4-48b3-bdc7-7122d545c25c)

## Pesquisar Informações
- Utilizar "localhost:8080/pessoa?" + o campo desejado e o valor para efetuar a pesquisa. Exemplo:

![Captura de tela 2024-03-28 165227](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/d4c336f7-af43-4ab4-9902-67114d357256)

Ou

![Captura de tela 2024-03-28 165300](https://github.com/EriveltonMatos/teste-tecnico/assets/103468962/321a1af8-7984-4b12-b713-6dc9a66965f0)








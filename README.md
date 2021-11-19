# Projeto API Votação por associado
#### VOTE API

## Projeto
A api se encontra no heroku já com a base de dados e pode ser rodada e pode ser iniciada localmente.

## Funcionalidades e Observações

- [x] - Cadastro de Pauta (Schedule)
- [x] - Lista de Pautas
- [x] - Busca Pautas do ID
- [x] - Atualizar Pautas por ID
- [x] - Cadastrar uma sessão com inicio e fim de execução
- [x] - Ao abrir uma sessão apenas informar o id da paulta e o tempo que ela vai ficar aberta, se não informar nada no tempo por default o valor é 1 min.
- [x] - Fechar a Sessão, foi criado um JOB que verifica se existe alguma sessão aberta e se o tempo limite dela está expirado, ai ele automaticamente fecha a sessão.
- [x] - Iniciar a votação inserindo apenas o voto o cpf e o id da sessão.
- [x] - Validações de CPF, e Campos implementado
- [x] - Validação de CPF via API user-info
- [x] - Foi implementado uma breve documentação para implementação em front para entender cada requisição.  
- [x] - Foi emplementado testes nos controles e nos seriços com jUnit e Mockito.
- [x] - Foi útilizado a IDE Intellij para criar o projeto.
- [x] - Foi Utilizado o Modelmappar para gerenciar os mapeamentos de DTO e Entidade.


## Recomendações
#### Projeto*Projeto feito com:
    Intellij
    JAVA 1.8, 
    Spring 2.5.6, 
    Spring Data JPA, 
    RESTFULL API, 
    flywayDB, 
    Lombok, 
    Bean Validation,
    Swagger2,
    ModelMapper,
    MySQL,
    Heroku - Integração continua. 

Projeto feito com dois ambientes (production e development), basta abrir o application.yml e selecionar qual ambiente deseja executar.

API que realiza um cadastro de pautas, para poder abrir uma sessão para votação com limites de tempo para voto,
## Acesso a API
#### Para acessar a api no link abaixo:
    swagger: https://vote-api-developer-kk9dujxn2ma.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#
    
    Rodando em Ambiente Developer
    API_URL_BASE: https://vote-api-developer-kk9dujxn2ma.herokuapp.com

## Profissional

[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/AndersonSAndrade)](https://github.com/AndersonSAndrade)
[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/anderson-s-andrade-59b38564/)](https://www.linkedin.com/in/anderson-s-andrade-59b38564/)

### Saber mais
- [Website](https://andersonsandrade.github.io/adsdev.github.io/) 💻 - Especificações e Trabalhos.

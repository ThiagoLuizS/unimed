# Documentação
### Introdução Seguro Unimed


### Projeto para execução na maquina local

#### <strong>Para executar o projeto é necessário que tenha o docker rodando na sua maquina local. </strong> </br>

<strong>Observação: Nesse projeto iremos utilizar o JAVA 23.</strong>

Para esse projeto irei utilizar o <b>MySQL</b>. </br>

Utilizaremos uma imagem docker do MySQL, sendo necessário executar o seguinte comando na pasta /docker/mysql que se encontra no projeto.

```
docker-compose up -d
```
Após a execução desse comando, a imagem será baixada. Utilize o comando abaixo:

```
docker ps
```
Deverá ser exibido um log semelhante a este no console:

```
CONTAINER ID   IMAGE       COMMAND                  CREATED        STATUS       PORTS                                                  NAMES
28e72da5ce38   mysql:8.0   "docker-entrypoint.s…"   25 hours ago   Up 7 hours   0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp   mysql
```

Configuração do banco H2 definida no application.yml:

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/unimed?useTimezone=true&serverTimezone=UTC
    username: unimed
    password: 12345678
  jpa:
    properties:
      hibernate.dialect: org.hibernate.dialect.MySQL8Dialect
```

Com a aplicação iniciada e sem haver nenhum problema em seu funcionamento é possivel obter o mapeamento dos endpoints através do <b>Swagger</b>, acessando a url:
```
http://localhost:8080/swagger-ui/index.html
```

### Regras de Negócio

Para estrutura de pastas do projeto está sendo utilizado o MVC. Separados com os seguintes nomes

<ol>
    <li>Resource(interfaces)</li>
    <li>Controller</li>
    <li>Service</li>
    <li>Repository</li>
    <li>Annotation</li>
    <li>Exception</li>
    <li>Configuration</li>
</ol>

- <b>Resource</b>

  Interfaces com os métodos definidos com anotações spring.web (métodos HTTP). As interfaces nessa pasta são implementadas nas classes de controler.

- <b>Controller</b>

  Classes que implementam a resource (interface) e tem como anotação em sua assinatura definir seu objetivo de criação de métodos de entrada e saída de dados. (Endpoints).

- <b>Service</b>

  Classes de serviço que contemplam todas as regras de negócio do projeto. Essas classes injetam repositórios, mapeamentos e validações.

- <b>Repository</b>

  Interfaces que extendem a JPA e tem como objetivo construir uma ponte para camadas de persitências de dados utilizando a lib do Hibernate ou SpringData

- <b>Annotation</b>

  Interfaces de anotação criadas para auxiliar na validação de métodos e atributos. Como validações e injeções de Beans.

- <b>Exception</b>

  Classes que agregam todas as exceções não tratadas por meio de um interceptor advance e convertida em um retorno padrão. Por meio dela é possivel controlar o tipo de exceção, mensagem e corpo do response nas requisições HTTP.

- <b>Configuration</b>

  Classes com objetivo de injetar uma biblioteca no scopo de inicialização de uma aplicação, parametrizar o funcionamento destas libs, configurar partes de segurança e replicar funcionalidades para diversos componentes.

#### Cacheable

A implementação do cache no método de salvar o voto, é uma boa pratica para reduzir o consumo e processamento de memória tanto da aplicação quanto do banco de dados. Em cenários que ocorrem duplos clickes ou tentativas de salvar ou obter dados repetidos. No entanto o cacheamento não substitui totalmente as regras de validação, sendo essas necessárias quando o cache expirar ou por algum momento não funcionar.

#### Scheduled

De forma mais simplória, foi utilizado o Scheduler via anotação na classe CacheConfig. O objetivo é demonstrar como podemos chamar um método para que outras anotações injetadas/definidas na sua assinatura possam ser executadas por baixo. Nesse cenário utilizei o Schedule que será executado de tempos em tempos para que a anotação CacheEvict faça a limpeza dos históricos do cache.

#### Entidades

Estudando conforme o desafio. Eu vi uma melhoria significativa ao implementar os relacionamentos entre as entidades, ao definir os mappedBy sem referenciar o objeto classe, mas sim o atributo ID diretamente. Evitando assim a recursividade infinita (StackOverflowError). Com um relacionamento definido de forma simples foi possivel atender o objetivo.

### NOTAS

<i>O histórico de evolução da criação do projeto pode ser visto nos commits. Comentei de forma clara e objetiva o que foi feito por etapas. </i>
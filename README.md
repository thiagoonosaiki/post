# Consulta de Solicitações de Viagem

## Descrição
Aplicação Java 17 com Spring Boot responsável por consultar solicitações
de viagem via serviço SOAP (Lemontech), processar os dados e persistir
as informações em banco de dados PostgreSQL.

## Arquitetura
O projeto segue uma arquitetura em camadas:

- Service: Regras de negócio e orquestração
- Integration (SOAP Client): Comunicação com serviço externo
- Mapper: Conversão SOAP → Entidades
- Repository: Persistência com Spring Data JPA

- A persistência das solicitações é realizada por um serviço dedicado, responsável por converter o modelo externo SOAP em entidades JPA,
- garantindo isolamento de responsabilidades, transações e manutenção facilitada. (PersistirSolicitacaoService)

- O acesso ao banco de dados é realizado através de repositórios JPA, utilizando Spring Data para
- simplificar operações CRUD e manter baixo acoplamento com a camada de persistência. (SolicitacaoRepository)

- Os estados da solicitação são modelados através de uma enumeração de domínio, garantindo tipagem forte,
- clareza semântica e integridade das regras de negócio. (StatusSolciitacaoEntity)

- A conversão entre o modelo SOAP e o modelo de domínio é realizada por mappers dedicados,
- garantindo isolamento entre camadas, preservação dos relacionamentos e facilidade de manutenção. (SolicitacaoEntityMapper)

## Tecnologias
- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- SOAP (JAX-WS)
- Maven

## Configuração
As configurações estão no arquivo `application.yml`.

Exemplo:
```yaml
spring:

  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: admin
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: create
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect

  soap:
      key-client: base_teste_qa
      username: d0804903bf4eeefddf55c63fc600ed5c
      password: 5c11ca0bf738c2dbb460479530b26db0
server:
  port: 8080


```
## Como executar ##

Clonar o projeto

Configurar o banco de dados no `application.yml`

Configurar variáveis de ambiente executando `mvn clean generate-sources` no terminal

Executar: `mvn spring-boot:run`

Verificar conteudo no banco de dados (caso configurado e testado com PostgreSQL)

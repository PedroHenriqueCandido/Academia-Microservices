
```md
# User Service

O **User Service** é um dos microserviços da plataforma SaaS de academia. Ele é responsável por gerenciar os dados dos usuários e se comunicar com o **Auth Service** para registro e autenticação.

## 📦 Estrutura do Projeto

Pacote principal:
```
com.academia.userservice
```

Classe principal:

```java
@SpringBootApplication
@EnableFeignClients
public class UserserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }
}
```

- `@SpringBootApplication`: Habilita a auto-configuração e o escaneamento de componentes do Spring Boot.
- `@EnableFeignClients`: Ativa os clientes Feign para comunicação com outros microserviços, como o Auth Service.

## ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- OpenFeign
- Docker & Docker Compose

## 🔌 Comunicação entre serviços

Este microserviço usa **Feign Client** para se comunicar com o `authservice`, facilitando chamadas HTTP REST internas entre os serviços.

## ⚙️ Configurações principais (application.properties)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/userdb
spring.datasource.username=postgres
spring.datasource.password=p3dr0h3n
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8081
```

## 🐳 Docker

Este microserviço está configurado para rodar via Docker e integrado ao `docker-compose.yml` principal.

```yaml
userservice:
  build:
    context: ./userservice
  container_name: userservice
  ports:
    - "8081:8081"
  depends_on:
    - postgres
  environment:
    SPRING_PROFILES_ACTIVE: default
  networks:
    - backend
---

**Autor:** Pedro Henrique Candido
``` 
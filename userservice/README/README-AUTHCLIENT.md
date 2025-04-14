
```md
# 🔗 AuthClient - Feign Interface

O `AuthClient` é uma interface do **User Service** que utiliza **OpenFeign** para consumir endpoints do microserviço **Auth Service**. Essa interface simplifica a comunicação REST entre os microsserviços, delegando autenticação e registro de usuários ao Auth Service.

---

## 📁 Localização

`com.academia.userservice.client.AuthClient`

---

## ⚙️ Dependência

Certifique-se de que o projeto esteja com a dependência do Feign declarada no `pom.xml`:

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

---

## 🔧 Configuração

No `application.properties`:

```properties
auth.service.url=http://authservice:8080
```

---

## ✉️ Endpoints Consumidos

| Método | Rota                   | Descrição                 |
|--------|------------------------|---------------------------|
| POST   | `/auth/register`       | Registra novo usuário     |
| POST   | `/auth/login`          | Autentica e gera token    |

---

## 🧩 Interface Feign

```java
@FeignClient(name = "auth-service", url = "${auth.service.url}/auth")
public interface AuthClient {

    @PostMapping("/register")
    void registerUser(AuthRegistrationRequest request);
    
    @PostMapping("/login")
    AuthResponse loginUser(@RequestBody AuthLoginRequest request);
}
```

---

## 📌 Notas

- Essa interface permite que o `UserService` delegue as operações de autenticação ao `AuthService`.
- O login retorna um `AuthResponse` com token JWT e outras informações.
- O registro apenas envia os dados ao Auth Service — não retorna nada.

---

## 🛡️ Segurança

Os dados enviados e recebidos aqui estão relacionados à segurança da aplicação. É essencial que:

- A comunicação entre serviços em produção use HTTPS (SSL).
- Tokens JWT sejam tratados com segurança no front-end.

---

## 👤 Autor

Pedro Henrique Candido
```
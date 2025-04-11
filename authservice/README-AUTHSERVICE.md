
# Auth Service - Academia SaaS 🏋️‍♂️🔐

Este microserviço é responsável pela autenticação e autorização de usuários na aplicação SaaS para academias. Ele fornece endpoints para registro, login e proteção de rotas com JWT e controle de roles (USER/ADMIN).

---

## 🔧 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT (Json Web Token)
- Maven
- JPA + Hibernate
- MySQL
- Docker (opcional)
- Postman (para testes)

---

## 📁 Estrutura de Pacotes

```
com.academia.authservice
├── config              → Filtros de segurança e configuração JWT
├── controller          → Endpoints públicos
├── dto                 → Objetos de entrada/saída
├── models              → Entidades do banco de dados
├── repository          → Interfaces JPA
├── security            → Utilitários de segurança como geração e validação de JWT
├── service             → Regras de negócio (registro, autenticação)
└── AuthServiceApplication.java
```

---

## 📌 Endpoints

### 🔓 Público
| Método | Rota             | Descrição           |
|--------|------------------|---------------------|
| POST   | /auth/register   | Registro de usuário |
| POST   | /auth/login      | Autenticação (login) e retorno do token JWT |

### 🔒 Protegido com JWT

#### Requer `ROLE_USER` ou `ROLE_ADMIN`
| Método | Rota          | Descrição                |
|--------|---------------|--------------------------|
| GET    | /user/test    | Teste de rota protegida  |

#### Requer `ROLE_ADMIN`
| Método | Rota           | Descrição               |
|--------|----------------|-------------------------|
| GET    | /admin/test    | Teste exclusivo para ADMIN |

---

## 🛡️ Segurança

- Filtro personalizado: `JwtAuthFilter` lê o token JWT do header e valida.
- Configuração de segurança via `SecurityConfig.java`.
- Roles adicionadas no token e convertidas para `GrantedAuthority`.

---

## 🔐 Geração de Token

JWT gerado com:
- Assinatura HMAC (HS512)
- Validade: 24 horas
- Claims:
  - `sub` (email)
  - `role` (USER ou ADMIN)

---

## 📄 Exemplo de Request e Response

### 🔸 Registro

**POST /auth/register**

```json
{
  "email": "user@academia.com",
  "password": "123456",
  "role": "USER"
}
```

### 🔸 Login

**POST /auth/login**

```json
{
  "email": "user@academia.com",
  "password": "123456"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9..."
}
```

### 🔸 Header para acessar rotas protegidas

```
Authorization: Bearer {token}
```

---

## 🧪 Testando com Postman

1. Faça login e copie o token JWT.
2. Acesse `/user/test` ou `/admin/test` com o token no header:
   ```
   Authorization: Bearer seu_token_jwt
   ```

---

## 🐳 Docker (opcional)

Você pode incluir um `Dockerfile` e `docker-compose.yml` para rodar o serviço com MySQL.

---

## 📌 Variáveis de Ambiente

No `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/authdb
spring.datasource.username=root
spring.datasource.password=senha
jwt.secret=SUA_CHAVE_SECRETA_FORTE
```

---

## ✅ Próximos passos

- Criar serviço de usuários separado
- Implementar recuperação de senha
- Integração com serviço de email
- Monitoramento com Spring Actuator

---

## 👨‍💻 Autor

Desenvolvido por **Pedro Henrique Candido** 💻  
Projeto SaaS para gestão de academias - 2025

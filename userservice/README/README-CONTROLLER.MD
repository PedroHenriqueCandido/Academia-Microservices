
```md
# 📘 UserController - API de Usuários

Este controller gerencia operações relacionadas a usuários dentro do sistema, como registro, login, consulta, edição e exclusão. Ele atua como ponte entre a requisição HTTP e a lógica de negócio definida em `UserService`.

---

## 📍 Endpoint Base

```
/api
```

---

## 🔄 Endpoints Disponíveis

### 🔐 POST `/register`
Cadastra um novo usuário.

- **Request Body**: Objeto `User` (deve conter senha).
- **Retorno**: Objeto `User` criado.
- **Processo**: Envia dados ao `AuthService` e persiste no banco local.

---

### 🔑 POST `/login`
Realiza o login do usuário.

- **Request Body**: Objeto `AuthLoginRequest` (email + senha).
- **Retorno**: Objeto `AuthResponse` com token JWT.

---

### 📩 GET `/{email}`
Busca usuário por email.

- **Path Variable**: `email` (String).
- **Retorno**: Objeto `User` correspondente.

---

### ✏️ PUT `/{id}`
Atualiza um usuário.

- **Path Variable**: `id` (Long).
- **Request Body**: Objeto `User` com novos dados.
- **Retorno**: Usuário atualizado.

---

### ❌ DELETE `/{id}`
Deleta um usuário.

- **Path Variable**: `id` (Long).
- **Retorno**: Nenhum (HTTP 204 esperado).

---

### 📋 GET `/`
Lista todos os usuários.

- **Retorno**: Lista de objetos `User`.
- **Acesso**: Idealmente restrito (ex: admin).

---

## 🧠 Observações Técnicas

- Usa `@RestController` e `@RequestMapping("/api")` como base para a rota.
- Injeta `UserService` com `@Autowired`.
- O método de login se conecta ao `AuthService` via Feign Client (`AuthClient`).
- Todas as requisições esperam JSON.

---

## 🔒 Segurança

- O token JWT gerado no login deve ser usado para proteger endpoints sensíveis.
- Ideal proteger os endpoints com `Spring Security`.

---

## 📁 Pacote

```
com.academia.userservice.controller.UserController
```

---

## 🛠️ Requisitos

- Java 17+
- Spring Boot
- Auth Service rodando corretamente
- Banco de dados PostgreSQL via Docker

---

## 👤 Autor

Pedro Henrique Candido
```
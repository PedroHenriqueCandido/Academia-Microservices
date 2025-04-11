# 🧑 Entidade User

## 📌 O que é?

A entidade `User` representa um usuário autenticado dentro do sistema. Ela é essencial para o processo de login, geração de token JWT e controle de acesso por permissões (`role`).

---

## 🗂️ Estrutura da Tabela `tb_users`

| Campo       | Tipo           | Descrição                                      |
|-------------|----------------|-----------------------------------------------|
| id          | Long (PK)      | Identificador único do usuário                |
| email       | String         | Email usado para login (único por usuário)    |
| password    | String         | Senha do usuário (criptografada com BCrypt)   |
| role        | String         | Nível de permissão: `USER`, `ADMIN`, etc.     |
| created_at  | LocalDateTime  | Data de criação do usuário                    |

---

## 🧩 Observações

- A senha **nunca é armazenada em texto plano** — ela é criptografada usando o `PasswordEncoder` (`BCryptPasswordEncoder`).
- O campo `role` é utilizado para definir o nível de acesso do usuário e é inserido no token JWT.
- O campo `createdAt` pode ser preenchido automaticamente no momento da criação (via `@PrePersist`).

---

## ✅ Exemplo de Registro JSON

```json
{
  "email": "user@example.com",
  "password": "senha123",
  "role": "USER"
}

# AuthResponse

## 📌 O que é?

`AuthResponse` é um DTO (Data Transfer Object) responsável por transportar o **token JWT** gerado durante o processo de autenticação de um usuário.

---

## 🧾 Campos

| Campo | Tipo   | Descrição                        |
|-------|--------|----------------------------------|
| token | String | Token JWT gerado após login      |

---

## 📤 Exemplo de JSON retornado

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}

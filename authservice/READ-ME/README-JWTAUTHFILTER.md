# JwtAuthFilter

## 📌 O que é?

`JwtAuthFilter` é um filtro que intercepta todas as requisições HTTP e verifica se há um token JWT válido no cabeçalho `Authorization`. Caso exista, ele extrai as informações do token (como e-mail e role), valida o token e autentica o usuário na aplicação.

---

## ⚙️ Como funciona?

1. Verifica se o cabeçalho `Authorization` contém um token JWT.
2. Valida o token com a classe `JwtUtil`.
3. Extrai o e-mail do usuário e sua role a partir do token.
4. Busca o usuário no banco de dados pelo e-mail.
5. Cria um objeto de autenticação (`UsernamePasswordAuthenticationToken`) com a role extraída.
6. Registra a autenticação no contexto de segurança do Spring (`SecurityContextHolder`).

---

## 📥 Estrutura esperada do token

O token deve estar no formato:


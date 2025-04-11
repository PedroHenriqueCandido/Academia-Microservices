# PasswordEncoderConfig

## Descrição

A classe `PasswordEncoderConfig` é uma configuração do Spring responsável por disponibilizar um `PasswordEncoder` como um **Bean global** no contexto da aplicação. Esse encoder é utilizado para codificar senhas dos usuários durante o registro e para verificar senhas durante o login.

## Por que usar BCrypt?

- **Seguro:** O BCrypt é uma função de hash projetada especificamente para armazenar senhas.
- **Resistente a ataques de força bruta:** Ele possui um fator de custo que pode ser ajustado para tornar o processo de hash mais lento e seguro.
- **Adaptação futura:** Se necessário, o custo pode ser aumentado no futuro para se adequar a avanços em poder computacional.

## Como funciona?

Ao injetar `PasswordEncoder` em qualquer serviço, como `UserService`, você poderá usar:

```java
passwordEncoder.encode("minhaSenha"); // para salvar uma senha codificada
passwordEncoder.matches(rawPassword, encodedPassword); // para verificar a senha na autenticação

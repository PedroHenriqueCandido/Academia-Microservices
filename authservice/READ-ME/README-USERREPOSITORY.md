# 📦 UserRepository

## 📌 O que é?

O `UserRepository` é a interface responsável por acessar os dados da tabela de usuários (`tb_users`) no banco de dados. Ele estende `JpaRepository`, o que fornece automaticamente os métodos padrão para operações CRUD (Create, Read, Update, Delete).

---

## 🧩 Métodos Disponíveis

### Métodos herdados de `JpaRepository`
- `save(User user)` — salva ou atualiza um usuário
- `findById(Long id)` — busca um usuário pelo ID
- `findAll()` — retorna todos os usuários
- `deleteById(Long id)` — remove um usuário pelo ID

### Método personalizado
```java
Optional<User> findByEmail(String email);

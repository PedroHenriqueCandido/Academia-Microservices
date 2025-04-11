# 🔐 JwtUtil

## 📌 O que é?

A classe `JwtUtil` é um utilitário de segurança responsável por gerar, validar e decodificar tokens JWT (JSON Web Token). Ela é essencial para o funcionamento do sistema de autenticação no microserviço.

---

## 🚀 Funcionalidades

### 🔧 Geração de Token

```java
String token = jwtUtil.generateToken(user);

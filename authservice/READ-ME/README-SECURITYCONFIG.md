# ✅ `SecurityConfig` – Configuração de Segurança com Spring Security + JWT

Este arquivo documenta a configuração de segurança da aplicação `AuthService` utilizando **Spring Security**, **JWT (JSON Web Token)** e controle de acesso baseado em **roles** (`USER`, `ADMIN`).

---

## 📁 Arquivo: `SecurityConfig.java`

```java
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    
    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/register", "/auth/login").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
```

---

## 🔐 O que esta configuração faz?

### ✅ 1. **Desabilita o CSRF**
Para APIs REST, o CSRF geralmente é desabilitado, pois a autenticação é feita via token e não por cookies de sessão.

```java
.csrf(csrf -> csrf.disable())
```

---

### 🔓 2. **Define rotas públicas**
Estas rotas podem ser acessadas sem autenticação.

```java
.requestMatchers("/auth/register", "/auth/login").permitAll()
```

---

### 🔒 3. **Protege rotas com base em roles**
- `/admin/**` → Somente usuários com role `ADMIN`
- `/user/**` → Usuários com role `USER` ou `ADMIN`
- Demais rotas → Exigem autenticação JWT válida

```java
.requestMatchers("/admin/**").hasRole("ADMIN")
.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
.anyRequest().authenticated()
```

---

### 🧩 4. **Aplica o filtro JWT personalizado**
Intercepta requisições, extrai e valida o token JWT presente no header Authorization.

```java
.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
```

---

## 🎯 Como funciona o processo de autenticação?

1. O usuário faz login e recebe um JWT contendo o `email` e a `role`.
2. O token é enviado no header da requisição:
   ```
   Authorization: Bearer <token>
   ```
3. O filtro `JwtAuthFilter`:
   - Extrai o token
   - Valida assinatura e expiração
   - Extrai o e-mail e role
   - Cria a autenticação com as autoridades corretas
4. O Spring Security verifica se o usuário pode acessar a rota com base nas roles.

---

## 🧪 Testando no Postman

1. Faça uma requisição POST para `/auth/login` com email e senha válidos.
2. Copie o token JWT retornado.
3. Em qualquer rota protegida, adicione o token no header:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

---

## 🛠️ Anotações de método com `@PreAuthorize`

Você pode usar a anotação `@PreAuthorize` em métodos para validar permissões:

```java
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/admin-only")
public String adminOnly() {
    return "Somente ADMINs acessam isso!";
}
```

---

## ✍️ Autor

Pedro Henrique Cândido  
📅 Abril de 2025
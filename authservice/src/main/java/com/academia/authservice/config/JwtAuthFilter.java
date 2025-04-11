package com.academia.authservice.config;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.academia.authservice.models.User;
import com.academia.authservice.security.JwtUtil;
import com.academia.authservice.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filtro de autenticação JWT que é executado uma vez por requisição.
 * 
 * <p>Responsável por:
 * <ul>
 *   <li>Extrair o token JWT do cabeçalho Authorization.</li>
 *   <li>Validar o token usando {@link JwtUtil}.</li>
 *   <li>Extrair o e-mail e a role do token.</li>
 *   <li>Buscar o usuário pelo e-mail usando {@link UserService}.</li>
 *   <li>Registrar o usuário autenticado no {@link SecurityContextHolder}.</li>
 * </ul>
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    /**
     * Executa o filtro de autenticação JWT.
     * 
     * @param request requisição HTTP
     * @param response resposta HTTP
     * @param filterChain corrente do filtro
     * @throws ServletException exceções relacionadas à servlet
     * @throws IOException exceções de entrada/saída
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = extractToken(request);

        if (token != null && jwtUtil.validateToken(token)) {
            String email = jwtUtil.getUsernameFromToken(token);
            User user = userService.findByEmail(email).orElse(null);

            String role = jwtUtil.getRoleFromToken(token);
            List<GrantedAuthority> authorities = Collections.singletonList(
                    new SimpleGrantedAuthority("ROLE_" + role)
            );

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                user, null, authorities
            );

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    /**
     * Extrai o token JWT do cabeçalho Authorization da requisição.
     * 
     * @param request requisição HTTP
     * @return token JWT ou {@code null} se não estiver presente ou mal formatado
     */
    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
            return header.substring(7); // remove "Bearer "
        }
        return null;
    }
}

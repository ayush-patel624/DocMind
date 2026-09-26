package com.substring.docmind.config;

import com.substring.docmind.repository.UserRepository;
import com.substring.docmind.service.CustomUserDetail;
import com.substring.docmind.service.CustomUserDetailService;
import com.substring.docmind.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final CustomUserDetailService userDetailService;

    private final UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //logic to implement validations and other stuff

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authHeader.substring(7);

        String username;

        try {
            username = jwtService.extractUsername(token);
            if (username == null || !jwtService.isTokenValid(token, userDetailService.loadUserByUsername(username))) {
                filterChain.doFilter(request, response);
                return;
            }

            var user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
            var authentication = new UsernamePasswordAuthenticationToken(user, null, new CustomUserDetail(user).getAuthorities());

            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            filterChain.doFilter(request, response);
            e.printStackTrace();
            return;
        }

//        context set karenge


        filterChain.doFilter(request, response);
    }
}

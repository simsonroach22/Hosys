package com.hosys.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;

        @Bean
        public SecurityFilterChain securityFilterChain(
                        HttpSecurity http) throws Exception {

                http
                                .csrf(csrf -> csrf.disable())

                                .sessionManagement(session -> session.sessionCreationPolicy(
                                                SessionCreationPolicy.STATELESS))

                                .authorizeHttpRequests(auth -> auth

                                                .requestMatchers(
                                                                "/api/auth/**")
                                                .permitAll()

                                                .requestMatchers("/api/users/**")
                                                .hasAuthority("ADMIN")

                                                .requestMatchers("/api/orders/**")
                                                .hasAnyAuthority(
                                                                "ADMIN",
                                                                "MANAGER",
                                                                "WAITER")

                                                .requestMatchers("/api/order-items/**")
                                                .hasAnyAuthority(
                                                                "ADMIN",
                                                                "WAITER")

                                                .requestMatchers("/api/bills/**")
                                                .hasAnyAuthority(
                                                                "ADMIN",
                                                                "MANAGER")

                                                .requestMatchers("/api/payments/**")
                                                .hasAnyAuthority(
                                                                "ADMIN",
                                                                "MANAGER")

                                                .requestMatchers("/api/dashboard/**")
                                                .hasAnyAuthority(
                                                                "ADMIN",
                                                                "MANAGER")

                                                .anyRequest()
                                                .authenticated())

                                .httpBasic(Customizer.withDefaults())

                                .addFilterBefore(
                                                jwtAuthenticationFilter,
                                                UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }
}
package com.gcu.internationalcandyemporium;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Other security configurations
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/index.html", "/*.js", "/*.map", "/*.css").permitAll()
                .requestMatchers("/*.ico", "/*.png", "/*.svg", "/*.webapp").permitAll()
                .requestMatchers("/*.ico", "/*.png", "/*.svg", "/*.webapp", "/*.woff", "/*.woff2", "/*.ttf", "/*.otf").permitAll() // Common web font extensions
                .requestMatchers("/app/**").permitAll()
                .requestMatchers("/app/**", "/register/**").permitAll()  // Allow the registration page
                .requestMatchers("/login").permitAll()  // Permit access to custom login page
            )
            .formLogin()
                .loginPage("/login/") // Use your custom login page
                .loginProcessingUrl("/perform_login") // URL to submit the login data
                .permitAll()            
            .and()
            .logout()
            .permitAll();
        return http.build();
    }
}

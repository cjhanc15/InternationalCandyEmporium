package com.gcu.internationalcandyemporium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http
            // Other security configurations
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/index.html", "/*.js", "/*.map", "/*.css").permitAll()
                .requestMatchers("/*.ico", "/*.png", "/*.svg", "/*.webapp").permitAll()
                .requestMatchers("/*.ico", "/*.png", "/*.svg", "/*.webapp", "/*.woff", "/*.woff2", "/*.ttf", "/*.otf").permitAll() // Common web font extensions
                .requestMatchers("/app/**", "*/").permitAll()
                .requestMatchers("/app/**", "/register/**").permitAll()  // Allow the registration page
                .requestMatchers("/login").permitAll()  // Permit access to custom login page
            )
            .formLogin()
                .loginPage("/login/") // Custom login page
                .loginProcessingUrl("/login") // URL to submit the login data
                .defaultSuccessUrl("/", true) // Redirect to home page on successful login
                .failureUrl("/login?error=true") // Redirect back to login page on failure
                .permitAll()           
            .and()
            .logout()
            .permitAll();
        return http.build();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

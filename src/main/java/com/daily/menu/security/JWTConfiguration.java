package com.daily.menu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.daily.menu.service.UserDetailServiceImpl;

@Configuration
public class JWTConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }	
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, "/api/login").permitAll()
        .antMatchers(HttpMethod.POST, "/api/user").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JWTAuthenticationFilter(authenticationManager(null)))
        .addFilter(new JWTAuthorizationFilter(authenticationManager(null)))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}

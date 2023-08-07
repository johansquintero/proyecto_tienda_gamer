package com.proyecto.tienda.config;

import com.proyecto.tienda.security.JwtAuthFilter;
import com.proyecto.tienda.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
public class AplicationConfig {
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Bean del codificador de de contraseñas para ser inyectado
     * @return Implemetación BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean de JwtAuthFilter para inyeccion
     * @return Implementación JwtAuthFilter
     */
    @Bean
    public JwtAuthFilter jwtAuthFilter(){
        return new JwtAuthFilter(this.jwtAuthenticationProvider);
    }

}

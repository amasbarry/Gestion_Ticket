package com.odk.V5_Ticketing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

   @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry->{
            registry.requestMatchers("/user").permitAll();
           registry.requestMatchers("/admins").hasRole("ADMIN");
           registry.requestMatchers("/apprenants/create").hasRole("ADMIN");
           registry.requestMatchers("/formateurs/create").hasRole("ADMIN");
           registry.requestMatchers("/apprenants/**").hasAnyRole("ADMIN", "APPRENANT");
           registry.requestMatchers("/formateurs/**").hasAnyRole("ADMIN", "FORMATEUR");
         registry.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults())
                .build();
    }


@Bean
public org.springframework.security.core.userdetails.UserDetailsService customUserDetailsService() {
    return  userDetailsService;
}


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner adminPardefaut()  {
     return args -> {
         boolean adminExist = This
     }
    }

    }

package com.odk.V5_Ticketing.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                .title("Gestion Ticket")
                        .description("Une application de gestion des tikets")
                        .version("0.0.1")
                        .termsOfService("http://swagger.io/terms")
                        .contact(new Contact().name("Mody Barry").email("modybarry50@gmail.com"))
                );
    }
}
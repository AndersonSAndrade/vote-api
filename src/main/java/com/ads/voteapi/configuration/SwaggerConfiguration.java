package com.ads.voteapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("ADEM ERP - Business Management System")
                        .version("1.0")
                        .description("Business management system, CORE service")
                        .contact(contact())
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")
                        ));
    }

    private Contact contact() {
        Contact con = new Contact();
        con.setEmail("asantos919@gmail.com");
        con.setName("Anderson S. Andrade");
        con.setUrl("https://github.com/AndersonSAndrade");
        con.setExtensions(new HashMap<>());
        return con;
    }

}

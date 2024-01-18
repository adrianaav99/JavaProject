package com.unibuc.javaproject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Event Management API Documentation",
        description = "API Documentation for all available operations with events, venues, categories, " +
                "organizers, participants, tickets and reviews."))
@OpenAPI30
public class SwaggerConfig {

}

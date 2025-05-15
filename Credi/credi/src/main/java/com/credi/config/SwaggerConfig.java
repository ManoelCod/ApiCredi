package com.credi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API de Créditos", version = "1.0", description = "Documentação da API de Créditos utilizando Swagger"))
public class SwaggerConfig {
}
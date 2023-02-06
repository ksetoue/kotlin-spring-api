package com.ksetoue.kotlinspringapi.port.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun customOpenAPI(): OpenAPI? {
        return OpenAPI()
            .components(Components())
            .info(
                Info().title("Kotlin and Spring Boot API")
                    .description("API sample")
                    .version("1.0.0")
            )
    }
}

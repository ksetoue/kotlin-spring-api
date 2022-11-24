package com.ksetoue.kotlinspringapi.port.client

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class HttpClientConfig {
    @Bean
    fun restClient(restTemplateBuilder: RestTemplateBuilder): RestTemplate =
        restTemplateBuilder.build()
}

package com.ksetoue.kotlinspringapi.port.controller

import com.ksetoue.kotlinspringapi.application.HealthApplicationService
import com.ksetoue.kotlinspringapi.domain.HealthContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthController(
    private val healthService: HealthApplicationService
) {
    @GetMapping("status")
    fun status(): ResponseEntity<HealthContext> {
        return ResponseEntity(healthService.getStatus(), HttpStatus.OK)
    }
}
package com.ksetoue.kotlinspringapi.port.controller

import com.ksetoue.kotlinspringapi.business.HealthApplicationService
import com.ksetoue.kotlinspringapi.domain.HealthContext
import com.ksetoue.kotlinspringapi.domain.common.ErrorDetails
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HealthController(
    private val healthService: HealthApplicationService
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/startup")
    @Operation(summary = "Health status of this service", description = "Returns information about the availability of this service")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Success Response", content = [Content(mediaType = "application/json", schema = Schema(implementation = HealthContext::class))]),
            ApiResponse(responseCode = "500", description = "Internal System Error", content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorDetails::class))]),
            ApiResponse(responseCode = "400", description = "Invalid Parameter Request", content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorDetails::class))])
        ]
    )
    fun startup(): ResponseEntity<HealthContext> {
        logger.info("attempt to check health")
        return ResponseEntity(healthService.getStatus(), HttpStatus.OK)
    }

    @GetMapping("/liveness")
    fun live(): ResponseEntity<String> {
        return ResponseEntity("OK", HttpStatus.OK)
    }

    @GetMapping("/readiness")
    fun ready(): ResponseEntity<String> {
        return ResponseEntity("OK", HttpStatus.OK)
    }
}

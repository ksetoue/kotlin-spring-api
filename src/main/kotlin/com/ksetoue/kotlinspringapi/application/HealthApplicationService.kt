package com.ksetoue.kotlinspringapi.application

import com.ksetoue.kotlinspringapi.domain.HealthContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HealthApplicationService {
    private val logger = LoggerFactory.getLogger(this::class.java)
    fun getStatus(): HealthContext {
        logger.trace("healthservice")
        logger.info("get-status")
        return HealthContext("running")
    }
}

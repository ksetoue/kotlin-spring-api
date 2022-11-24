package com.ksetoue.kotlinspringapi.application

import com.ksetoue.kotlinspringapi.domain.HealthContext
import org.springframework.stereotype.Service

@Service
class HealthApplicationService {
    fun getStatus(): HealthContext {
        return HealthContext("running")
    }
}

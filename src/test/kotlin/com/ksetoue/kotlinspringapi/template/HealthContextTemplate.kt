package com.ksetoue.kotlinspringapi.template

import com.ksetoue.kotlinspringapi.domain.HealthContext

class HealthContextTemplate {
    fun default(): HealthContext {
        return HealthContext("running")
    }
}

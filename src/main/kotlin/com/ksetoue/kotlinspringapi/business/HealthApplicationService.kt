package com.ksetoue.kotlinspringapi.application

import com.ksetoue.kotlinspringapi.domain.HealthContext
import io.opentracing.Span
import io.opentracing.util.GlobalTracer
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HealthApplicationService {
    private val logger = LoggerFactory.getLogger(this::class.java)
    private val tracer = GlobalTracer.get()

    private val span: Span = tracer.buildSpan("HealthApplicationService").start()
    private val scope = tracer.scopeManager().activate(span)

    fun getStatus(): HealthContext {
        span.log("get-status")
        return HealthContext("running")
    }
}

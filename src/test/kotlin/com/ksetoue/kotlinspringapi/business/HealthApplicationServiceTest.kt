package com.ksetoue.kotlinspringapi.business

import com.ksetoue.kotlinspringapi.AbstractBaseTest
import com.ksetoue.kotlinspringapi.template.HealthContextTemplate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HealthApplicationServiceTest : AbstractBaseTest() {
    private val healthServiceMock = HealthApplicationService()

    @Test
    fun `#getStatus must return running when service is up`() {
        val expectedStatus = HealthContextTemplate().default()

        val receivedStatus = healthServiceMock.getStatus()
        assertThat(receivedStatus.status).isEqualTo(expectedStatus.status)
    }
}

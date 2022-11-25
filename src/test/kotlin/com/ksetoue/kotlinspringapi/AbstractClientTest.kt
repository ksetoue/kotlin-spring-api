package com.ksetoue.kotlinspringapi

import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate

abstract class AbstractClientTest() : AbstractBaseTest() {

    protected val restTemplate = RestTemplate()
    protected val mockServer = MockRestServiceServer.createServer(restTemplate)
}

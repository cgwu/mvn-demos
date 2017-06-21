package net.xman.tech.service

import io.swagger.annotations.Api
import net.xman.tech.common.service.HelloRestService
import org.slf4j.LoggerFactory

/**
 * Created by sam on 17-6-19.
 * URL: http://localhost:8080/cxfsvs/sayHello/a
 */
@Api("/sayHello")
class HelloRestServiceImpl1 : HelloRestService {
    private val log = LoggerFactory.getLogger(HelloRestServiceImpl1::class.java)

    override fun sayHello(a: String): String {
        log.info("接收到Rest请求sayHello: $a")
        return "Hello $a, Welcome to CXF RS Spring Boot World!!!"
    }
}

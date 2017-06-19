package net.xman.tech.service

import io.swagger.annotations.Api
import net.xman.tech.common.service.HelloRestService

/**
 * Created by sam on 17-6-19.
 * URL: http://localhost:8080/cxfsvs/sayHello/a
 */
@Api("/sayHello")
class HelloRestServiceImpl1 : HelloRestService {
    override fun sayHello(a: String): String {
        return "Hello $a, Welcome to CXF RS Spring Boot World!!!"
    }
}

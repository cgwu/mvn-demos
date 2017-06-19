package net.xman.tech.service

import io.swagger.annotations.Api
import net.xman.tech.common.service.HelloRestService
import javax.ws.rs.Path

/**
 * URL: http://localhost:8080/cxfsvs/sayHello2/name
 */
@Path("/sayHello2")
@Api("/sayHello2")
class HelloRestServiceImpl2 : HelloRestService {
    override fun sayHello(a: String): String {
        return "Hello2 $a, Welcome to CXF RS Spring Boot World!!!"
    }
}

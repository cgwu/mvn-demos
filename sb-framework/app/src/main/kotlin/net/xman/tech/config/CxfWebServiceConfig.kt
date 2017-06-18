package net.xman.tech.config

import net.xman.tech.service.HelloWebServiceImpl
import org.apache.cxf.Bus
import org.apache.cxf.jaxws.EndpointImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.Endpoint


/**
 * Created by sam on 17-6-18.
 */
@Configuration
class CxfWebServiceConfig {

    @Autowired
    private val bus: Bus? = null

    @Bean
    fun helloServiceEndpoint(): Endpoint {
        val endpoint = EndpointImpl(bus, HelloWebServiceImpl())
        endpoint.publish("/hello")
        return endpoint
    }
}
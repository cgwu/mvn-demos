package net.xman.tech.config

import net.xman.tech.common.service.HelloWebService
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by sam on 17-6-19.
 */
@Configuration
class CxfWebServiceConfig {

    @Bean
    fun helloWebService(): HelloWebService {
        var factory = JaxWsProxyFactoryBean()
        factory.serviceClass = HelloWebService::class.java
        factory.address = "http://localhost:8080/cxfsvs/hello"
        return factory.create() as HelloWebService
    }

}
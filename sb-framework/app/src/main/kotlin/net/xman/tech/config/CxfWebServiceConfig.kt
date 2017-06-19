package net.xman.tech.config

import net.xman.tech.service.HelloRestServiceImpl1
import net.xman.tech.service.HelloRestServiceImpl2
import net.xman.tech.service.HelloWebServiceImpl
import org.apache.cxf.Bus
import org.apache.cxf.jaxws.EndpointImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.Endpoint
import org.apache.cxf.jaxrs.swagger.Swagger2Feature
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean

import org.apache.cxf.endpoint.Server
import java.util.*


/**
 * Created by sam on 17-6-18.
 * 官文文档(cxf集成spring boot): http://cxf.apache.org/docs/springboot.html
 * 官方全部示例:  https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples
 * JAX-RS官方示例:https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples/jax_rs/spring_boot/src/main/java/sample/rs/service
 * JAX-RS Swagger查看本地RS注册信息: http://localhost:8080/cxfsvs/swagger.json
 */
@Configuration
class CxfWebServiceConfig {

    @Autowired
    private val bus: Bus? = null

    // 注册JAX-WS Endpoint
    @Bean
    fun helloServiceEndpoint(): Endpoint {
        val endpoint = EndpointImpl(bus, HelloWebServiceImpl())
        endpoint.publish("/hello")
        return endpoint
    }

    // 注册JAX-RS Endpoint
    @Bean
    fun rsServer(): Server {
        val endpoint = JAXRSServerFactoryBean()
        endpoint.bus = bus
        // Register 2 JAX-RS root resources supporting "/sayHello/{id}" and "/sayHello2/{id}" relative paths
        endpoint.setServiceBeans(listOf<Any>(HelloRestServiceImpl1(), HelloRestServiceImpl2()))
        endpoint.address = "/"
        endpoint.setFeatures(Arrays.asList(Swagger2Feature()))
        return endpoint.create()
    }
}

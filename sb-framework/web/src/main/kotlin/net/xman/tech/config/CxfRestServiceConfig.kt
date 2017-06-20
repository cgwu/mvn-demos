package net.xman.tech.config

import net.xman.tech.common.service.HelloRestService
import org.apache.cxf.jaxrs.client.WebClient
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsProxyClient
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsWebClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.boot.CommandLineRunner




/**
 * Created by on 2017-06-20. Reference:
 * http://cxf.apache.org/docs/jax-rs-client-api.html
 * http://cxf.apache.org/docs/jaxrsclientspringboot.html
 * https://github.com/apache/cxf/blob/master/distribution/src/main/release/samples/jax_rs/spring_boot/src/main/java/sample/rs/client/SampleRestClientApplication.java
 *
 */
@Configuration
@EnableJaxRsWebClient
@EnableJaxRsProxyClient
class CxfRestServiceConfig {
    @Bean
    fun initWebClientRunner(webClient: WebClient): CommandLineRunner {
        return CommandLineRunner { println(webClient.path("sayHello2/ApacheCxfWebClientUser").get(String::class.java)) }
    }

    @Bean
    fun initProxyClientRunner(client: HelloRestService): CommandLineRunner {
        return CommandLineRunner { System.out.println(client.sayHello("ApacheCxfProxyUser")) }
    }
}

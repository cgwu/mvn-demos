package net.xman.tech.config

import net.xman.tech.common.service.GreetingService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.remoting.caucho.HessianProxyFactoryBean


/**
 * Created on 2017-06-17.
 */
@Configuration
class HessianConfig {

    @Value("\${app.url}")
    private var appUrl:String? = null

    @Bean
    fun greetingService(): HessianProxyFactoryBean {
        val exporter = HessianProxyFactoryBean()
//        exporter.serviceUrl = "http://localhost:8080/remoting/greetingService"
        exporter.serviceUrl = "$appUrl/remoting/greetingService"
        exporter.serviceInterface = GreetingService::class.java
        return exporter
    }

}

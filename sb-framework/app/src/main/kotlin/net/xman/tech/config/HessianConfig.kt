package net.xman.tech.config

import net.xman.tech.common.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.remoting.caucho.HessianServiceExporter


/**
 * Created on 2017-06-17.
 */
@Configuration
class HessianConfig {

    @Autowired
    private val greetingService: GreetingService? = null

    @Bean("/remoting/greetingService")
    fun exportGreetingService(): HessianServiceExporter {
        val exporter = HessianServiceExporter()
        exporter.service = greetingService
        exporter.serviceInterface = GreetingService::class.java
        return exporter
    }

}

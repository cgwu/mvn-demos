package net.xman.tech.service

import net.xman.tech.common.service.GreetingService
import org.springframework.stereotype.Service

/**
 * Created on 2017-06-17.
 */
@Service("greetingService")
class GreetingServiceImpl : GreetingService {
    override fun sayHi(name: String): String {
        return "Hello你好:《$name》"
    }
}

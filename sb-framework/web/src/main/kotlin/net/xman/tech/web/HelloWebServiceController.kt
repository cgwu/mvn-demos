package net.xman.tech.web

import net.xman.tech.common.service.HelloWebService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by sam on 17-6-19.
 */
@RestController
@RequestMapping("/hello")
class HelloWebServiceController {
    private val log = LoggerFactory.getLogger(HelloWebServiceController::class.java)

    @Autowired
    private val helloWebService: HelloWebService? = null

    @RequestMapping("/say-hi")
    fun sayHi(@RequestParam name:String):String {
        var result = helloWebService!!.sayHi(name)
        log.info("WebService Result: $result")
        return result
    }
}
package net.xman.tech.web

import net.xman.tech.common.service.HelloRestService
import org.apache.cxf.jaxrs.client.Client
import org.apache.cxf.jaxrs.client.WebClient
import org.apache.cxf.jaxrs.client.spring.EnableJaxRsWebClient
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.awt.print.Book



/**
 * Created by on 2017-06-20.
 * 测试Rest Service客户端
 * ref: http://www.360doc.com/content/12/0429/11/9318309_207459748.shtml
 */
@RestController
@RequestMapping("/hello-rest")
class HelloRestServiceController {
    private val log = LoggerFactory.getLogger(HelloRestServiceController::class.java)

    @Value("\${cxf.jaxrs.client.address}")
    private var restUrl: String? = null

    // 1.使用jaxrs webclient
    @RequestMapping("/client")
    fun byWebClient(): String {
        val client = WebClient.create(restUrl)
        var result = client!!.path("sayHello/ApacheCxfWebClientUser").get(String::class.java)
        log.info("JAX-RS WebClient Result: $result")
        return result
    }

    // 2.使用jaxrs proxy client: 测试失败!
//    @Autowired
//    private var restService: HelloRestService? = null
//
//    @RequestMapping("/proxy")
//    fun byProxyClient(): String {
//        var result = restService!!.sayHello("ApacheCxfProxyUser")
//        log.info("JAX-RS Proxy Client Result: $result")
//        return result
//    }

}
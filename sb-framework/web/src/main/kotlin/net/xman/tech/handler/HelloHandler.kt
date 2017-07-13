package net.xman.tech.handler

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

/**
 * Created by sam on 17-7-13.
 */

@Component("helloHandler")
class HelloHandler : AbstractHandler() {
    private val log = LoggerFactory.getLogger(HelloHandler::class.java)

    override fun cmdName(): String {
        return "hello"
    }

    override fun execute(mapArg: MutableMap<String, Any>): String {
        val name = mapArg["name"]
        return "您好,$name"
    }

//    @Autowired
//    private val executor: HandlerExecutor? = null
//
//    @PostConstruct
//    fun addToHandlerExecutor() {
//        executor!!.mapHandler["hello"] = this
//        log.info("增加到mapHandler: hello")
//    }

}
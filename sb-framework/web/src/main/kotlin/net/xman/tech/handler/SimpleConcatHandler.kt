package net.xman.tech.handler

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

/**
 * Created by sam on 17-7-13.
 */

@Component
class SimpleConcatHandler : AbstractHandler() {
    private val log = LoggerFactory.getLogger(HelloHandler::class.java)

    override fun cmdName(): String {
        return "simpleConcat"
    }

    override fun execute(mapArg: MutableMap<String, Any>): String {
        return "${mapArg["arg1"]} # ${mapArg["arg2"]}"
    }

//    @Autowired
//    private val executor: HandlerExecutor? = null
//
//    @PostConstruct
//    fun addToHandlerExecutor() {
//        executor!!.mapHandler["simpleConcat"] = this
//        log.info("增加到mapHandler: simpleConcat")
//    }

}
package net.xman.tech.handler

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

/**
 * Created by sam on 17-7-13.
 */

abstract class AbstractHandler {
    private val log = LoggerFactory.getLogger(AbstractHandler::class.java)

    abstract fun execute(mapArg: MutableMap<String, Any>): String

    abstract fun cmdName():String

    @Autowired
    private val executor: HandlerExecutor? = null

    @PostConstruct
    fun addToHandlerExecutor() {
        executor!!.mapHandler[cmdName()] = this
        log.info("增加到mapHandler: ${cmdName()}")
    }
}

@Component("handlerExecutor")
class HandlerExecutor {
    var mapHandler: MutableMap<String, AbstractHandler> = mutableMapOf()

    fun process(cmd:String, mapArg: MutableMap<String, Any>):String{
        return mapHandler[cmd]!!.execute(mapArg)
    }
}


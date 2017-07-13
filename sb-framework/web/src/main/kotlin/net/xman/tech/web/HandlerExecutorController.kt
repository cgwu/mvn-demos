package net.xman.tech.web

import net.xman.tech.handler.HandlerExecutor
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by sam on 17-7-13.
 */
@RestController
@RequestMapping("/handler")
class HandlerExecutorController {
    private val log = LoggerFactory.getLogger(HandlerExecutorController::class.java)

    @Autowired
    private val executor: HandlerExecutor? = null

    @RequestMapping("/hello")
    fun hello(@RequestParam name: String): String {
        var mapArg = mutableMapOf<String, Any>("name" to name)
        return executor!!.process("hello", mapArg)
    }

    //TODO: 客户端选择需要执行的Command
    @RequestMapping("/process")
    fun process(@RequestParam cmd: String, @RequestParam args: MutableMap<String,Any>): String {
//      示例数据: process command: hello, args: {cmd=hello, name=abc中国This is fucking great}
        log.info("process command: $cmd, args: $args")
        return executor!!.process(cmd, args)
    }
}
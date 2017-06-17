package net.xman.tech.service

import net.xman.tech.common.service.GreetingService
import net.xman.tech.common.service.MathReq
import net.xman.tech.common.service.NumberReq
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Created on 2017-06-17.
 */
@Service("greetingService")
class GreetingServiceImpl : GreetingService {
    companion object {  // 可以不用companion object
        private val log = LoggerFactory.getLogger(GreetingServiceImpl::class.java)
    }

    override fun sayHi(name: String): String {
        log.info("接收到来自客户端服务的请求:\$name = $name")
        return "Hello你好:《$name》"
    }

    override fun calc(arg: MathReq): MathReq {
        log.info("接收到来自客户端服务的请求:\$arg = $arg")
        when (arg.op) {
            '+' -> arg.result = arg.op1 + arg.op2
            '-' -> arg.result = arg.op1 - arg.op2
            '*' -> arg.result = arg.op1 * arg.op2
            '/' -> arg.result = arg.op1 / arg.op2
        }
        return arg
    }

    override fun calcNumber(arg: NumberReq): NumberReq {
        log.info("接收到来自客户端服务的请求:\$arg = $arg")
        when (arg.op) {
            '+' -> arg.result =  arg.op1 + arg.op2
            '-' -> arg.result = arg.op1 - arg.op2
            '*' -> arg.result = arg.op1 * arg.op2
            '/' -> arg.result = arg.op1 / arg.op2
        }
        return arg
    }

}

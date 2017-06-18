package net.xman.tech.service

import net.xman.tech.common.service.HelloWebService
import net.xman.tech.common.service.MathDoubleReq
import net.xman.tech.common.service.MathWsReq
import org.slf4j.LoggerFactory

@javax.jws.WebService(
        targetNamespace = "http://hello.webservice.com",
        serviceName = "helloService",
        portName = "helloService",
        endpointInterface = "net.xman.tech.common.service.HelloWebService")
class HelloWebServiceImpl : HelloWebService {

    private val log = LoggerFactory.getLogger(HelloWebServiceImpl::class.java)

    override fun sayHi(name: String): String {
        log.info("接收到jax-ws请求,name: $name")
        return "你好$name, 我是JAX-WS"
    }

    override fun calc(req: MathWsReq): MathWsReq {
        log.info("接收到jax-ws calc请求,op1: ${req.op1}, op2:${req.op2}")
        when (req.op) {
            '+' -> req.result = req.op1 + req.op2
            '-' -> req.result = req.op1 - req.op2
            '*' -> req.result = req.op1 * req.op2
            '/' -> req.result = req.op1 / req.op2
        }
        return req
    }

    override fun calcDouble(req: MathDoubleReq): MathDoubleReq {
        log.info("接收到jax-ws calcDouble请求,op1: ${req.op1}, op2:${req.op2}, op:${req.op}")
        when (req.op) {
            '+' -> req.result = req.op1 + req.op2
            '-' -> req.result = req.op1 - req.op2
            '*' -> req.result = req.op1 * req.op2
            '/' -> req.result = req.op1 / req.op2
        }
        return req
    }
}
package net.xman.tech.web

import net.xman.tech.common.domain.UserEntity
import net.xman.tech.common.service.GreetingService
import net.xman.tech.common.service.MathReq
import net.xman.tech.common.service.NumberReq
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal


@RestController
class HomeController {
    private val log = LoggerFactory.getLogger(HomeController::class.java)

    @Autowired
    private val greetingService: GreetingService? = null

    @RequestMapping("/")
    fun index(): String {
        val u = UserEntity("张三", 33, "123456")
        val strResult = greetingService?.sayHi(u.name)

        var m1 = MathReq(op = '+', op1 = BigDecimal.ONE, op2 = BigDecimal(2))
        log.info("MathReq: $m1")
        val mathResult = greetingService?.calc(m1)

        var n1 = NumberReq(op = '+', op1 = 1.0, op2 = 2.0)
        log.info("MathReq: $n1")
        val numberResult = greetingService?.calcNumber(n1)

        n1 = NumberReq(op = '-', op1 = 1.0, op2 = 2.0)
        val r1 = greetingService?.calcNumber(n1)
        n1 = NumberReq(op = '*', op1 = 11.0, op2 = 2.0)
        val r2 = greetingService?.calcNumber(n1)
        n1 = NumberReq(op = '/', op1 = 1.0, op2 = 3.0)
        val r3 = greetingService?.calcNumber(n1)

        return "Hello Kotlin Web!! 欢迎你:$u, <br>从hessian服务返回的结果: " +
                "[$strResult],<br> [$mathResult], <br>[$numberResult], <br>[$r1], <br>[$r2], <br>[$r3]!"
    }
}
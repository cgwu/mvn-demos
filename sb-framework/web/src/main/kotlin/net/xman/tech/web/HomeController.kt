package net.xman.tech.web

import net.xman.tech.common.domain.UserEntity
import net.xman.tech.common.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HomeController {

    @Autowired
    private val greetingService: GreetingService? = null

    @RequestMapping("/")
    fun Index(): String {
        val u = UserEntity("张三", 33, "123456")
        val strResult = greetingService!!.sayHi(u.name)
        return "Hello Kotlin Web!! 欢迎你:$u, 从hessian服务返回的结果: [$strResult]!"
    }
}
package net.xman.tech.web

import net.xman.tech.common.domain.UserEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HomeController {
    @RequestMapping("/")
    fun Index(): String {
        val u = UserEntity("张三", 33, "123456")
        return "Hello Kotlink Web!! 欢迎你:$u !"
    }
}
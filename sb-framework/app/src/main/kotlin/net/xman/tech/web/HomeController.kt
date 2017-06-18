package net.xman.tech.web

import net.xman.tech.common.domain.UserEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


@RestController
class HomeController {
    @RequestMapping("/")
    fun Index(): String {
        val u = UserEntity("李四", 44, "000111")
        return "${LocalDateTime.now()}: Hello Kotlink App!! 欢迎你来到app: $u"
    }
}
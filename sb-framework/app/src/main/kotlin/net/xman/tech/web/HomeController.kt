package net.xman.tech.web

import net.xman.tech.common.domain.UserEntity
import net.xman.tech.service.CachedService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


@RestController
class HomeController {
    @Autowired
    private var cachedService: CachedService? = null

    @RequestMapping("/")
    fun index(): String {
        val u = UserEntity("李四", 44, "000111")
        return "${LocalDateTime.now()}: Hello Kotlink App!! 欢迎你来到app: $u"
    }

    @RequestMapping("/cache")
    fun cache(@RequestParam i:Int): String {
        val result = cachedService!!.computePiDecimal(i)
        return "computePiDecimal: $result"
    }

}
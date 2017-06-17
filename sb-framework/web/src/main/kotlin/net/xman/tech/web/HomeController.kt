package net.xman.tech.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HomeController {
    @RequestMapping("/")
    fun Index(): String {
        return "Hello Kotlink Web!!"
    }
}
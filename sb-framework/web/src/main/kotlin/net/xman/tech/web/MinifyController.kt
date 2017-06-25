package net.xman.tech.web

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/*
* 测试minify js,css
* */
@Controller
@RequestMapping("/minify")
class MinifyController {
    private val log = LoggerFactory.getLogger(MinifyController::class.java)

    @RequestMapping("/")
    fun index(): String {
        return "test-minify"
    }
}
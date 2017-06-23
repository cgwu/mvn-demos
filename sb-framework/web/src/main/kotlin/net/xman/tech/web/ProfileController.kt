package net.xman.tech.web

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/*
* 测试从文件系统加载profile配置文件
* */
@RestController
@RequestMapping("/profile")
class ProfileController {
    private val log = LoggerFactory.getLogger(ProfileController::class.java)

    @Value("\${app.url}")
    private var appUrl: String? = null

    @Value("\${app.profile}")
    private var appProfile: String? = null

    @RequestMapping("/appurl")
    fun index(): String {
        return "$appUrl - $appProfile"
    }
}
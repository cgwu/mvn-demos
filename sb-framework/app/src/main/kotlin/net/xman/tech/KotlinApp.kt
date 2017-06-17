package net.xman.tech

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinApp {
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinApp::class.java, *args)
}
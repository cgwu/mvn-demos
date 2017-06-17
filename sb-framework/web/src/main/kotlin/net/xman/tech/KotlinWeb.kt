package net.xman.tech

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinWeb {
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinWeb::class.java, *args)
}
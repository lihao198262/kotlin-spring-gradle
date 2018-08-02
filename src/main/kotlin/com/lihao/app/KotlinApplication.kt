package com.lihao.app

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

val logger = LoggerFactory.getLogger("KotlinApplication.kt")

@SpringBootApplication
open class KotlinApplication

@RestController
class HelloController {
    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world kotlin spring web gradle"
    }
}

@Controller
class MainController {
    @GetMapping("login")
    fun login(modle: Model): String {
        val a = 100;
        modle.addAttribute("a", a);
        return "login.html"
    }

    @PostMapping("login-post")
    fun loginCheck(username:String, password:String): String {
        logger.info("aa $username-> $password")
        return "index"
    }
}

fun main(args: Array<String>) {
    println("lihao")
    SpringApplication.run(KotlinApplication::class.java, *args)
}
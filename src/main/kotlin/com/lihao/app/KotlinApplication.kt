package com.lihao.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

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
    fun login(modle : Model): String {
        val a = 100;
        modle.addAttribute("a", a);
        return "login.html"
    }
}

fun main(args: Array<String>) {
    println("lihao")
    SpringApplication.run(KotlinApplication::class.java, *args)
}
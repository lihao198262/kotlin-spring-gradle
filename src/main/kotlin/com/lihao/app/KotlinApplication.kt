package com.lihao.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
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

fun main(args:Array<String>) {
    println("lihao")
    SpringApplication.run(KotlinApplication::class.java, *args)
}
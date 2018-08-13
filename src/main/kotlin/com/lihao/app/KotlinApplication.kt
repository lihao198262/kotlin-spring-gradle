package com.lihao.app

import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource
import org.springframework.data.redis.core.ValueOperations
import org.springframework.mobile.device.Device


val logger: Logger = LoggerFactory.getLogger("KotlinApplication.kt")

@SpringBootApplication
open class KotlinApplication

@RestController
class HelloController {
    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world kotlin spring web gradle"
    }
}

@Service
class RedisService {

    @Autowired
    private val template: StringRedisTemplate? = null

    @Resource(name = "stringRedisTemplate")
    var valOpsStr: ValueOperations<String, String>? = null

    fun test(username: String, password: String) {
        valOpsStr?.set(username, password)
    }
}

@Controller
class MainController {

    @Autowired
    private val a: RedisService? = null

    @GetMapping("login")
    fun login(modle: Model): String {
        val a = 100;
        modle.addAttribute("a", a);
        return "login.html"
    }

    @GetMapping("device")
    fun device(device: Device, modle: Model): String {

        if (device.isMobile()) {
            modle.addAttribute("a", "Hello mobile user!");
        } else if (device.isTablet()) {
            modle.addAttribute("a", "Hello tablet user!");
        } else {
            modle.addAttribute("a", "Hello desktop user! ${device.toString()}");
        }
        return "device.html"
    }

    @GetMapping("device/m")
    fun deviceM(device: Device, modle: Model): String {

        if (device.isMobile()) {
            modle.addAttribute("a", "Hello mobile user! m");
        } else if (device.isTablet()) {
            modle.addAttribute("a", "Hello tablet user! m");
        } else {
            modle.addAttribute("a", "Hello desktop user! m");
        }
        return "device.html"
    }

    @GetMapping("bbb")
    fun mobileDevice(device: Device, modle: Model): String {

        if (device.isMobile()) {
            modle.addAttribute("a", "Hello mobile user! bbb");
        } else if (device.isTablet()) {
            modle.addAttribute("a", "Hello tablet user! bbb");
        } else {
            modle.addAttribute("a", "Hello desktop user! bbb");
        }
        return "device.html"
    }

    @PostMapping("login-post")
    fun loginCheck(username: String, password: String): String {
        logger.info("aa $username-> $password")

        logger.info(a.toString())
        a?.test(username, password)
        return "index"
    }
}

fun main(args: Array<String>) {
    logger.info("lihao")
    SpringApplication.run(KotlinApplication::class.java, *args)
}
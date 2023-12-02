package uship.auth.authmicro.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController {

    @GetMapping("/helloWorld")
    fun helloWorld() : String {
        return "Test after test"
    }

    @GetMapping("/student")
    fun student() : String {
        return "Only students can see this"
    }

    @GetMapping("/admin")
    fun admin() : String {
        val principal = SecurityContextHolder.getContext().authentication.details as WebAuthenticationDetails
        println(principal.remoteAddress)

        return "Only admins can see this"
    }
}
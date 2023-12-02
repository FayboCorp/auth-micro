package uship.auth.authmicro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthMicroApplication

fun main(args: Array<String>) {
    runApplication<AuthMicroApplication>(*args)
}

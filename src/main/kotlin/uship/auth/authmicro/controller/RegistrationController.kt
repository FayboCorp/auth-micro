package uship.auth.authmicro.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uship.auth.authmicro.service.RegistrationService

@RestController
@RequestMapping("/registration")
class RegistrationController(val registrationService: RegistrationService) {

    @PostMapping
    fun registerUser(): ResponseEntity<String> {

    }

}
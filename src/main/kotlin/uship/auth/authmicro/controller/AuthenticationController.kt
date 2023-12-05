package uship.auth.authmicro.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uship.auth.authmicro.model.UShipUser
import uship.auth.authmicro.service.AuthenticationService

@RestController
@RequestMapping("/auth")
class AuthenticationController (val authenticationService: AuthenticationService){


    @GetMapping("/validate")
    fun helloWorld() : String {

        TODO("Implement JWT authentication provider")
        return "Test"
    }
}
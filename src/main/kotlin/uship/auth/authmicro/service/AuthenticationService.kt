package uship.auth.authmicro.service

import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.stereotype.Service

@Service
class AuthenticationService {

    fun validateEndpoint(userDetails: UserDetails) : ResponseEntity<Void> {

        val roles = userDetails.authorities

        roles.forEach { role ->

        }

        return ResponseEntity.ok().build()
    }

}
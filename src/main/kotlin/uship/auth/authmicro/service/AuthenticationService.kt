package uship.auth.authmicro.service

import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.stereotype.Service

@Service
class AuthenticationService {

    fun validateEndpoint(webDetails : UserDetails) : ResponseEntity<Void> {


        return ResponseEntity.ok().build()
    }

}
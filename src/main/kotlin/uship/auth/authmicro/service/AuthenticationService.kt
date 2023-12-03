package uship.auth.authmicro.service

import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import uship.auth.authmicro.repo.UShipUserRepo

@Service
class AuthenticationService (val UShipUserRepo: UShipUserRepo){

    fun validateEndpoint(userDetails: UserDetails) : ResponseEntity<Void> {

        val roles = userDetails.authorities
        println("details---------------")
        println(userDetails)
        println("roles---------------")
        roles.forEach { role ->
            println(role)
        }

        return ResponseEntity.ok().build()
    }

}
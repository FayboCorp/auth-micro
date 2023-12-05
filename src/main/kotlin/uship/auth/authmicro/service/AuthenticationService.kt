package uship.auth.authmicro.service

import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import uship.auth.authmicro.config.security.UShipUserDetails
import uship.auth.authmicro.model.UShipUser
import uship.auth.authmicro.repo.UShipUserRepo

@Service
class AuthenticationService (val UShipUserRepo: UShipUserRepo){

    fun validateEndpoint(userDetails: UShipUser) : ResponseEntity<Void> {

        println(userDetails)

        return ResponseEntity.ok().build()
    }

}
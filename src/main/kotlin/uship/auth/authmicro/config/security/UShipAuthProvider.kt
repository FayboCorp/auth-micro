package uship.auth.authmicro.config.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UShipAuthProvider (private val uShipUserDetails: UShipUserDetails, private val passwordEncoder: PasswordEncoder): AuthenticationProvider {

    override fun authenticate(authentication: Authentication): Authentication {
        val username = authentication.name
        val password = authentication.credentials.toString()

        val userDetails = uShipUserDetails.loadUserByUsername(username)

        if(passwordEncoder.matches(password, userDetails.password)){
            return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
        } else {
            throw BadCredentialsException("Invalid Credentials")
        }

    }

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }

}
package uship.auth.authmicro.config.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uship.auth.authmicro.repo.UShipUserRepo

@Service
class UShipUserDetails (val uShipUserRepo: UShipUserRepo) : UserDetailsService{

    @Transactional(readOnly=true)
    @Override
    override fun loadUserByUsername(username: String): UserDetails {

        return uShipUserRepo.findById(username).orElseThrow{
            UsernameNotFoundException("username $username was not found")
        }
    }

}
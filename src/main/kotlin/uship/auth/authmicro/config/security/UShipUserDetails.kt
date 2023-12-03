package uship.auth.authmicro.config.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import uship.auth.authmicro.exception.UUIDNotFound
import uship.auth.authmicro.model.UShipUser
import uship.auth.authmicro.repo.UShipUserRepo
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class UShipUserDetails (val uShipUserRepo: UShipUserRepo) : UserDetailsService{

    @Override
    override fun loadUserByUsername(username: String?): UserDetails? {
        return uShipUserRepo.findById(uuid).orElseThrow{
            UUIDNotFound("UUID $uuid was not found")
        } // TODO: use load by username but use uuid when passing requests to backend
    }

    @Transactional(readOnly=true)
    fun loadUserByUUID(uuid: UUID): UserDetails? {
        return uShipUserRepo.findById(uuid).orElseThrow{
            UUIDNotFound("UUID $uuid was not found")
        }
    }

}
package uship.auth.authmicro.exception

import org.springframework.security.core.userdetails.UsernameNotFoundException

class UUIDNotFound(message: String) : UsernameNotFoundException(message) {
}
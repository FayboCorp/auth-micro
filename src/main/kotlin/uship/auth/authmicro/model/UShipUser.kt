package uship.auth.authmicro.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

@Entity
@Table(name = "users")
class UShipUser(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID,

    @Column(nullable = false, unique = true, length = 50)
    private val username: String,

    @Column(nullable = false, length = 50)
    private val password: String,

    @Column(nullable = false)
    private val enabled: Boolean,

    @OneToMany(mappedBy = "UShipUser", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val authority: Set<Authority>?

) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authority?.map { SimpleGrantedAuthority(it.authority) }.orEmpty()
    }

    override fun getPassword(): String = password

    override fun getUsername(): String = username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = enabled
}
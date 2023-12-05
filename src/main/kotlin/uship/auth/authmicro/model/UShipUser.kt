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
    @Column(nullable = false, unique = true, length = 50)
    private val username: String,

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID,

    @Column(nullable = false, length = 50)
    private val password: String,

    @Column(nullable = false)
    private val enabled: Boolean,

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], mappedBy = "uShipUser")
    private val authorities: Collection<Authority>

) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> = authorities

    override fun getPassword(): String = password

    override fun getUsername(): String = username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = enabled
    override fun toString(): String {
        return "UShipUser(username='$username', id=$id, password=[PROTECTED], enabled=$enabled, authorities=$authorities)"
    }


}
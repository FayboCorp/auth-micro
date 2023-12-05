package uship.auth.authmicro.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.springframework.security.core.GrantedAuthority
import java.util.*

@Entity
@Table(name = "authorities")
class Authority(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: UUID,

    @Column(nullable = false)
    val username: String,

    @Column(nullable = false, length = 50)
    private val authority: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", insertable = false, updatable = false)
    val uShipUser: UShipUser

) : GrantedAuthority {

    override fun getAuthority(): String = authority
    override fun toString(): String = authority

}
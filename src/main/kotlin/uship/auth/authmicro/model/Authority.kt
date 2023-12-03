package uship.auth.authmicro.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "authorities")
class Authority(
    @Id
    @Column(nullable = false)
    val id: UUID,

    @Column(nullable = false, length = 50)
    val authority: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    val UShipUser: UShipUser
)
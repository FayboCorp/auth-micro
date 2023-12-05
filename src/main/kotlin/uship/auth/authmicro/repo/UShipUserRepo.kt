package uship.auth.authmicro.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import uship.auth.authmicro.model.UShipUser
import java.util.UUID

@Repository
interface UShipUserRepo : CrudRepository<UShipUser, String>
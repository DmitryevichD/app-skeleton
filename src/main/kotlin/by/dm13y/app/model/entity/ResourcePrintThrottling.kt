package by.dm13y.app.model.entity

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

@Entity
@IdClass(ResourcePrintThrottlingId::class)
class ResourcePrintThrottling {
    @Id
    var id: Int? = null
    @Id
    var date: LocalDateTime? = LocalDateTime.now()
}

class ResourcePrintThrottlingId: Serializable {
    var id: Int? = null
    var date: LocalDateTime? = LocalDateTime.now()
}

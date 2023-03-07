package by.dm13y.app.model.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Resource {
    @Id
    var id: Int? = null
    var name: String? = null
    var info: String? = null
    override fun hashCode(): Int {
        return 31
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Resource

        if (id == 0 && id != other.id) return false

        return true
    }
}

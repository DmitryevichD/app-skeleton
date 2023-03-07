package by.dm13y.app.repository

import by.dm13y.app.model.entity.ResourcePrintThrottling
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ResourceThrottlingRepository: CrudRepository<ResourcePrintThrottling, Int> {
    @Query(nativeQuery = true, value = "SELECT * FROM resource_print_throttling order by date LIMIT :limit")
    fun findOrOrderByDate(@Param("limit") limit: Int): List<ResourcePrintThrottling>
}

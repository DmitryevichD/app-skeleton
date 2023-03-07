package by.dm13y.app.repository

import by.dm13y.app.model.entity.Resource
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceRepository: CrudRepository<Resource, Int> {
}
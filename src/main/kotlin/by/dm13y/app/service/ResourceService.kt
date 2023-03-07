package by.dm13y.app.service

import by.dm13y.app.exception.ResourceNotFoundException
import by.dm13y.app.model.dto.ResourceDto

/**
 * Service used to handle CRUD operations for resources
 */
interface ResourceService {
    /**
     * Get resource by id otherwise throws [ResourceNotFoundException]
     */
    fun getResource(id: Int): ResourceDto

    /**
     * Create new resource and returns actual dto
     */
    fun createResource(resourceDto: ResourceDto): ResourceDto

    /**
     * Delete resource by id.
     * If resource doesn't exist method should end successfully
     */
    fun deleteResource(id: Int)

    /**
     * Print info about resource using throttling.
     */
    fun printResourceWithThrottling(resourceId: Int)
}

package by.dm13y.app.service.impl

import by.dm13y.app.exception.ResourceNotFoundException
import by.dm13y.app.mapper.ResourceMapper
import by.dm13y.app.model.dto.ResourceDto
import by.dm13y.app.model.entity.ResourcePrintThrottling
import by.dm13y.app.properties.ResourcePrintProperties
import by.dm13y.app.repository.ResourceRepository
import by.dm13y.app.repository.ResourceThrottlingRepository
import by.dm13y.app.service.ResourceService
import by.dm13y.app.utils.CommonUtils.mdcContext
import by.dm13y.app.utils.CommonUtils.toPretty
import java.util.UUID
import javax.transaction.Transactional
import mu.KotlinLogging
import mu.withLoggingContext
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock
import org.springframework.data.repository.findByIdOrNull
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class ResourceServiceDefaultImpl(
    private val resourceMapper: ResourceMapper,
    private val resourceRepository: ResourceRepository,
    private val resourceThrottlingRepository: ResourceThrottlingRepository,
    private val resourcePrintProperties: ResourcePrintProperties
): ResourceService {
    override fun getResource(id: Int): ResourceDto {
        return resourceRepository.findByIdOrNull(id)
            ?.let { resourceMapper.toResourceDto(it) }
            ?: throw ResourceNotFoundException("Resource with id: $id not found")
    }

    override fun createResource(resourceDto: ResourceDto): ResourceDto {
        return resourceMapper.toResource(resourceDto)
            .let { resourceRepository.save(it) }
            .let { resourceMapper.toResourceDto(it) }
    }

    override fun deleteResource(id: Int) {

    }

    @Scheduled(cron = "0 * * * * *")
    @SchedulerLock(name = "printResource")
    @Transactional
    fun printResource() {
        withLoggingContext("executionId" to UUID.randomUUID().toString()) {
            log.info { "Start cron job".mdcContext() }
            val resources = resourceThrottlingRepository.findOrOrderByDate(resourcePrintProperties.throttlingLimit)
            resources.forEach { log.info { it.toPretty().mdcContext() } }
            resourceThrottlingRepository.deleteAll(resources)
            log.info { "End cron job".mdcContext()  }
        }
    }

    override fun printResourceWithThrottling(resourceId: Int) {
        val resourceThrottling = ResourcePrintThrottling().apply{
            id = resourceId
        }
        resourceThrottlingRepository.save(resourceThrottling)
    }

    companion object {
        private val log = KotlinLogging.logger {}
    }
}

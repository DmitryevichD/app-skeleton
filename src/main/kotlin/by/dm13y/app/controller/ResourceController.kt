package by.dm13y.app.controller

import by.dm13y.app.model.dto.ResourceDto
import by.dm13y.app.service.ResourceService
import by.dm13y.app.utils.CommonUtils.mdcContext
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    path = ["/api/app-name/public/v1/resources"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
@Tag(name = "Resource controller", description = "CRUD API for resources")
class ResourceController(private val resourceService: ResourceService) {

    @Operation(summary = "Get resource by id")
    @ApiResponses(ApiResponse(responseCode = "404", description = "Resource not found"))
    @GetMapping("/{id}")
    fun getResource(@PathVariable("id") id: Int): ResourceDto {
        return resourceService.getResource(id)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new resource")
    @ApiResponses(ApiResponse(responseCode = "400", description = "Resource validation error"))
    @PostMapping
    fun createResource(@RequestBody @Validated resourceDto: ResourceDto): ResourceDto {
        return resourceService.createResource(resourceDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete resource by id")
    fun deleteResource(
        @Parameter(description = "Resource id", name = "id", example = "123")
        @PathVariable("id") id: Int
    ) {
        return resourceService.deleteResource(id)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/prints/{id}")
    @Operation(summary = "Print resource info")
    fun printResource(
        @Parameter(description = "Resource id", name = "id", example = "123")
        @PathVariable("id") resourceId: Int
    ) {
        log.info { "test".mdcContext() }
        return resourceService.printResourceWithThrottling(resourceId)
    }

    companion object {
        private val log = KotlinLogging.logger {}
    }
}

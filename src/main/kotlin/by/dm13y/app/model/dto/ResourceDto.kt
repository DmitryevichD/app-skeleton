package by.dm13y.app.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema


@Schema(name = "Resource", description = "Contains resource details")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResourceDto(
    @Schema(description = "Id", example = "1234", required = true)
    var id: Int? = null,

    @Schema(description = "Human name of the resource", example = "User resource", required = true)
    var name: String? = null,

    @Schema(description = "Description of the resource", example = "Resource used by users as default", required = true)
    var description: String? = null,
)

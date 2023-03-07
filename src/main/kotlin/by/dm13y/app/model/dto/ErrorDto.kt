package by.dm13y.app.model.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorDto(
    var code: String? = null,

    var message: String? = null,
)

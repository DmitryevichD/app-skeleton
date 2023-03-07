package by.dm13y.app.exception.handler

import by.dm13y.app.exception.ResourceNotFoundException
import by.dm13y.app.model.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun handleApplicationValidation(exception: ResourceNotFoundException): ErrorDto {
        return ErrorDto(message = exception.message)
    }
}

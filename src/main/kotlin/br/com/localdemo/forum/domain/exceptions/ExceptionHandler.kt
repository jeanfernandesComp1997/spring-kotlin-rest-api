package br.com.localdemo.forum.domain.exceptions

import br.com.localdemo.forum.domain.dto.ExceptionView
import org.springframework.http.HttpStatus
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ExceptionView {
        return ExceptionView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
        exception: Exception,
        request: HttpServletRequest
    ): ExceptionView {
        return ExceptionView(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            path = request.servletPath
        )
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ExceptionView {
        val errorMessage = HashMap<String, String?>()

        exception.bindingResult.fieldErrors.forEach { e ->
            errorMessage[e.field] = e.defaultMessage
        }

        return ExceptionView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = request.servletPath
        )
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(JpaObjectRetrievalFailureException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleEntityNotFound(
        exception: JpaObjectRetrievalFailureException,
        request: HttpServletRequest
    ): ExceptionView {
        return ExceptionView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }
}
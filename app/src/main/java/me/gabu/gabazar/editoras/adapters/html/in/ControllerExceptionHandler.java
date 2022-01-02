package me.gabu.gabazar.editoras.adapters.html.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.editoras.core.exceptions.AccessException;
import me.gabu.gabazar.editoras.core.exceptions.BadRequestException;
import me.gabu.gabazar.editoras.core.exceptions.ErrorData;
import me.gabu.gabazar.editoras.core.exceptions.NotFoundException;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorData> handleAllExceptions(Exception ex, WebRequest request) {
        return buildErrorData(ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ErrorData> handleNotFoundException(NotFoundException ex, WebRequest request) {
        request.getContextPath();
        return buildErrorData(ex, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ErrorData> handleBadRequestException(BadRequestException ex, WebRequest request) {
        return buildErrorData(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(AccessException.class)
    public final ResponseEntity<ErrorData> handleAccessException(AccessException ex, WebRequest request) {
        return buildErrorData(ex, HttpStatus.UNAUTHORIZED, request);
    }

    private ResponseEntity<ErrorData> buildErrorData(Exception ex, HttpStatus status, WebRequest request) {
        ErrorData errorData = new ErrorData(ex.getLocalizedMessage(), getPath(request), status.value(), status);
        log.error("[EXCEPTION] [{}] {}", ex.getClass().getSimpleName(), errorData);
        return new ResponseEntity<>(errorData, status);
    }

    private String getPath(WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getServletPath();
    }
}
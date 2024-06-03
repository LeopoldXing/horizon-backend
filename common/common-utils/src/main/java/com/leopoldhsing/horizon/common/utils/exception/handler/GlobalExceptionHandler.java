package com.leopoldhsing.horizon.common.utils.exception.handler;

import com.leopoldhsing.horizon.common.utils.exception.PublicTokenInvalidException;
import com.leopoldhsing.horizon.common.utils.exception.ResourcesNotAccessible;
import com.leopoldhsing.horizon.model.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * handle all unmatched exception in global scope
     *
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * handle PublicTokenInvalidException
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(PublicTokenInvalidException.class)
    public ResponseEntity<ErrorResponseDto> handlePublicTokenInvalidException(PublicTokenInvalidException exception, WebRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.EXPECTATION_FAILED,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.EXPECTATION_FAILED);
    }

    /**
     * handle ResourcesNotAccessible exception
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(ResourcesNotAccessible.class)
    public ResponseEntity<ErrorResponseDto> handleResourcesNotAccessibleException(ResourcesNotAccessible exception, WebRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.UNAUTHORIZED,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNAUTHORIZED);
    }
}

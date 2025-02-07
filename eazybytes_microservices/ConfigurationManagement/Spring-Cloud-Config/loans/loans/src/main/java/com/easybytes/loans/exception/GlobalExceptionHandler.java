package com.easybytes.loans.exception;


import com.easybytes.loans.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(LoanAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleLoanAlreadyExistsException(LoanAlreadyExistsException ex, WebRequest webRequest){


        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setApiPath(webRequest.getDescription(false));
        errorResponseDTO.setErrorMessage(ex.getMessage());
        errorResponseDTO.setErrorCode(HttpStatus.BAD_REQUEST);
        errorResponseDTO.setErrorTime(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponseDTO);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setApiPath(webRequest.getDescription(false));
        errorResponseDTO.setErrorMessage(ex.getMessage());
        errorResponseDTO.setErrorCode(HttpStatus.NOT_FOUND);
        errorResponseDTO.setErrorTime(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }
}
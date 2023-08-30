package com.company.hr.handler;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.error.BaseErrorResponse;
import com.company.hr.dto.error.InvalidRequestErrorResponse;
import com.company.hr.dto.error.RejectedParameter;
import com.company.hr.dto.error.ResourceNotFoundResponse;
import com.company.hr.exception.RecordNotFoundException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@EnableWebMvc
@RestControllerAdvice
public class ApplicationControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    List<RejectedParameter> rejectedParams = ex.getFieldErrors().stream()
        .map(error -> RejectedParameter.builder()
            .errorMessage(error.getDefaultMessage())
            .field(error.getField())
            .rejectedValue(error.getRejectedValue())
            .build())
        .collect(Collectors.toList());

    InvalidRequestErrorResponse response = InvalidRequestErrorResponse.builder()
        .status(ApplicationConstants.INVALID_REQUEST_STATUS)
        .code(HttpStatus.BAD_REQUEST.value())
        .cause(ApplicationConstants.INVALID_REQUEST_CAUSE)
        .suggestedAction(ApplicationConstants.INVALID_REQUEST_SUGGESTION)
        .resource(((ServletWebRequest) request).getRequest().getRequestURI())
        .timestamp(Instant.now())
        .errorCount(rejectedParams.size())
        .params(rejectedParams)
        .transactionId(UUID.randomUUID())
        .build();

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(response);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  protected ResponseEntity<InvalidRequestErrorResponse> handleMethodArgumentTypeMismatchException(
      MethodArgumentTypeMismatchException e, ServletWebRequest request) {

    List<RejectedParameter> rejectedParams = Collections.singletonList(RejectedParameter.builder()
        .rejectedValue(e.getValue())
        .field(e.getParameter().getParameterName())
        .errorMessage(e.getLocalizedMessage())
        .build());

    InvalidRequestErrorResponse response = InvalidRequestErrorResponse.builder()
        .status(ApplicationConstants.INVALID_REQUEST_STATUS)
        .code(HttpStatus.BAD_REQUEST.value())
        .cause(ApplicationConstants.INVALID_REQUEST_CAUSE)
        .suggestedAction(ApplicationConstants.INVALID_REQUEST_SUGGESTION)
        .resource(request.getRequest().getRequestURI())
        .timestamp(Instant.now())
        .errorCount(rejectedParams.size())
        .params(rejectedParams)
        .transactionId(UUID.randomUUID())
        .build();

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(response);
  }

  @Override
  protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    List<RejectedParameter> rejectedParams = Collections.singletonList(RejectedParameter.builder()
        .errorMessage(ex.getMessage())
        .field(ex.getVariableName())
        .build());

    InvalidRequestErrorResponse response = InvalidRequestErrorResponse.builder()
        .status(ApplicationConstants.INVALID_REQUEST_STATUS)
        .code(HttpStatus.BAD_REQUEST.value())
        .cause(ApplicationConstants.INVALID_REQUEST_CAUSE)
        .suggestedAction(ApplicationConstants.INVALID_REQUEST_SUGGESTION)
        .resource(((ServletWebRequest) request).getRequest().getRequestURI())
        .timestamp(Instant.now())
        .errorCount(rejectedParams.size())
        .params(rejectedParams)
        .transactionId(UUID.randomUUID())
        .build();

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(response);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
      HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    BaseErrorResponse response = BaseErrorResponse.builder()
        .status(ApplicationConstants.NOT_FOUND_STATUS)
        .code(HttpStatus.NOT_FOUND.value())
        .cause(ApplicationConstants.NOT_FOUND_CAUSE)
        .suggestedAction(ApplicationConstants.NOT_FOUND_SUGGESTION)
        .resource(((ServletWebRequest) request).getRequest().getRequestURI())
        .timestamp(Instant.now())
        .transactionId(UUID.randomUUID())
        .build();

    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(response);
  }

  @ExceptionHandler(RecordNotFoundException.class)
  public final ResponseEntity<ResourceNotFoundResponse> handleRecordNotFoundException(
      RecordNotFoundException e, ServletWebRequest request) {

    ResourceNotFoundResponse response = ResourceNotFoundResponse.builder()
        .status(ApplicationConstants.NOT_FOUND_STATUS)
        .code(HttpStatus.NOT_FOUND.value())
        .cause(ApplicationConstants.NOT_FOUND_CAUSE)
        .suggestedAction(ApplicationConstants.NOT_FOUND_SUGGESTION)
        .resource(request.getRequest().getRequestURI())
        .timestamp(Instant.now())
        .transactionId(UUID.randomUUID())
        .missingKey(e.getIdentifier())
        .build();

    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(response);
  }

}
package com.company.hr.handler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.company.hr.constants.ErrorResponseConstants;
import com.company.hr.constants.LoggerConstants;
import com.company.hr.dto.error.BaseErrorResponse;
import com.company.hr.dto.error.InvalidJsonResponse;
import com.company.hr.dto.error.InvalidRequestErrorResponse;
import com.company.hr.dto.error.MethodNotAllowedResponse;
import com.company.hr.dto.error.RejectedParameter;
import com.company.hr.dto.error.ResourceNotFoundResponse;
import com.company.hr.dto.error.UnauthorizedRequestResponse;
import com.company.hr.exception.DeniedPermissionException;
import com.company.hr.exception.RecordNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.argument.StructuredArguments;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@EnableWebMvc
@RestControllerAdvice
public class ApplicationControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    return handleInvalidRequest(ex, (ServletWebRequest) request);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  protected ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
      MethodArgumentTypeMismatchException ex, ServletWebRequest request) {
    return handleInvalidRequest(ex, request);
  }

  @Override
  protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    return handleInvalidRequest(ex, (ServletWebRequest) request);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    return handleInvalidRequest(ex, (ServletWebRequest) request);
  }

  @Override
  protected ResponseEntity<Object> handleServletRequestBindingException(
      ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    return handleInvalidRequest(ex, (ServletWebRequest) request);
  }

  @Override
  protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    return handleInvalidRequest(ex, (ServletWebRequest) request);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestPart(
      MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    return handleInvalidRequest(ex, (ServletWebRequest) request);
  }

  @Override
  protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    return handleInvalidRequest(ex, (ServletWebRequest) request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    InvalidJsonResponse.InvalidJsonResponseBuilder<?, ?> builder = InvalidJsonResponse.builder();
    Throwable cause = ex.getCause();
    if (cause instanceof JsonProcessingException) {
      JsonProcessingException e1 = (JsonProcessingException) cause;
      builder
          .parseError(ExceptionUtils.getMessage(cause))
          .line(e1.getLocation().getLineNr())
          .column(e1.getLocation().getColumnNr())
          .charOffset(e1.getLocation().getCharOffset())
          .byteOffset(e1.getLocation().getByteOffset())
          .offsetDesc(e1.getLocation().offsetDescription())
          .sourceDesc(e1.getLocation().sourceDescription());
    } else {
      builder.parseError(ExceptionUtils.getMessage(ex));
    }

    InvalidJsonResponse response = builder
        .status(ErrorResponseConstants.UNREADABLE_REQUEST_STATUS)
        .code(HttpStatus.BAD_REQUEST.value())
        .cause(ErrorResponseConstants.UNREADABLE_REQUEST_CAUSE)
        .suggestedAction(ErrorResponseConstants.UNREADABLE_REQUEST_SUGGESTION)
        .path(((ServletWebRequest) request).getRequest().getRequestURI())
        .timestamp(Instant.now().toString())
        .build();
    log.warn(ErrorResponseConstants.UNREADABLE_REQUEST_CAUSE,
        StructuredArguments.keyValue(LoggerConstants.JSON_HTTP_STATUS_KEY, response.getCode()),
        StructuredArguments.keyValue(LoggerConstants.JSON_DETAIL_MSG_KEY, ex.getMessage()));

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(response);
  }

  private ResponseEntity<Object> handleInvalidRequest(Exception ex, ServletWebRequest request) {

    List<RejectedParameter> rejectedParameters = null;
    if (ex instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException e1 = (MethodArgumentNotValidException) ex;
      rejectedParameters = e1.getFieldErrors().stream()
          .map(error -> RejectedParameter.builder()
              .errorMessage(error.getDefaultMessage())
              .field(error.getField())
              .rejectedValue(error.getRejectedValue())
              .build())
          .collect(Collectors.toList());
    } else if (ex instanceof MethodArgumentTypeMismatchException) {
      MethodArgumentTypeMismatchException e1 = (MethodArgumentTypeMismatchException) ex;
      rejectedParameters = Collections.singletonList(RejectedParameter.builder()
          .rejectedValue(e1.getValue())
          .field(e1.getParameter().getParameterName())
          .errorMessage(e1.getLocalizedMessage())
          .build());
    } else if (ex instanceof MissingPathVariableException) {
      MissingPathVariableException e1 = (MissingPathVariableException) ex;
      rejectedParameters = Collections.singletonList(RejectedParameter.builder()
          .errorMessage(e1.getMessage())
          .field(e1.getVariableName())
          .build());
    } else if (ex instanceof MissingServletRequestParameterException) {
      MissingServletRequestParameterException e1 = (MissingServletRequestParameterException) ex;
      rejectedParameters = Collections.singletonList(RejectedParameter.builder()
          .errorMessage(e1.getMessage())
          .field(e1.getParameterName())
          .build());
    } else if (ex instanceof MissingRequestHeaderException) {
      MissingRequestHeaderException e1 = (MissingRequestHeaderException) ex;
      rejectedParameters = Collections.singletonList(RejectedParameter.builder()
          .errorMessage(e1.getMessage())
          .field(e1.getHeaderName())
          .build());
    } else if (ex instanceof TypeMismatchException) {
      TypeMismatchException e1 = (TypeMismatchException) ex;
      rejectedParameters = Collections.singletonList(RejectedParameter.builder()
          .errorMessage(e1.getMessage())
          .rejectedValue(e1.getPropertyName())
          .build());
    } else if (ex instanceof MissingServletRequestPartException) {
      MissingServletRequestPartException e1 = (MissingServletRequestPartException) ex;
      rejectedParameters = Collections.singletonList(RejectedParameter.builder()
          .errorMessage(e1.getMessage())
          .field(e1.getRequestPartName())
          .build());
    } else if (ex instanceof BindException) {
      BindException e1 = (BindException) ex;
      rejectedParameters = e1.getFieldErrors().stream()
          .map(error -> RejectedParameter.builder()
              .rejectedValue(error.getRejectedValue())
              .field(error.getField())
              .errorMessage(error.getDefaultMessage())
              .build())
          .collect(Collectors.toList());
    } else if (ex instanceof HttpMessageNotReadableException) {
      HttpMessageNotReadableException e1 = (HttpMessageNotReadableException) ex;
      rejectedParameters = Collections.singletonList(RejectedParameter.builder()
          .errorMessage(e1.getLocalizedMessage())
          .build());
    }

    InvalidRequestErrorResponse response = InvalidRequestErrorResponse.builder()
        .status(ErrorResponseConstants.INVALID_REQUEST_STATUS)
        .code(HttpStatus.BAD_REQUEST.value())
        .cause(ErrorResponseConstants.INVALID_REQUEST_CAUSE)
        .suggestedAction(ErrorResponseConstants.INVALID_REQUEST_SUGGESTION)
        .path(request.getRequest().getRequestURI())
        .timestamp(Instant.now().toString())
        .errorCount(rejectedParameters != null ? rejectedParameters.size() : 0)
        .params(rejectedParameters)
        .build();
    log.warn(ErrorResponseConstants.INVALID_REQUEST_CAUSE,
        StructuredArguments.keyValue(LoggerConstants.JSON_HTTP_STATUS_KEY, response.getCode()),
        StructuredArguments.keyValue(LoggerConstants.JSON_ERROR_COUNT_KEY, response.getErrorCount()),
        StructuredArguments.keyValue(LoggerConstants.JSON_PARAMS_KEY, response.getParams()));

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(response);
  }

  @ExceptionHandler(JWTVerificationException.class)
  protected ResponseEntity<UnauthorizedRequestResponse> handleJWTVerificationException(
      JWTVerificationException ex, ServletWebRequest request) {

    UnauthorizedRequestResponse response = UnauthorizedRequestResponse.builder()
        .status(ErrorResponseConstants.UNAUTHORIZED_REQUEST_STATUS)
        .code(HttpStatus.UNAUTHORIZED.value())
        .cause(ErrorResponseConstants.UNAUTHORIZED_REQUEST_CAUSE)
        .suggestedAction(ErrorResponseConstants.UNAUTHORIZED_REQUEST_SUGGESTION)
        .path(request.getRequest().getRequestURI())
        .timestamp(Instant.now().toString())
        .detailMsg(ex.getMessage())
        .build();
    log.warn(ErrorResponseConstants.UNAUTHORIZED_REQUEST_CAUSE,
        StructuredArguments.keyValue(LoggerConstants.JSON_HTTP_STATUS_KEY, response.getCode()),
        StructuredArguments.keyValue(LoggerConstants.JSON_DETAIL_MSG_KEY, ex.getMessage()));

    return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body(response);
  }

  @ExceptionHandler(DeniedPermissionException.class)
  protected ResponseEntity<BaseErrorResponse> handleDeniedPermissionException(
      DeniedPermissionException ex, ServletWebRequest request) {

    BaseErrorResponse response = BaseErrorResponse.builder()
        .status(ErrorResponseConstants.FORBIDDEN_REQUEST_STATUS)
        .code(HttpStatus.FORBIDDEN.value())
        .cause(ErrorResponseConstants.FORBIDDEN_REQUEST_CAUSE)
        .suggestedAction(ErrorResponseConstants.FORBIDDEN_REQUEST_SUGGESTION)
        .path(request.getRequest().getRequestURI())
        .timestamp(Instant.now().toString())
        .build();
    log.warn(ErrorResponseConstants.FORBIDDEN_REQUEST_CAUSE,
        StructuredArguments.keyValue(LoggerConstants.JSON_HTTP_STATUS_KEY, response.getCode()));

    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body(response);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
      HttpHeaders headers,
      HttpStatus status, WebRequest request) {

    BaseErrorResponse response = BaseErrorResponse.builder()
        .status(ErrorResponseConstants.NOT_FOUND_STATUS)
        .code(HttpStatus.NOT_FOUND.value())
        .cause(ErrorResponseConstants.NOT_FOUND_CAUSE)
        .suggestedAction(ErrorResponseConstants.NOT_FOUND_SUGGESTION)
        .path(((ServletWebRequest) request).getRequest().getRequestURI())
        .timestamp(Instant.now().toString())
        .build();
    log.warn(ErrorResponseConstants.NOT_FOUND_CAUSE,
        StructuredArguments.keyValue(LoggerConstants.JSON_HTTP_STATUS_KEY, response.getCode()),
        StructuredArguments.keyValue(LoggerConstants.JSON_PATH_URI_KEY, response.getPath()));

    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(response);
  }

  @ExceptionHandler(RecordNotFoundException.class)
  protected final ResponseEntity<ResourceNotFoundResponse> handleRecordNotFoundException(
      RecordNotFoundException e, ServletWebRequest request) {

    ResourceNotFoundResponse response = ResourceNotFoundResponse.builder()
        .status(ErrorResponseConstants.NOT_FOUND_STATUS)
        .code(HttpStatus.NOT_FOUND.value())
        .cause(ErrorResponseConstants.NOT_FOUND_CAUSE)
        .suggestedAction(ErrorResponseConstants.NOT_FOUND_SUGGESTION)
        .path(request.getRequest().getRequestURI())
        .timestamp(Instant.now().toString())
        .missingKey(e.getIdentifier())
        .build();
    log.warn(ErrorResponseConstants.NOT_FOUND_CAUSE,
        StructuredArguments.keyValue(LoggerConstants.JSON_HTTP_STATUS_KEY, response.getCode()),
        StructuredArguments.keyValue(LoggerConstants.JSON_PATH_URI_KEY, response.getPath()),
        StructuredArguments.keyValue(LoggerConstants.JSON_MISSING_ID_KEY, e.getIdentifier()));

    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(response);
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {

    MethodNotAllowedResponse response = MethodNotAllowedResponse.builder()
        .status(ErrorResponseConstants.METHOD_NOT_ALLOWED_STATUS)
        .code(HttpStatus.METHOD_NOT_ALLOWED.value())
        .cause(ErrorResponseConstants.METHOD_NOT_ALLOWED_CAUSE)
        .suggestedAction(ErrorResponseConstants.METHOD_NOT_ALLOWED_SUGGESTION)
        .path(((ServletWebRequest) request).getRequest().getRequestURI())
        .timestamp(Instant.now().toString())
        .methodUsed(ex.getMethod())
        .supportedMethods(ex.getSupportedMethods())
        .build();
    log.warn(ErrorResponseConstants.METHOD_NOT_ALLOWED_CAUSE,
        StructuredArguments.keyValue(LoggerConstants.JSON_HTTP_STATUS_KEY, response.getCode()),
        StructuredArguments.keyValue(LoggerConstants.JSON_METHOD_USED_KEY, response.getMethodUsed()),
        StructuredArguments.keyValue(LoggerConstants.JSON_SUPPORTED_METHODS_KEY, response.getSupportedMethods()));

    return ResponseEntity
        .status(HttpStatus.METHOD_NOT_ALLOWED)
        .body(response);
  }

}
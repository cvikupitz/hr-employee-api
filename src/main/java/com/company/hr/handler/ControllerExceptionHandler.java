package com.company.hr.handler;

import com.company.hr.dto.error.InvalidRequestErrorResponse;
import com.company.hr.dto.error.RejectedParameter;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<InvalidRequestErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

    List<RejectedParameter> rejectedParams = e.getFieldErrors().stream()
        .map(error -> RejectedParameter.builder()
            .errorMessage(error.getDefaultMessage())
            .field(error.getField())
            .rejectedValue(error.getRejectedValue())
            .build())
        .collect(Collectors.toList());

    InvalidRequestErrorResponse response = InvalidRequestErrorResponse.builder()
        .status("COM-HR-400")
        .code(HttpStatus.BAD_REQUEST.value())
        .cause("Request was invalid")
        .suggestedAction("Please check the attached payload for invalid payload members and make the necessary corrections.")
        .timestamp(Instant.now())
        .errorCount(rejectedParams.size())
        .params(rejectedParams)
        .transactionId(UUID.randomUUID())
        .build();

    return ResponseEntity.badRequest().body(response);
  }
}
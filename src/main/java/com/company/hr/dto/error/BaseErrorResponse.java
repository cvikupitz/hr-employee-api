package com.company.hr.dto.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseErrorResponse {

  private String status;
  private int code;
  private String cause;
  private String suggestedAction;
  private String resource;
  @JsonFormat(shape = Shape.STRING)
  private Instant timestamp;
  private UUID transactionId;
}
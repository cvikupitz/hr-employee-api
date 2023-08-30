package com.company.hr.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RejectedParameter {

  private String field;
  private Object rejectedValue;
  private String errorMessage;
}
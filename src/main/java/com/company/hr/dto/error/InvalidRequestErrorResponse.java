package com.company.hr.dto.error;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvalidRequestErrorResponse extends BaseErrorResponse {

  private int errorCount;
  private List<RejectedParameter> params;
}
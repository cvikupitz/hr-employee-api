package com.company.hr.pojo;

import com.company.hr.dto.employee.EmployeeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public final class UpsertResult {

  private EmployeeDto employeeDto;
  private boolean created;
}
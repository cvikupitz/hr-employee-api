package com.company.hr.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

  private Integer id;
  private String socialSecurityNumber;
  private String firstName;
  private String middleName;
  private String lastName;
  private String dateOfBirth;
  private String gender;
  private String startDate;
  private String endDate;
  private Float salary;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String zipCode;
  private String primaryPhone;
  private String secondaryPhone;
  private String emailAddress;
  private Integer departmentId;
  private Integer statusId;
  private Integer titleId;
  private Integer typeId;
}
package com.company.hr.dto.employee;

import com.company.hr.constants.ConstraintConstants;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeSaveDto {

  @NotBlank(message = "The member 'socialSecurityNumber' cannot be null, empty, or blank.")
  @Pattern(regexp = ConstraintConstants.SSN_REGEX, message =
      "The member 'socialSecurityNumber' must match the regex pattern: "
          + ConstraintConstants.SSN_REGEX)
  private String socialSecurityNumber;

  @NotBlank(message = "The member 'firstName' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.NAME_CHAR_LIMIT, message = "The member 'firstName' cannot exceed "
      + ConstraintConstants.NAME_CHAR_LIMIT + " characters.")
  @Pattern(regexp = ConstraintConstants.NAME_REGEX, message =
      "The member 'firstName' must match the regex pattern: " + ConstraintConstants.NAME_REGEX)
  private String firstName;

  @NotBlank(message = "The member 'middleName' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.NAME_CHAR_LIMIT, message =
      "The member 'middleName' cannot exceed " + ConstraintConstants.NAME_CHAR_LIMIT
          + " characters.")
  @Pattern(regexp = ConstraintConstants.NAME_REGEX, message =
      "The member 'middleName' must match the regex pattern: " + ConstraintConstants.NAME_REGEX)
  private String middleName;

  @NotBlank(message = "The member 'lastName' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.NAME_CHAR_LIMIT, message = "The member 'lastName' cannot exceed "
      + ConstraintConstants.NAME_CHAR_LIMIT + " characters.")
  @Pattern(regexp = ConstraintConstants.NAME_REGEX, message =
      "The member 'lastName' must match the regex pattern: " + ConstraintConstants.NAME_REGEX)
  private String lastName;

  @NotBlank(message = "The member 'dateOfBirth' cannot be null, empty, or blank.")
  @Pattern(regexp = ConstraintConstants.DATE_REGEX, message =
      "The member 'dateOfBirth' must match the regex pattern: " + ConstraintConstants.DATE_REGEX)
  private String dateOfBirth;

  @NotBlank(message = "The member 'gender' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.NAME_CHAR_LIMIT, message = "The member 'gender' cannot exceed "
      + ConstraintConstants.GENDER_CHAR_LIMIT + " characters.")
  @Pattern(regexp = ConstraintConstants.GENDER_REGEX, message =
      "The member 'gender' must match the regex pattern: " + ConstraintConstants.GENDER_REGEX)
  private String gender;

  @NotBlank(message = "The member 'startDate' cannot be null, empty, or blank.")
  @Pattern(regexp = ConstraintConstants.DATE_REGEX, message =
      "The member 'startDate' must match the regex pattern: " + ConstraintConstants.DATE_REGEX)
  private String startDate;

  @Pattern(regexp = ConstraintConstants.DATE_REGEX, message =
      "The member 'endDate' must match the regex pattern: " + ConstraintConstants.DATE_REGEX)
  private String endDate;

  @NotNull(message = "The member 'salary' cannot be null.")
  @Min(value = 1, message = "The member 'salary' must be 1.00 or greater.")
  private Float salary;

  @NotBlank(message = "The member 'addressLine1' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT, message =
      "The member 'addressLine1' cannot exceed " + ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT
          + " characters.")
  private String addressLine1;

  @Size(max = ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT, message =
      "The member 'addressLine2' cannot exceed " + ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT
          + " characters.")
  private String addressLine2;

  @NotBlank(message = "The member 'city' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT, message =
      "The member 'city' cannot exceed " + ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT
          + " characters.")
  private String city;

  @NotBlank(message = "The member 'state' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.STATE_CHAR_LIMIT, message = "The member 'state' cannot exceed "
      + ConstraintConstants.STATE_CHAR_LIMIT + " characters.")
  @Pattern(regexp = ConstraintConstants.STATE_REGEX, message =
      "The member 'state' must match the regex pattern: " + ConstraintConstants.STATE_REGEX)
  private String state;

  @NotBlank(message = "The member 'zipCode' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.ZIP_CODE_CHAR_LIMIT, message =
      "The member 'zipCode' cannot exceed " + ConstraintConstants.ZIP_CODE_CHAR_LIMIT
          + " characters.")
  @Pattern(regexp = ConstraintConstants.ZIP_CODE_REGEX, message =
      "The member 'zipCode' must match the regex pattern: " + ConstraintConstants.ZIP_CODE_REGEX)
  private String zipCode;

  @NotBlank(message = "The member 'primaryPhone' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.PHONE_NUMBER_CHAR_LIMIT, message =
      "The member 'primaryPhone' cannot exceed " + ConstraintConstants.PHONE_NUMBER_CHAR_LIMIT
          + " characters.")
  @Pattern(regexp = ConstraintConstants.PHONE_NUMBER_REGEX, message =
      "The member 'primaryPhone' must match the regex pattern: "
          + ConstraintConstants.PHONE_NUMBER_REGEX)
  private String primaryPhone;

  @Size(max = ConstraintConstants.PHONE_NUMBER_CHAR_LIMIT, message =
      "The member 'secondaryPhone' cannot exceed " + ConstraintConstants.PHONE_NUMBER_CHAR_LIMIT
          + " characters.")
  @Pattern(regexp = ConstraintConstants.PHONE_NUMBER_REGEX, message =
      "The member 'secondaryPhone' must match the regex pattern: "
          + ConstraintConstants.PHONE_NUMBER_REGEX)
  private String secondaryPhone;

  @NotBlank(message = "The member 'emailAddress' cannot be null, empty, or blank.")
  @Size(max = ConstraintConstants.EMAIL_CHAR_LIMIT, message =
      "The member 'emailAddress' cannot exceed " + ConstraintConstants.EMAIL_CHAR_LIMIT
          + " characters.")
  @Pattern(regexp = ConstraintConstants.EMAIL_REGEX, message =
      "The member 'emailAddress' must match the regex pattern: "
          + ConstraintConstants.EMAIL_REGEX)
  private String emailAddress;

  @NotNull(message = "The member 'departmentId' cannot be null.")
  private Integer departmentId;

  @NotNull(message = "The member 'employeeStatusId' cannot be null.")
  private Integer employeeStatusId;

  @NotNull(message = "The member 'employeeTitleId' cannot be null.")
  private Integer employeeTitleId;

  @NotNull(message = "The member 'employeeTypeId' cannot be null.")
  private Integer employeeTypeId;
}
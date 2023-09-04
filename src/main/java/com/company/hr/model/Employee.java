package com.company.hr.model;

import com.company.hr.constants.ConstraintConstants;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
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
@Entity
@Table(name = "employees")
public class Employee extends RootModel implements Serializable {

  private static final long serialVersionUID = 6590314153585833700L;

  @Id
  @GeneratedValue
  @Column(name = "_ID", nullable = false, unique = true, updatable = false)
  private Integer id;
  @Column(name = "SSN", nullable = false, length = ConstraintConstants.SSN_CHAR_LIMIT, updatable = false)
  private String socialSecurityNumber;
  @Column(name = "FIRST_NAME", nullable = false, length = ConstraintConstants.NAME_CHAR_LIMIT)
  private String firstName;
  @Column(name = "MIDDLE_NAME", nullable = false, length = ConstraintConstants.NAME_CHAR_LIMIT)
  private String middleName;
  @Column(name = "LAST_NAME", nullable = false, length = ConstraintConstants.NAME_CHAR_LIMIT)
  private String lastName;
  @Column(name = "DATE_OF_BIRTH", nullable = false)
  private Date dateOfBirth;
  @Column(name = "GENDER", nullable = false, length = ConstraintConstants.GENDER_CHAR_LIMIT)
  private String gender;
  @Column(name = "START_DATE", nullable = false)
  private Date startDate;
  @Column(name = "END_DATE")
  private Date endDate;
  @Column(name = "SALARY", nullable = false)
  private Float salary;
  @Column(name = "ADDRESS_LINE_1", nullable = false, length = ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT)
  private String addressLine1;
  @Column(name = "ADDRESS_LINE_2", length = ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT)
  private String addressLine2;
  @Column(name = "CITY", nullable = false, length = ConstraintConstants.ADDRESS_LINE_CHAR_LIMIT)
  private String city;
  @Column(name = "STATE", nullable = false, length = ConstraintConstants.STATE_CHAR_LIMIT)
  private String state;
  @Column(name = "ZIP_CODE", nullable = false, length = ConstraintConstants.ZIP_CODE_CHAR_LIMIT)
  private String zipCode;
  @Column(name = "PRIMARY_PHONE", nullable = false, length = ConstraintConstants.PHONE_NUMBER_CHAR_LIMIT)
  private String primaryPhone;
  @Column(name = "SECONDARY_PHONE", length = ConstraintConstants.PHONE_NUMBER_CHAR_LIMIT)
  private String secondaryPhone;
  @Column(name = "EMAIL_ADDRESS", nullable = false, length = ConstraintConstants.EMAIL_CHAR_LIMIT)
  private String emailAddress;

  @Column(name = "DEPARTMENT_ID")
  @JoinColumn(table = "departments", referencedColumnName = "_ID", nullable = false)
  private Department department;
  @Column(name = "STATUS_ID")
  @JoinColumn(table = "employee_statuses", columnDefinition = "_ID", nullable = false)
  private EmployeeStatus status;
  @Column(name = "TITLE_ID")
  @JoinColumn(table = "employee_titles", columnDefinition = "_ID", nullable = false)
  private EmployeeTitle title;
  @Column(name = "TYPE_ID")
  @JoinColumn(table = "employee_types", columnDefinition = "_ID", nullable = false)
  private EmployeeType type;
}
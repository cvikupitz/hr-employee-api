package com.company.hr.constants;

public final class EndpointConstants {

  private EndpointConstants() {
    // Private constructor to hide public implicit one
  }

  public static final String V1_ROOT_URI = "/api/v1";
  public static final String METADATA_ROOT_URI = "/metadata";
  public static final String DEPARTMENTS_ROOT_URI = "/departments";
  public static final String EMPLOYEE_STATUSES_ROOT_URI = "/employee-statuses";
  public static final String EMPLOYEE_TITLES_ROOT_URI = "/employee-titles";
  public static final String EMPLOYEE_TYPES_ROOT_URI = "/employee-types";
  public static final String EMPLOYEES_ROOT_URI = "/employees";
  public static final String ID_PATH_VARIABLE_URI = "/{id}";
}
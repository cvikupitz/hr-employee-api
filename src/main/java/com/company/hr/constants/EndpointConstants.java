package com.company.hr.constants;

public final class EndpointConstants {

  private EndpointConstants() {
    // Private constructor to hide public implicit one
  }

  public static final String METADATA_ROOT_URI = "/api/metadata";
  public static final String EMPLOYEE_STATUSES_URI = "/employee-statuses";
  public static final String EMPLOYEE_TITLES_URI = "/employee-titles";
  public static final String EMPLOYEE_TYPES_URI = "/employee-types";

  public static final String ID_PATH_VARIABLE_URI = "/{id}";
}
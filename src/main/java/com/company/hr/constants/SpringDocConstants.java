package com.company.hr.constants;

public final class SpringDocConstants {

  private SpringDocConstants() {
  }

  public static final String HTTP_OK = "200";
  public static final String HTTP_OK_DESCRIPTION = "The request was successful.";

  public static final String HTTP_CREATED = "201";
  public static final String HTTP_CREATED_DESCRIPTION = "The request was successful, and the new resource was saved.";

  public static final String HTTP_NO_CONTENT = "204";
  public static final String HTTP_NO_CONTENT_DESCRIPTION = "The request was successful, but no content was available to send back.";

  public static final String HTTP_BAD_REQUEST = "400";
  public static final String HTTP_BAD_REQUEST_DESCRIPTION = "The request was invalid and could not be processed.";

  public static final String HTTP_UNAUTHORIZED = "401";
  public static final String HTTP_UNAUTHORIZED_DESCRIPTION = "The client is not authenticated.";

  public static final String HTTP_FORBIDDEN = "403";
  public static final String HTTP_FORBIDDEN_DESCRIPTION = "The client is authenticated, but is not allowed access to the specified resource.";

  public static final String HTTP_NOT_FOUND = "404";
  public static final String HTTP_NOT_FOUND_DESCRIPTION = "The specified resource could not be found.";

  public static final String HTTP_INTERNAL_SERVER_ERROR = "500";
  public static final String HTTP_INTERNAL_SERVER_ERROR_DESCRIPTION = "The server failed to process the request. Check the application logs for further details.";

  public static final String APP_NAME = "COM HR API Service";
  public static final String VERSION = "v1";

  public static final String DEPARTMENT_API_TAG = "Departments API";
  public static final String EMPLOYEES_API_TAG = "Employees API";
  public static final String EMPLOYEE_STATUSES_API_TAG = "Employee Statuses API";
  public static final String EMPLOYEE_TITLES_API_TAG = "Employee Titles API";
  public static final String EMPLOYEE_TYPES_API_TAG = "Employee Types API";
  public static final String METADATA_API_TAG = "Metadata API";
}
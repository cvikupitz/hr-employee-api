package com.company.hr.constants;

public final class ApplicationConstants {

  private ApplicationConstants() {
    // Private constructor to hide implicit public one
  }

  public static final String MAPSTRUCT_SPRING_COMPONENT = "spring";

  public static final String AUTH_HEADER_KEY = "x-authorization";
  public static final String REQUEST_ID_HEADER_KEY = "x-com-hr-request-id";

  private static final String ERROR_PREFIX = "COM-HR-";

  public static final String INVALID_REQUEST_STATUS = ERROR_PREFIX + "400";
  public static final String INVALID_REQUEST_CAUSE = "One or more fields in the request were invalid.";
  public static final String INVALID_REQUEST_SUGGESTION = "Please check the attached list of affected members and make the necessary corrections.";

  public static final String UNAUTHORIZED_REQUEST_STATUS = ERROR_PREFIX + "401";
  public static final String UNAUTHORIZED_REQUEST_CAUSE = "The request failed as the required authorization header(s) did not contain valid credentials.";
  public static final String UNAUTHORIZED_REQUEST_SUGGESTION = "Please re-check the required authorization header(s) and your supplied values and ensure they are present and valid.";

  public static final String NOT_FOUND_STATUS = ERROR_PREFIX + "404";
  public static final String NOT_FOUND_CAUSE = "The requested resource/URI could not be found.";
  public static final String NOT_FOUND_SUGGESTION = "Please re-check the URI and/or request parameters.";
}
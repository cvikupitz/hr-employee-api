package com.company.hr.constants;

public class ErrorResponseConstants {

  private ErrorResponseConstants() {
    // Private constructor to hide implicit public one
  }

  private static final String ERROR_PREFIX = "COM-HR-";

  public static final String INVALID_REQUEST_STATUS = ERROR_PREFIX + "400-1";
  public static final String INVALID_REQUEST_CAUSE = "One or more fields in the request were invalid.";
  public static final String INVALID_REQUEST_SUGGESTION = "Please check the attached list of affected members and make the necessary corrections.";

  public static final String UNREADABLE_REQUEST_STATUS = ERROR_PREFIX + "400-2";
  public static final String UNREADABLE_REQUEST_CAUSE = "The request sent is syntactically invalid (eg. missing comma, unclosed quotes, etc).";
  public static final String UNREADABLE_REQUEST_SUGGESTION = "Please re-check the request payload being sent.";

  public static final String UNAUTHORIZED_REQUEST_STATUS = ERROR_PREFIX + "401";
  public static final String UNAUTHORIZED_REQUEST_CAUSE =
      "The request failed as the header '" + ApplicationConstants.HEADER_AUTHORIZATION_KEY
          + "' was not present, or the value did not contain valid credentials.";
  public static final String UNAUTHORIZED_REQUEST_SUGGESTION = "Please check the header exists and a correct and valid JWT token is provided.";

  public static final String FORBIDDEN_REQUEST_STATUS = ERROR_PREFIX + "403";
  public static final String FORBIDDEN_REQUEST_CAUSE = "The request failed as the authenticated client does not have sufficient permissions to access this resource.";
  public static final String FORBIDDEN_REQUEST_SUGGESTION = "Please re-check the URI, or provide authentication with sufficient permissions.";

  public static final String NOT_FOUND_STATUS = ERROR_PREFIX + "404";
  public static final String NOT_FOUND_CAUSE = "The requested resource/URI could not be found.";
  public static final String NOT_FOUND_SUGGESTION = "Please re-check the URI and request parameters.";

  public static final String METHOD_NOT_ALLOWED_STATUS = ERROR_PREFIX + "405";
  public static final String METHOD_NOT_ALLOWED_CAUSE = "The HTTP method used is not allowed at the specified URI.";
  public static final String METHOD_NOT_ALLOWED_SUGGESTION = "Please check the method used and change it to one of the allowed methods listed.";

  public static final String MEDIA_NOT_ACCEPTED_STATUS = ERROR_PREFIX + "406";
  public static final String MEDIA_NOT_ACCEPTED_CAUSE = "The resource requested cannot be returned in any media types provided in the 'Accept' header.";
  public static final String MEDIA_NOT_ACCEPTED_SUGGESTION = "Please check the list of acceptable media types and set the 'Accept' header value to any one of these allowed values.";

  public static final String MEDIA_NOT_SUPPORTED_STATUS = ERROR_PREFIX + "415";
  public static final String MEDIA_NOT_SUPPORTED_CAUSE = "The server rejected the request as the media type sent in 'Content-Type' header is not supported.";
  public static final String MEDIA_NOT_SUPPORTED_SUGGESTION = "Please check the list of acceptable media types and set the 'Content-Type' header value to any one of these allowed values.";
}
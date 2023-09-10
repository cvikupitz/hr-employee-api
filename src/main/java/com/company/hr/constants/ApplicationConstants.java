package com.company.hr.constants;

public final class ApplicationConstants {

  private ApplicationConstants() {
    // Private constructor to hide implicit public one
  }

  public static final String MAPSTRUCT_SPRING_COMPONENT = "spring";

  public static final String HEADER_CLIENT_KEY = "X-Client-Name";
  public static final String HEADER_AUTHORIZATION_KEY = "X-Authorization";
  public static final String HEADER_REQUEST_ID_KEY = "X-Request-ID";

  public static final String DEFAULT_PAGE_SIZE_REQUEST_PARAM = "1000";
  public static final int MAX_PAGE_SIZE_REQUEST_PARAM = 2000;
  public static final String DEFAULT_OFFSET_REQUEST_PARAM = "0";
}
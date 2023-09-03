package com.company.hr.constants;

public final class ConstraintConstants {

  private ConstraintConstants() {
    // Private constructor to hide implicit public one
  }

  public static final int NAME_CHAR_LIMIT = 50;
  public static final String NAME_REGEX = "^[a-zA-Z]+$";
  public static final int SSN_CHAR_LIMIT = 11;
  public static final String SSN_REGEX = "^\\d{3}-\\d{2}-\\d{4}$";
  public static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
  public static final int ADDRESS_LINE_CHAR_LIMIT = 64;
  public static final int STATE_CHAR_LIMIT = 2;
  public static final String STATE_REGEX = "^[A-Z]{2}$";
  public static final int ZIP_CODE_CHAR_LIMIT = 10;
  public static final String ZIP_CODE_REGEX = "^\\d{5}(-\\d{4})?$";
  public static final int PHONE_NUMBER_CHAR_LIMIT = 10;
  public static final String PHONE_NUMBER_REGEX = "^\\d{10}$";
  public static final int EMAIL_CHAR_LIMIT = 256;
  public static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
}
package com.company.hr.exception;

import lombok.Getter;

@Getter
public class DeniedPermissionException extends RuntimeException {

  private static final long serialVersionUID = 6856597781240924410L;

  public DeniedPermissionException(String msg) {
    super(msg);
  }
}
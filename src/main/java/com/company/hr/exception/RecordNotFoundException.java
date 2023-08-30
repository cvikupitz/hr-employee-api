package com.company.hr.exception;

import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 8099545928678586239L;

  private final Object identifier;

  public RecordNotFoundException(String message, Object identifier) {
    super(message);
    this.identifier = identifier;
  }
}
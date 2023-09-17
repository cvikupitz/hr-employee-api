package com.company.hr.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Operator {

  EQUALS("e"),
  GREATER_THAN_OR_EQUALS("gte"),
  GREATER_THAN("gt"),
  LESS_THAN_OR_EQUALS("lte"),
  LESS_THAN("lt");

  private final String abbreviation;

  private static String getAllPossibleValues() {

    StringBuilder builder = new StringBuilder();
    for (Operator operator : Operator.values()) {
      builder.append(operator.name()).append(",");
    }

    return builder.substring(0, builder.length() - 1);
  }
}
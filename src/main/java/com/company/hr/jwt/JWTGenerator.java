package com.company.hr.jwt;

import com.company.hr.enums.PermissionLevel;
import java.io.IOException;

public final class JWTGenerator {

  public static void main(String[] args) {

    if (args.length != 3) {
      System.err.println("Invalid number of arguments.");
      System.err.printf("Args: appName <%s> secretFilePath\n", getAllAvailablePermissions());
      System.exit(1);
    }

    String appName = args[0];
    PermissionLevel permissionLevel = resolvePermissionLevel(args[1]);
    String secretPath = args[2];

    JWTAuthService service = instantiateJwtAuth(secretPath);
    String key = service.createToken(appName, permissionLevel.getLevel());
    System.out.printf("-------------------------------- JWT key generated with %s permissions:\n", permissionLevel);
    System.out.println(key);
  }

  private static PermissionLevel resolvePermissionLevel(String value) {

    for (PermissionLevel level : PermissionLevel.values()) {
      if (value.equalsIgnoreCase(level.name())) {
        return level;
      }
    }

    throw new IllegalArgumentException("Failed to resolve permission level, invalid parameter specified: '" +
        value + "', possible values are: " + getAllAvailablePermissions());
  }

  private static JWTAuthService instantiateJwtAuth(String secretPath) {

    try {
      return new JWTAuthService(secretPath);
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to instantiate the JWT auth service.", e);
    }
  }

  private static String getAllAvailablePermissions() {

    StringBuilder builder = new StringBuilder();
    for (PermissionLevel level : PermissionLevel.values()) {
      builder.append(level.name()).append(",");
    }

    return builder.substring(0, builder.length() - 1);
  }

}
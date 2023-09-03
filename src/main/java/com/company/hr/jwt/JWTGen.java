package com.company.hr.jwt;

import com.company.hr.enums.ClientRole;

public final class JWTGen {

  public static void main(String[] args) {

    if (args.length != 1) {
      System.err.println("Invalid number of arguments.");
      System.err.println("Usage: JWTGen <appName>");
      System.exit(1);
    }

    JWTAuthService service = new JWTAuthService(System.getProperty("com.hr.key").getBytes());
    String key = service.createToken(args[0], ClientRole.ADMINISTRATOR.getLevel());
    System.out.println(key);
  }

}
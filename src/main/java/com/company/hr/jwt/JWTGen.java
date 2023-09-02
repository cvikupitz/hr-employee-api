package com.company.hr.jwt;

import com.company.hr.enums.ClientRole;

public final class JWTGen {

  public static void main(String[] args) {

    if (args.length != 2) {
      System.err.println("Invalid number of arguments.");
      System.err.println("Usage: JWTGen <orgName> <appName>");
      System.exit(1);
    }

    JWTAuthService service = new JWTAuthService(System.getProperty("com.hr.key").getBytes());
    String key = service.createToken(args[0], args[1], ClientRole.ADMINISTRATOR.getLevel());
    System.out.println(key);
  }

}
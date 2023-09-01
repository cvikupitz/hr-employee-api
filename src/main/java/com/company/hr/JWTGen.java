package com.company.hr;

import com.company.hr.service.JWTAuthService;

public class JWTGen {

  public static void main(String[] args) {

    JWTAuthService service = new JWTAuthService(System.getProperty("com.hr.key"));
    String key = service.createToken("BENEFITS-COORDINATOR", "HEALTH-WELLNESS");
    System.out.println(key);
  }

}
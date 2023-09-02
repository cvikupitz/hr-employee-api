package com.company.hr.config;

import com.company.hr.filters.JwtAuthInterceptor;
import com.company.hr.jwt.JWTAuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

  @Bean
  public JWTAuthService registerJwtService() {
    return new JWTAuthService(System.getProperty("com.hr.key").getBytes());
  }

  @Bean
  public JwtAuthInterceptor registerJwtAuthInterceptor(JWTAuthService jwtAuthService) {
    return new JwtAuthInterceptor(jwtAuthService);
  }

}
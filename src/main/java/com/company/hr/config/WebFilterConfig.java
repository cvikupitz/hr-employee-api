package com.company.hr.config;

import com.company.hr.filters.JwtAuthInterceptor;
import com.company.hr.filters.RequestLoggerInterceptor;
import com.company.hr.jwt.JWTAuthService;
import java.io.IOException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebFilterConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    JWTAuthService jwtAuthService;
    try {
      jwtAuthService = new JWTAuthService(System.getProperty("jwt.secret.path"));
    } catch (IOException e) {
      throw new IllegalStateException("Failed to instantiate the JWT authentication service,", e);
    }

    registry.addInterceptor(new RequestLoggerInterceptor());
    registry.addInterceptor(new JwtAuthInterceptor(jwtAuthService));
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(MediaType.APPLICATION_JSON)
        .ignoreAcceptHeader(false);
  }
}
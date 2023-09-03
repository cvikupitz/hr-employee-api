package com.company.hr.config;

import com.company.hr.constants.EndpointConstants;
import com.company.hr.filters.JwtAuthInterceptor;
import com.company.hr.filters.RequestLoggerInterceptor;
import com.company.hr.jwt.JWTAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebFilterConfig implements WebMvcConfigurer {

  private final JWTAuthService jwtAuthService;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new RequestLoggerInterceptor())
        .addPathPatterns(EndpointConstants.V1_ROOT_URI + "/*");
    registry.addInterceptor(new JwtAuthInterceptor(jwtAuthService))
        .addPathPatterns(EndpointConstants.V1_ROOT_URI + "/*");
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(MediaType.APPLICATION_JSON).ignoreAcceptHeader(false);
  }
}
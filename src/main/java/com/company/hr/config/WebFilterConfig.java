package com.company.hr.config;

import com.company.hr.constants.EndpointConstants;
import com.company.hr.filters.JwtAuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebFilterConfig implements WebMvcConfigurer {

  private final JwtAuthInterceptor jwtAuthInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(jwtAuthInterceptor).addPathPatterns(EndpointConstants.V1_ROOT_URI + "/*");
  }
}
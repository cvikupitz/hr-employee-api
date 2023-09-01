package com.company.hr.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimedAspectConfig {

  @Bean
  public TimedAspect registerTimedAspect(MeterRegistry registry) {
    return new TimedAspect(registry);
  }
}
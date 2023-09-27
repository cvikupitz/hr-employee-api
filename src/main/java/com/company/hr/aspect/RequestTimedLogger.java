package com.company.hr.aspect;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

import com.company.hr.constants.LoggerConstants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RequestTimedLogger {

  @Around("execution(* com.company.hr.controller..*(..)) || execution(* com.company.hr.service..*(..))")
  public Object logRequestTime(ProceedingJoinPoint joinPoint) throws Throwable {

    String packageName = joinPoint.getSignature().getDeclaringTypeName();
    String clazz = joinPoint.getSignature().getName();
    long startTime = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    long execTime = System.currentTimeMillis() - startTime;

    if (result.getClass().isAssignableFrom(ResponseEntity.class)) {
      ResponseEntity<?> response = (ResponseEntity<?>) result;
      log.info("{}.{}()", packageName, clazz,
          keyValue(LoggerConstants.JSON_HTTP_STATUS_KEY, response.getStatusCodeValue()),
          keyValue(LoggerConstants.JSON_EXEC_TIME_KEY, execTime));
    } else {
      log.info("{}.{}()", packageName, clazz,
          keyValue(LoggerConstants.JSON_EXEC_TIME_KEY, execTime));
    }

    return result;
  }
}
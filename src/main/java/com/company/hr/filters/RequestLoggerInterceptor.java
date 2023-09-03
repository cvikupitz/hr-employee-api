package com.company.hr.filters;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.constants.LoggerConstants;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class RequestLoggerInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {

    String httpMethod = request.getMethod();
    String uri = request.getRequestURI();
    String query = request.getQueryString();
    String requestId = StringEscapeUtils.escapeHtml4(
        request.getHeader(ApplicationConstants.HEADER_REQUEST_ID_KEY));
    if (StringUtils.isBlank(requestId)) {
      requestId = UUID.randomUUID().toString();
      log.debug("No request ID provided in header '{}', generating new request ID in place: {}",
          ApplicationConstants.HEADER_REQUEST_ID_KEY, request);
    }

    MDC.put(LoggerConstants.MDC_REQUEST_ID_KEY, requestId);
    MDC.put(LoggerConstants.MDC_HTTP_METHOD_KEY, httpMethod);
    MDC.put(LoggerConstants.MDC_URI_KEY, uri);
    MDC.put(LoggerConstants.MDC_QUERY_KEY, query);

    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, @Nullable Exception ex) {

    MDC.remove(LoggerConstants.MDC_REQUEST_ID_KEY);
    MDC.remove(LoggerConstants.MDC_HTTP_METHOD_KEY);
    MDC.remove(LoggerConstants.MDC_URI_KEY);
    MDC.remove(LoggerConstants.MDC_QUERY_KEY);
  }
}
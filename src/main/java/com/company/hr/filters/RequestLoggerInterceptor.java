package com.company.hr.filters;

import com.company.hr.constants.ApplicationConstants;
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

  public static final String MDC_REQUEST_ID_KEY = "requestId";
  public static final String MDC_HTTP_METHOD_KEY = "httpMethod";
  public static final String MDC_URI_KEY = "uri";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {

    String httpMethod = request.getMethod();
    String uri = request.getRequestURI();
    String query = StringUtils.isBlank(request.getQueryString()) ?
        StringUtils.EMPTY : "?" + request.getQueryString();
    String requestId = StringEscapeUtils.escapeHtml4(
        request.getHeader(ApplicationConstants.HEADER_REQUEST_ID_KEY));
    if (StringUtils.isBlank(requestId)) {
      requestId = UUID.randomUUID().toString();
      log.debug("No request ID provided in header '{}', generating new request ID in place: {}",
          ApplicationConstants.HEADER_REQUEST_ID_KEY, request);
    }

    MDC.put(MDC_REQUEST_ID_KEY, requestId);
    MDC.put(MDC_HTTP_METHOD_KEY, httpMethod);
    MDC.put(MDC_URI_KEY, uri + query);

    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, @Nullable Exception ex) {

    MDC.remove(MDC_REQUEST_ID_KEY);
    MDC.remove(MDC_HTTP_METHOD_KEY);
    MDC.remove(MDC_URI_KEY);
  }
}
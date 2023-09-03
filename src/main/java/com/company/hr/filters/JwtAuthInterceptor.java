package com.company.hr.filters;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.company.hr.annotations.JwtAuthenticated;
import com.company.hr.constants.ApplicationConstants;
import com.company.hr.constants.LoggerConstants;
import com.company.hr.enums.ClientRole;
import com.company.hr.exception.DeniedPermissionException;
import com.company.hr.jwt.JWTAuthService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthInterceptor implements HandlerInterceptor {

  private final JWTAuthService jwtAuthService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {

    if (HandlerMethod.class.isAssignableFrom(handler.getClass())) {
      authenticateJwtToken(request, (HandlerMethod) handler);
    }
    return true;
  }

  private void authenticateJwtToken(HttpServletRequest request, HandlerMethod handlerMethod) {

    JwtAuthenticated authAnnotation;
    if ((authAnnotation = handlerMethod.getMethodAnnotation(JwtAuthenticated.class)) == null) {
      return;
    }

    String jwtToken = request.getHeader(ApplicationConstants.HEADER_AUTHORIZATION_KEY);
    DecodedJWT decodedJWT = jwtAuthService.validate(jwtToken);
    Claim appName = decodedJWT.getClaim(JWTAuthService.APP_NAME_CLAIM);
    MDC.put(LoggerConstants.MDC_APP_NAME_KEY, appName.asString());
    Claim userRole = decodedJWT.getClaim(JWTAuthService.PERMISSION_LEVEL_CLAIM);
    ClientRole accessLevel = authAnnotation.value();

    if (userRole.asInt() < accessLevel.getLevel()) {
      throw new DeniedPermissionException(
          "The authenticated user does not have permission to access this resource.");
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, @Nullable Exception ex) {

    MDC.remove(LoggerConstants.MDC_APP_NAME_KEY);
  }
}
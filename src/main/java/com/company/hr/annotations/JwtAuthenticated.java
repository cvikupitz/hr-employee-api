package com.company.hr.annotations;

import com.company.hr.enums.PermissionLevel;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Annotation to put on REST controller methods that will use the JWT authentication filter. All
 * methods with this annotation will have all requests sent through the {@link
 * com.company.hr.filters.JwtAuthInterceptor} and have JWT authorization performed prior to
 * processing the request. The method annotated should be a standard REST controller method
 * annotated with any of Spring's method mapping methods.</p>
 *
 * <p>Example:</p>
 * <pre>{@code
 *   @JwtAuthenticated(ClientRole.READ_ONLY)
 *   public ResponseEntity<String> findBookById(@PathVariable Integer id) {
 *     ...
 *   }
 * }</pre>
 *
 * @author Cole Vikupitz
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtAuthenticated {

  /**
   * The minimum permission level required to access and use this endpoint. The JWT validated will
   * contain a custom claim with the user's permission level which is matched against this
   * requirement. Operation will be allowed only if the permission level in the JWT is greater than
   * or equal to this level.
   *
   * @return The minimum permission level needed to access this operation.
   */
  PermissionLevel value();
}
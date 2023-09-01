package com.company.hr.annotations;

import com.company.hr.enums.ClientRole;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtAuthenticated {

  ClientRole value() default ClientRole.READ_ONLY;
}
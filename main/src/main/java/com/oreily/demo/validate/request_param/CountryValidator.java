package com.oreily.demo.validate.request_param;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CountryConstraintValidator.class})
public @interface CountryValidator {
    String message() default "Invalid ISO Language";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

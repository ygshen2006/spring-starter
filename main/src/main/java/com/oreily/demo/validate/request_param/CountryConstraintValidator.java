package com.oreily.demo.validate.request_param;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.logging.log4j.util.Strings;

import java.util.*;

public class CountryConstraintValidator implements ConstraintValidator<CountryValidator, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isEmpty(value)) return false;
        String[] countries = Locale.getISOCountries();
        List<String> ps = List.of(countries);
        return ps.contains(value);
    }

    @Override
    public void initialize(CountryValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}

package com.oreily.demo.validate.startup;

import org.springframework.context.annotation.Condition;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AppConfigAnnotation {
    Class<? extends Condition>[] value();
}

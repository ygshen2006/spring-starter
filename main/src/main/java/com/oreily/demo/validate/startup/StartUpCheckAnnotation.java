package com.oreily.demo.validate.startup;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Conditional({AppCondition.class})
public @interface StartUpCheckAnnotation {
    String[] value() default {"appId","test.port"};
}

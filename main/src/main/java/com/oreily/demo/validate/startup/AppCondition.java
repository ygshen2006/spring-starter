package com.oreily.demo.validate.startup;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AppCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(StartUpCheckAnnotation.class.getName());
        if (attrs != null) {
            Iterator var4 = ((List) attrs.get("value")).iterator();

            Object[] value;
            do {
                if (!var4.hasNext()) {
                    break;
                }

                value = (Object[]) var4.next();
            } while (Arrays.stream(value).allMatch(c -> context.getEnvironment().containsProperty((String) c)));
            return true;
        } else {
            return true;
        }
    }
}

package com.oreily.spring.feature;

import com.oreily.spring.annotation.FeatureAnnotation;
import com.oreily.spring.filter.MyFilter;
import com.oreily.spring.model.ResourceMethodConfig;
import com.oreily.spring.provider.DefaultItemIdSourceProvider;
import com.oreily.spring.provider.SourceIdProvider;
import jakarta.inject.Named;
import jakarta.ws.rs.container.DynamicFeature;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.FeatureContext;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component("my-component-feature")
@Scope("prototype")
@AutoConfigureAfter(value = MyFilter.class)
public class MyTestDynamicFeature implements DynamicFeature {
    private MyFilter myFilter;

    private ResourceMethodConfig resourceMethodConfig;

    private Map<String, SourceIdProvider> classMethods;

    private DefaultItemIdSourceProvider defaultItemIdSourceProvider;

    public MyTestDynamicFeature(@Named("my-service-filter") final MyFilter myFilter,
                                ApplicationContext applicationContext,
                                DefaultItemIdSourceProvider defaultItemIdSourceProvider,
                                ResourceMethodConfig resourceMethodConfig) {
        this.myFilter = myFilter;
        this.resourceMethodConfig = resourceMethodConfig;
        this.defaultItemIdSourceProvider = defaultItemIdSourceProvider;
        this.classMethods = getClassMethods(applicationContext);
    }

    private Map<String, SourceIdProvider> getClassMethods(ApplicationContext applicationContext) {
        Map<String, SourceIdProvider> results = new HashMap<>();

        this.resourceMethodConfig.getResourceMethodConfigList().
                stream()
                .filter(c -> Objects.nonNull(c.getMethodName()))
                .forEach(c -> {
                    Object bean = applicationContext.getBean(c.getSourceIdProvider());
                    if (bean instanceof SourceIdProvider) {
                        results.putIfAbsent(c.getMethodName(), (SourceIdProvider) bean);
                    } else {
                        results.put(c.getMethodName(), defaultItemIdSourceProvider);
                    }
                });

        return results;
    }

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        Class<?> resourceClass = resourceInfo.getResourceClass();
        Method resourceMethod = resourceInfo.getResourceMethod();
        if (myFilter == null) return;
        if (Objects.isNull(resourceClass) || Objects.isNull(resourceMethod)) return;

        String fullyQualifiedMethodName = String.format("%s.%s", resourceClass.getName(), resourceMethod.getName());
        if (!this.classMethods.containsKey(fullyQualifiedMethodName))
            return;

        myFilter.setResourceMethodConfig(this.classMethods);
        featureContext.register(myFilter);
    }
}

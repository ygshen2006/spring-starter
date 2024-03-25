package com.oreily.spring.filter;


import com.oreily.spring.config.MySpringConfig;
import com.oreily.spring.context.DefaultContextCreator;
import com.oreily.spring.model.MySpringRequestParam;
import com.oreily.spring.provider.DefaultItemIdSourceProvider;
import com.oreily.spring.provider.SourceIdProvider;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.internal.routing.UriRoutingContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

@Component("my-service-filter")
@Scope(value = "singleton")
@ConditionalOnWebApplication
@Priority(Priorities.USER + 100)
@Provider
@Slf4j
public class MyFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Setter
    private Map<String, SourceIdProvider> resourceMethodConfig;

    private DefaultItemIdSourceProvider defaultItemIdSourceProvider;

    private DefaultContextCreator defaultContextCreator;

    public MyFilter(DefaultItemIdSourceProvider defaultItemIdSourceProvider,
                    DefaultContextCreator defaultContextCreator) {
        this.defaultItemIdSourceProvider = defaultItemIdSourceProvider;
        this.defaultContextCreator = defaultContextCreator;
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        MySpringConfig mySpringConfig = defaultContextCreator.create().getMySpringConfig();
        System.out.println(mySpringConfig);
        // Request filter
        MySpringRequestParam mySpringRequestParam = extractRequestParam(containerRequestContext);

        System.out.println(mySpringRequestParam);
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        // Response filter
        System.out.println(containerResponseContext);
    }

    private MySpringRequestParam extractRequestParam(ContainerRequestContext requestContext) {
        ContainerRequest context = (ContainerRequest) requestContext;
        UriRoutingContext uriRoutingContext = (UriRoutingContext) context.getUriInfo();
        Class<?> resourceClass = uriRoutingContext.getResourceClass();
        Method resourceMethod = uriRoutingContext.getResourceMethod();

        String resourceMethodFullyName = String.format("%s.%s", resourceClass.getName(), resourceMethod.getName());
        SourceIdProvider provider =
                Optional.ofNullable(this.resourceMethodConfig.get(resourceMethodFullyName)).orElse(defaultItemIdSourceProvider);

        Optional<String> itemId = provider.from(requestContext);

        MySpringRequestParam param = new MySpringRequestParam();
        param.setItemId(itemId.orElse("NO_ITEM_ID"));

        return param;
    }
}

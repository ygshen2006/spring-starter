package com.oreily.demo.api;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.container.DynamicFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
@ApplicationPath("/api/")
public class OreilyResourceConfig extends ResourceConfig {
    private final DynamicFeature myComponentFeature;

    public OreilyResourceConfig(@Named("my-component-feature") DynamicFeature myComponentFeature) {
        this.myComponentFeature = myComponentFeature;
    }

    @PostConstruct
    public void post() {
        register(OreilyResource.class);
        register(myComponentFeature);
    }
}

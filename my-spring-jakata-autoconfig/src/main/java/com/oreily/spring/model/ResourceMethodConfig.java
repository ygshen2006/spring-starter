package com.oreily.spring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "my.register")
@Configuration
@Getter
@Setter
public class ResourceMethodConfig {
    private List<Element> resourceMethodConfigList;

    @Data
    public static class Element {
        private String methodName;
        private String sourceIdProvider;
    }
}

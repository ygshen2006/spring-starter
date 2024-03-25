package com.oreily.spring;

import com.oreily.spring.config.DefaultJAXRSConfig;
import com.oreily.spring.config.JAXRSConfig;
import com.oreily.spring.config.MySpringConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "my-spring")
@PropertySource(value = "classpath:my-spring.properties", ignoreResourceNotFound = true)
public class MySpringProperties implements MySpringConfig {
    private String property;

    private DefaultJAXRSConfig jaxrs;

    @Override
    public JAXRSConfig getJAXRSConfig() {
        return jaxrs;
    }
}

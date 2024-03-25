package com.oreily.spring.config;

import com.oreily.spring.enums.EngineType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultJAXRSConfig implements JAXRSConfig{
    private boolean enabled;

    private EngineType engineType;

    private String jsonPath;
}
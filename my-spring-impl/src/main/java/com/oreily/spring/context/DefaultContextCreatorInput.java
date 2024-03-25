package com.oreily.spring.context;

import com.oreily.spring.config.JAXRSConfig;
import com.oreily.spring.config.MySpringConfig;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DefaultContextCreatorInput implements ContextCreatorInput{

    public MySpringConfig mySpringConfig;

    public JAXRSConfig getConfig() {
        return mySpringConfig.getJAXRSConfig();
    }
}

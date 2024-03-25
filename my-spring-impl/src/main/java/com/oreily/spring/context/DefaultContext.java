package com.oreily.spring.context;

import com.oreily.spring.config.MySpringConfig;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DefaultContext implements Context{
    MySpringConfig config;

    @Override
    public MySpringConfig getMySpringConfig() {
        return config;
    }
}
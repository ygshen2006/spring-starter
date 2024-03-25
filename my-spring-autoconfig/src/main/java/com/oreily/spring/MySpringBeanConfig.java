package com.oreily.spring;

import com.oreily.spring.context.DefaultContextCreator;
import com.oreily.spring.context.DefaultContextCreatorInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySpringBeanConfig {
    private MySpringProperties mySpringProperties;

    @Autowired(required = false)
    public void setMySpringProperties(MySpringProperties mySpringProperties) {
        this.mySpringProperties = mySpringProperties;
    }
    @Bean
    public DefaultContextCreator defaultContextCreator(){
        return new DefaultContextCreator(DefaultContextCreatorInput
                .builder()
                .mySpringConfig(mySpringProperties)
                .build());
    }
}

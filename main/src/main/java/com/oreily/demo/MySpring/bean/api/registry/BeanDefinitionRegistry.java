package com.oreily.demo.MySpring.bean.api.registry;

import com.oreily.demo.MySpring.bean.api.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}

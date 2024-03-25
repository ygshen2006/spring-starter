package com.oreily.demo.MySpring.bean.impl;

import com.oreily.demo.MySpring.bean.api.factory.AutowiredAbstractBeanFactory;
import com.oreily.demo.MySpring.bean.api.BeanDefinition;
import com.oreily.demo.MySpring.bean.api.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory
        extends AutowiredAbstractBeanFactory
        implements BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> map = new HashMap<String, BeanDefinition>();

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        map.putIfAbsent(name, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return map.get(name);
    }
}

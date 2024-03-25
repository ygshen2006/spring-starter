package com.oreily.demo.MySpring.bean.impl;

import com.oreily.demo.MySpring.bean.api.BeanDefinition;
import com.oreily.demo.MySpring.bean.api.instantiation.InstantiationStrategy;

import java.lang.reflect.Constructor;

public class CglibInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiationBean(String beanName, BeanDefinition beanDefinition, Constructor<?> constructor, Object[] args) {
        return null;
    }
}

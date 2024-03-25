package com.oreily.demo.MySpring.bean.api.instantiation;

import com.oreily.demo.MySpring.bean.api.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiationBean(String beanName, BeanDefinition beanDefinition, Constructor<?> constructor, Object[] args);
}

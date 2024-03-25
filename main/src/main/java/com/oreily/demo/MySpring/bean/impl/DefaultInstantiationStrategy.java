package com.oreily.demo.MySpring.bean.impl;

import com.oreily.demo.MySpring.bean.api.BeanDefinition;
import com.oreily.demo.MySpring.bean.api.instantiation.InstantiationStrategy;

import java.lang.reflect.Constructor;

public class DefaultInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiationBean(String beanName, BeanDefinition beanDefinition, Constructor<?> constructor, Object[] args) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            if (constructor != null) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
            return beanClass.getDeclaredConstructor(null).newInstance();
        } catch (Exception ex) {
            // do nothing
        }
        return null;
    }
}

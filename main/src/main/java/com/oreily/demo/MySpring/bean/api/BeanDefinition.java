package com.oreily.demo.MySpring.bean.api;

import com.oreily.demo.MySpring.bean.api.beanRef.PropertyValues;

public class BeanDefinition {
    private Class<?> bean;

    private PropertyValues properties;

    public BeanDefinition(Class<?> bean, PropertyValues properties) {
        this.bean = bean;
        this.properties = properties != null ? properties : new PropertyValues();
    }

    public BeanDefinition(Class<?> bean) {
        this.bean = bean;
        this.properties = new PropertyValues();
    }

    public PropertyValues getProperties() {
        return properties;
    }

    public Class<?> getBeanClass() {
        return bean;
    }
}

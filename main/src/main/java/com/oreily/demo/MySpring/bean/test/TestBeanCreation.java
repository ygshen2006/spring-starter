package com.oreily.demo.MySpring.bean.test;

import com.oreily.demo.MySpring.bean.api.BeanDefinition;
import com.oreily.demo.MySpring.bean.api.beanRef.PropertyValues;
import com.oreily.demo.MySpring.bean.impl.DefaultListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;

public class TestBeanCreation {
    public static void main(String[] args) {
        BeanDefinition userDaoBeanDefinition = new BeanDefinition(UserDao.class);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userDao", userDaoBeanDefinition);


        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addProperty("name", "John");
        propertyValues.addProperty("userDao", new RuntimeBeanReference("userDao"));
        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", userServiceBeanDefinition);


        Object bean = beanFactory.getBean("userService");
        UserService u = (UserService) bean;
        System.out.println(u);
    }
}

package com.oreily.demo.MySpring.bean.api.factory;

import cn.hutool.core.bean.BeanUtil;
import com.oreily.demo.MySpring.bean.api.BeanDefinition;
import com.oreily.demo.MySpring.bean.api.beanRef.PropertyValue;
import com.oreily.demo.MySpring.bean.api.instantiation.InstantiationStrategy;
import com.oreily.demo.MySpring.bean.impl.DefaultInstantiationStrategy;
import org.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.util.List;

public abstract class AutowiredAbstractBeanFactory extends AbstractBeanFactory {
    private final InstantiationStrategy instantiationStrategy = new DefaultInstantiationStrategy();

    @Override
    public Object createBean(BeanDefinition beanDefinition, String name, Object... args) throws Exception {
        Class<?> clazz = beanDefinition.getBeanClass();
        Object result = null;
        if (args == null || args.length == 0) {
            result = createBeanMethod(beanDefinition, name, null, args);
        } else {
            for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
                if (declaredConstructor.getParameterTypes().length == args.length) {
                    result = createBeanMethod(beanDefinition, name, declaredConstructor, args);
                }
            }
        }
        applyBeanProperties(beanDefinition, result);
        return result;
    }

    private Object createBeanMethod(BeanDefinition beanDefinition, String name, Constructor<?> constructor, Object... args) {
        return instantiationStrategy.instantiationBean(name, beanDefinition, constructor, args);
    }

    private void applyBeanProperties(BeanDefinition beanDefinition, Object bean) {
        List<PropertyValue> properties = beanDefinition.getProperties().getProperties();
        for (PropertyValue property : properties) {
            Object propertyValue = property.getPropertyValue();
            if (propertyValue instanceof BeanReference) {
                String beanName = ((BeanReference) propertyValue).getBeanName();
                propertyValue = getBean(beanName);
            }
            BeanUtil.setFieldValue(bean, property.getPropertyKey(), propertyValue);
        }
    }
}

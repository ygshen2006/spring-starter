package com.oreily.demo.MySpring.bean.api.factory;

import com.oreily.demo.MySpring.bean.api.BeanDefinition;
import com.oreily.demo.MySpring.bean.impl.DefaultSingletonBeanRegistry;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
        implements BeanFactory {
    @Override
    public Object getBean(String name) {
        return getBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return getBeanMethod(name, args);
    }

    private Object getBeanMethod(String name, Object... args) {
        Object result;
        Object bean = getSingleton(name);
        if (bean != null) return bean;


        BeanDefinition beanDefinition = getBeanDefinition(name);
        if (beanDefinition != null) {
            try {
                result = createBean(beanDefinition, name, args);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            registerSingleton(name, result);

            return result;
        }

        return null;
    }

    public abstract BeanDefinition getBeanDefinition(String name);

    public abstract Object createBean(BeanDefinition beanDefinition, String name, Object... args) throws Exception;
}

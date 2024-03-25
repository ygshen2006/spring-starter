package com.oreily.demo.MySpring.bean.api.factory;

import java.lang.reflect.InvocationTargetException;

public interface BeanFactory {
    Object getBean(String name);

    Object getBean(String name, Object... args);
}

package com.oreily.demo.MySpring.bean.api.registry;

public interface SingletonBeanRegistry {
    Object getSingleton(String name);

    void registerSingleton(String name, Object bean);
}

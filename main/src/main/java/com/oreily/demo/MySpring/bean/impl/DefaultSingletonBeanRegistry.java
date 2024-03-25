package com.oreily.demo.MySpring.bean.impl;

import com.oreily.demo.MySpring.bean.api.registry.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singles = new HashMap<String, Object>();

    @Override
    public Object getSingleton(String name) {
        return singles.get(name);
    }

    @Override
    public void registerSingleton(String name, Object bean) {
        singles.putIfAbsent(name, bean);
    }
}

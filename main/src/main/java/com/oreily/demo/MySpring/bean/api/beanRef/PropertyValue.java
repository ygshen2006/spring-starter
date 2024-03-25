package com.oreily.demo.MySpring.bean.api.beanRef;

public class PropertyValue {
    private final String propertyKey;
    private final Object propertyValue;

    public PropertyValue(String propertyKey, Object propertyValue) {
        this.propertyKey = propertyKey;
        this.propertyValue = propertyValue;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }
}

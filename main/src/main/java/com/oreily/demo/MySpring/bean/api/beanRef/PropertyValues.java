package com.oreily.demo.MySpring.bean.api.beanRef;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
    private final List<PropertyValue> properties = new ArrayList<>();


    public void addProperty(String key, Object value) {
        PropertyValue propertyValue = new PropertyValue(key, value);
        properties.add(propertyValue);
    }

    public List<PropertyValue> getProperties() {
        return properties;
    }

    public PropertyValue getProperty(String keyName) {
        return properties.stream().filter(v -> v.getPropertyKey().equals(keyName)).toList().get(0);
    }
}

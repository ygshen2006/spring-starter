package com.oreily.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import java.io.IOException;

public class ObjectJsonParser {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper().registerModule(new AfterburnerModule());
    }

    public static <T> T parse(String jsonValue, Class<T> t) {
        try {
            return mapper.readValue(jsonValue, t);
        } catch (IOException e) {
            return null;
        }
    }
}

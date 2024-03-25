package com.oreily.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

public class ObjectJsonWriter {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper().
                registerModule(new AfterburnerModule()).
                setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL).
                setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY);
    }

    public static String write(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}

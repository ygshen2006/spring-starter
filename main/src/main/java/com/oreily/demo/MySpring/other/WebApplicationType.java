package com.oreily.demo.MySpring.other;

import org.springframework.util.ClassUtils;

public enum WebApplicationType {
    NONE,
    SERVLET,
    REACTIVE;

    // * This servlet classes is required if not Reactive application
    private static final String[] SERVLET_INDICATOR_CLASSES = {"jakarta.servlet.Servlet",
            "org.springframework.web.context.ConfigurableWebApplicationContext" };

    // Use Following indicators to check if App is a `Servlet`(WEBMVC_INDICATOR_CLASS or JERSEY_INDICATOR_CLASS) or `Reactive`
    private static final String WEBMVC_INDICATOR_CLASS = "org.springframework.web.servlet.DispatcherServlet";

    private static final String WEBFLUX_INDICATOR_CLASS = "org.springframework.web.reactive.DispatcherHandler";

    private static final String JERSEY_INDICATOR_CLASS = "org.glassfish.jersey.servlet.ServletContainer";

    // 1. Use classloader to load all the classes
    // 2. Has class: org.springframework.web.reactive.DispatcherHandler
    //    Not has class:   org.springframework.web.reactive.DispatcherHandler, org.glassfish.jersey.servlet.ServletContainer
    // Then it is a reactive, otherwise it is SERVLET

    static WebApplicationType deduceFromClasspath(){
        if(ClassUtils.isPresent(WEBFLUX_INDICATOR_CLASS, null) && !ClassUtils.isPresent(WEBMVC_INDICATOR_CLASS, null)
            && !ClassUtils.isPresent(JERSEY_INDICATOR_CLASS, null)){
            return REACTIVE;
        }

        for (String clazz : SERVLET_INDICATOR_CLASSES) {
            if(!ClassUtils.isPresent(clazz, null)){
                return NONE;
            }
        }
        return SERVLET;
    }
}

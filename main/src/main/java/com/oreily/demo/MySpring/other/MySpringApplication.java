package com.oreily.demo.MySpring.other;

import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class MySpringApplication {
    private ResourceLoader resourceLoader;
    private final Set<Class<?>> primarySources;


    // 1: Start the app
    public static void run(Class<?> primarySource, String... args) {
        run(new Class<?>[]{primarySource}, args);
    }

    // 2: Create app and run app
    public static void run(Class<?>[] primarySources, String[] args) {
        new MySpringApplication(primarySources).run();
    }



    // 3. Initialize app
    public MySpringApplication(Class<?>... primarySources){
        this(null, primarySources);
    }
    public MySpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources){
        this.resourceLoader = resourceLoader;
        Assert.notNull(primarySources, "PrimarySources must not be null");
        this.primarySources = new LinkedHashSet<Class<?>>(Arrays.asList(primarySources));

        WebApplicationType webApplicationType = WebApplicationType.deduceFromClasspath();
    }

    public void run(){

    }
}


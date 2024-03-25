package com.oreily.spring.context;

public interface ContextCreator {
    Context create();

    ContextCreatorInput getInput();
}

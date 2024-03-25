package com.oreily.spring.context;

public class DefaultContextCreator implements ContextCreator {
    private DefaultContextCreatorInput defaultContextCreatorInput;

    public DefaultContextCreator(DefaultContextCreatorInput defaultContextCreatorInput) {
        this.defaultContextCreatorInput = defaultContextCreatorInput;
    }

    @Override
    public Context create() {
        return DefaultContext.builder().config(defaultContextCreatorInput.mySpringConfig).build();
    }

    @Override
    public ContextCreatorInput getInput() {
        return defaultContextCreatorInput;
    }
}

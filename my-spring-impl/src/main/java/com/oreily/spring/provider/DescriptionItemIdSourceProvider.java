package com.oreily.spring.provider;

import jakarta.ws.rs.container.ContainerRequestContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.oreily.spring.constants.Constants.ITEM_DESC;

@Component
public class DescriptionItemIdSourceProvider implements SourceIdProvider {
    @Override
    public Optional<String> from(ContainerRequestContext requestContext) {
        return SourceIdProvider.super.from(requestContext).
                map(sourceId -> String.format(ITEM_DESC + "_%s", sourceId));
    }
}

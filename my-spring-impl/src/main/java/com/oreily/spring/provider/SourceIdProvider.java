package com.oreily.spring.provider;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.UriInfo;

import java.util.Optional;

import static com.oreily.spring.constants.Constants.ITEM_ID;

public interface SourceIdProvider {
    default Optional<String> from(ContainerRequestContext requestContext) {
        return Optional.ofNullable(requestContext.getUriInfo())
                .map(UriInfo::getQueryParameters)
                .map(param -> param.getFirst(ITEM_ID));
    }
}

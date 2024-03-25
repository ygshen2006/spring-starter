package com.oreily.demo.api;

import com.oreily.demo.model.Person;
import com.oreily.demo.validate.request_param.CountryValidator;
import jakarta.ws.rs.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/v1")
public class OreilyResource {
    @GET
    @Path("/person/{country}/{personName}")
    public String testGet(
            @RequestParam
            String itemId,
            @CountryValidator
            @PathParam(value = "country")
            String country
    ) {
        return country;
    }

    @GET
    @Path("/not-existed")
    public String testNotExistedPath() {
        // Filter will not be triggered, coz we have not added the method to app.properties
        return "team";
    }

    @POST
    @Path("/person/save")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Person savePerson(@RequestBody Person person){

        return person;
    }
}

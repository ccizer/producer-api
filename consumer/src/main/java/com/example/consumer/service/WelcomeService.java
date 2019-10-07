package com.example.consumer.service;

import com.example.consumer.model.Person;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/welcome")
public class WelcomeService {

    private final RetrievePersonService retrievePersonService;

    public WelcomeService(RetrievePersonService retrievePersonService) {
        this.retrievePersonService = retrievePersonService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response welcome() {
        Person person = retrievePersonService.retrieve();
        return Response.ok()
                .entity(person)
                .build();
    }
}

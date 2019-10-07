package com.ccizer.producer.service;

import com.ccizer.producer.model.Person;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/hello")
public class HelloService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok()
                .entity(new Person("Can", "Cizer"))
                .build();
    }
}

package fr.photonsquid.houseportal.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aa")
public class Home {
    @GET
    @Produces("application/json")
    public Response doGet() {
        return Response.ok("{\"coucou\": \"yess\"}", MediaType.APPLICATION_JSON).build();
    }
}

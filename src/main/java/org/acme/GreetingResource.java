package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {
    @ConfigProperty(name = "whoami", defaultValue = "greeting resource")
    String config;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("config")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig() {
        return "Hello from "+config;
    }
}

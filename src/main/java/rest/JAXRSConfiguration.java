package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//everything under "api" is a jax-rs endpoint
@ApplicationPath("api")
public class JAXRSConfiguration extends Application {
}

package ma.emsi.cherqui.tp3_de_cherqui;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/personnes/{nom}")
public class HelloResource {

    @GET
    @Produces("text/plain")
    public String hello(@PathParam("nom")  String nom) {
        return "Hello, "+nom+" !";
    }
}
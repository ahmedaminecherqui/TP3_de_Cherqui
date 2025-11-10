package ma.emsi.cherqui.tp3_de_cherqui;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/personnes/{nom}")
public class HelloResource {

    @GET
    @Produces("text/plain")
    public jakarta.ws.rs.core.Response hello(@PathParam("nom")  String nom) {
        return Response.ok("Hello, " + nom).build();
    }
}
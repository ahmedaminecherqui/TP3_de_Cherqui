package ma.emsi.cherqui.tp3_de_cherqui;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/lieu/{ville_pays}")
public class GuideTouristiqueResource {

    @GET
    @Produces("text/plain")
    public String hello(@PathParam("ville_pays") String ville_pays) {
        return "ville/pays choisi :  " + ville_pays;
    }
}

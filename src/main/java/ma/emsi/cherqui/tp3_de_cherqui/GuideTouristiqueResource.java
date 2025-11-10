package ma.emsi.cherqui.tp3_de_cherqui;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/guide")
public class GuideTouristiqueResource {

    @GET
    @Path("/lieu/{ville_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> hello(@PathParam("ville_pays") String lieu) {
        List<String> lieux = new ArrayList<>();

        lieux.add("Lieu touristique 1 pour " + lieu);
        lieux.add("Lieu touristique 2 pour " + lieu);

        return lieux;
    }
}

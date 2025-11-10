package ma.emsi.cherqui.tp3_de_cherqui.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.cherqui.tp3_de_cherqui.llm.LlmClient;
import ma.emsi.cherqui.tp3_de_cherqui.model.GuideResponse;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    @GET
    @Path("/lieu/{ville_pays}/{nbr_lieu}")
    @Produces(MediaType.APPLICATION_JSON)
    public GuideResponse askGuide(@PathParam("ville_pays") String lieu,@PathParam("nbr_lieu")  String nbr_lieu) {
        return llmClient.poserQuestion(lieu,nbr_lieu);
    }
}

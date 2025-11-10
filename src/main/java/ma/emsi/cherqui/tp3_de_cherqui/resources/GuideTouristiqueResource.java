package ma.emsi.cherqui.tp3_de_cherqui.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.cherqui.tp3_de_cherqui.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    @GET
    @Path("/lieu/{ville_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String askGuide(@PathParam("ville_pays") String lieu) {
        return llmClient.poserQuestion(lieu);
    }
}

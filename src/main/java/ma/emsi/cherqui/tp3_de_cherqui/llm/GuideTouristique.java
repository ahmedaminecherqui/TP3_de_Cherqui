package ma.emsi.cherqui.tp3_de_cherqui.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import ma.emsi.cherqui.tp3_de_cherqui.model.GuideResponse;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique. 
        Pour chaque ville ou pays fourni, tu dois indiquer exactement :
        - les principaux endroits à visiter(qui est un nombre defini par l'utilsateur et passé avec le nom de la ville/pays,
        - le prix moyen d'un repas dans la devise locale.
        Réponds strictement au format JSON correspondant au record GuideResponse.
        """)
    GuideResponse ask(@UserMessage String lieu, @V("nbr") String nbr_lieu);
}


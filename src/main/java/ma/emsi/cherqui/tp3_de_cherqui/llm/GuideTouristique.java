package ma.emsi.cherqui.tp3_de_cherqui.llm;

import dev.langchain4j.service.SystemMessage;
import ma.emsi.cherqui.tp3_de_cherqui.model.GuideResponse;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique. 
        Pour chaque ville ou pays fourni, tu dois indiquer exactement :
        - les 2 principaux endroits à visiter,
        - le prix moyen d'un repas dans la devise locale.
        Réponds strictement au format JSON correspondant au record GuideResponse.
        """)
    GuideResponse ask(String lieu);
}


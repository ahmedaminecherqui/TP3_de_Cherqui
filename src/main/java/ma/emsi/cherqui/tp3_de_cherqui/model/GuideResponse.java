package ma.emsi.cherqui.tp3_de_cherqui.model;

import java.util.List;

public record GuideResponse(
        String ville_ou_pays,
        List<String> endroits_a_visiter,
        String prix_moyen_repas
) {}


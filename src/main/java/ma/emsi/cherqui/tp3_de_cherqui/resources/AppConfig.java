package ma.emsi.cherqui.tp3_de_cherqui.resources;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")   // <-- VERY IMPORTANT
public class AppConfig extends Application {
}


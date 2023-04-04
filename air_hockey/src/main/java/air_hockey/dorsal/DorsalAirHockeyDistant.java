package air_hockey.dorsal;

import air_hockey.commun.Declarations;
import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;

public class DorsalAirHockeyDistant extends RemoteBackendNtro {

    @Override
    public void registerServer(ServerRegistrar registrar) {
        Declarations.declarerServeur(registrar);
    }



}
package pong.dorsal;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;
import pong.commun.Declarations;

public class DorsalPongDistant extends RemoteBackendNtro {

    @Override
    public void registerServer(ServerRegistrar registrar) {
        Declarations.declarerServeur(registrar);
    }

    
    
}
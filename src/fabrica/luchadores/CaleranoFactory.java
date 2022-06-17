package fabrica.luchadores;

import estrategia.Component;
import estrategia.habilidad.Elastico;
import estrategia.luchador.Calerano;
import fabrica.Factory;

public class CaleranoFactory implements Factory{

    @Override
    public Component createComponent() {
        return new Calerano(new Elastico());
    }

    @Override
    public String getType() { return Calerano.TIPO; }
    
}

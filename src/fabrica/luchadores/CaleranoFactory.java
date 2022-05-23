package fabrica.luchadores;

import estrategia.habilidad.Elastico;
import estrategia.luchador.Calerano;
import estrategia.luchador.decorador.Component;
import fabrica.Factory;

public class CaleranoFactory extends Factory{

    @Override
    public Component createComponent() {
        return new Calerano(new Elastico());
    }

    @Override
    public String getType() { return Calerano.TIPO; }
    
}

package fabrica.habilidades;

import estrategia.Component;
import estrategia.habilidad.Fuerza;
import fabrica.Factory;

public class FuerzaFactory implements Factory{

    @Override
    public Component createComponent() {
        return new Fuerza();
    }

    @Override
    public String getType() {
        return Fuerza.TIPO;
    }
    
}

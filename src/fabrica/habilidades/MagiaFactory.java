package fabrica.habilidades;

import estrategia.Component;
import estrategia.habilidad.Magia;
import fabrica.Factory;

public class MagiaFactory implements Factory{

    @Override
    public Component createComponent() {
        return new Magia();
    }

    @Override
    public String getType() {
        return Magia.TIPO;
    }
    
}

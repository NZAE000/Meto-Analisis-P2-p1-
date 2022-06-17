package fabrica.habilidades;

import estrategia.Component;
import estrategia.habilidad.Normal;
import fabrica.Factory;

public class NormalFactory implements Factory{

    @Override
    public Component createComponent() {
        return new Normal();
    }

    @Override
    public String getType() {
        return Normal.TIPO;
    }
    
}

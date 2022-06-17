package fabrica.habilidades;

import estrategia.Component;
import estrategia.habilidad.Elastico;
import fabrica.Factory;

public class ElasticoFactory implements Factory{

    @Override
    public Component createComponent() {
        return new Elastico();
    }

    @Override
    public String getType() {
        return Elastico.TIPO;
    }
    
}

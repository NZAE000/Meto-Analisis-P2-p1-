package fabrica.luchadores;

import estrategia.Component;
import estrategia.habilidad.Fuerza;
import estrategia.luchador.ChoroPortenho;
import fabrica.Factory;

public class ChoroFactory extends Factory{

    @Override
    public Component createComponent() {
        return new ChoroPortenho(new Fuerza());
    }

    @Override
    public String getType() { return ChoroPortenho.TIPO; }
    
}

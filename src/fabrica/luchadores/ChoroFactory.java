package fabrica.luchadores;

import estrategia.habilidad.Fuerza;
import estrategia.luchador.ChoroPortenho;
import estrategia.luchador.decorador.Component;
import fabrica.Factory;

public class ChoroFactory extends Factory{

    @Override
    public Component createComponent() {
        return new ChoroPortenho(new Fuerza());
    }

    @Override
    public String getType() { return ChoroPortenho.TIPO; }
    
}

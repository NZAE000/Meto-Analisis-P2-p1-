package fabrica.luchadores;

import estrategia.Component;
import estrategia.habilidad.Magia;
import estrategia.luchador.MineroWarrior;
import fabrica.Factory;

public class MineroFactory extends Factory{

    @Override
    public Component createComponent() {
        return new MineroWarrior(new Magia());
    }

    @Override
    public String getType() { return MineroWarrior.TIPO; }
    
}

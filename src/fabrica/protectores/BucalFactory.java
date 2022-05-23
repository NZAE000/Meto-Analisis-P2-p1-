package fabrica.protectores;

import estrategia.luchador.decorador.Bucal;
import estrategia.luchador.decorador.Component;
import fabrica.Factory;

public class BucalFactory extends Factory{

    @Override
    public Component createComponent() {
        return new Bucal(null);
    }

    @Override
    public String getType() { return Bucal.TIPO; }

}
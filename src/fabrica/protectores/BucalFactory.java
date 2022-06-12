package fabrica.protectores;

import estrategia.Component;
import estrategia.luchador.decorador.Bucal;
import fabrica.Factory;

public class BucalFactory extends Factory{

    @Override
    public Component createComponent() {
        return new Bucal(null);
    }

    @Override
    public String getType() { return Bucal.TIPO; }

}
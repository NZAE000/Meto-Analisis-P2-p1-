package fabrica.protectores;

import estrategia.Component;
import estrategia.luchador.decorador.Armour;
import fabrica.Factory;

public class ArmourFactory extends Factory{

    @Override
    public Component createComponent() {
        return new Armour(null);
    }

    @Override
    public String getType() { return Armour.TIPO; }
    
}

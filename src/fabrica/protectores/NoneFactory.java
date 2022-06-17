package fabrica.protectores;

import estrategia.Component;
import estrategia.luchador.decorador.None;
import fabrica.Factory;

public class NoneFactory implements Factory{

    @Override
    public Component createComponent() {
        return new None(null);
    }

    @Override
    public String getType() { return None.TIPO; }

}

package fabrica;

import estrategia.luchador.decorador.Component;

public abstract class Factory {
    abstract public Component createComponent();
    abstract public String getType();
}
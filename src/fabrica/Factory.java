package fabrica;

import estrategia.Component;

public abstract class Factory {
    abstract public Component createComponent();
    abstract public String getType();
}
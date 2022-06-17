package fabrica;

import estrategia.Component;

public interface Factory {
    public Component createComponent();
    public String getType();
}
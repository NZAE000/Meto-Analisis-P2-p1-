package fabrica.luchadores;

import estrategia.habilidad.*;
import estrategia.luchador.*;
import estrategia.luchador.decorador.Component;
import fabrica.Factory;

public class AleatoryFghtFtry extends Factory{

    @Override
    public Component createComponent() {
        float numRandom = (float) Math.random();
        if (numRandom <= .25) return new MineroWarrior(new Magia());
        else if (numRandom > .25 && numRandom <=.5) return new ChoroPortenho(new Normal());
        else return new Calerano(new Elastico());
    }
    @Override
    public String getType() { return "Aleatorio"; }
    
}

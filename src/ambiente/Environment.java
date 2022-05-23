package ambiente;

import jugador.*;
import man.FightManager;

public abstract class Environment {

    public FightManager my_man = null;
    abstract public void start(Player player1, Player player2) throws Exception;
}
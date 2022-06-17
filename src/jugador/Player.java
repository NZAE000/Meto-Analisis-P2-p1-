package jugador;

import estrategia.Component;

public abstract class Player {
    private String namePlayer = null;
    private Component luchador = null; 
    private short points;

    public Player(String name, Component luch_elegido){ 
        this.namePlayer = name;
        this.luchador = luch_elegido;
        this.points = 0;
    }

    public String getName()  { return namePlayer;  }
    public short getPoints() { return this.points; }
    public void addPoint()   { this.points += 1;   }
    public Component getFighter()                   { return this.luchador.getRootCmpt(); }
    public Component getFighterProtected()          { return this.luchador; }
    public void setFighter(Component luch_elegido)  { this.luchador = luch_elegido; }
    public void resetFighter()                      { this.luchador = null; }
    //public void resetPoints()               { this.points = 0;    }

    abstract public short selectFighter();
    abstract public short selectProtector();
    abstract public short selectHabilidad();
    abstract public short selectAction();
}
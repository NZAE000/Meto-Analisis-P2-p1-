package jugador;

import java.util.Scanner;
import estrategia.luchador.Luchador;

public class User extends Player{

    public User(String name, Luchador luch_elegido){
        super(name, luch_elegido);
    }

    @Override
    public short selectFighter() 
    {
        short id = (short) Integer.parseInt(new Scanner(System.in).nextLine());
        return id;
    }
    @Override
    public short selectHabilidad()  { return selectFighter(); }
    @Override
    public short selectAction()     { return selectHabilidad(); }

    @Override
    public short selectProtector()  { return selectAction(); }

    
}

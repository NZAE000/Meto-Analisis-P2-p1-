package jugador;

import java.util.Random;
import estrategia.luchador.Luchador;
import man.FightManager;

public class Cpu extends Player{

    public Cpu(String name, Luchador luch_elegido){
        super(name, luch_elegido);
    }

    @Override
    public short selectFighter() {
        int min_val = 1;
        int max_val = FightManager.N_FTRY;
        Random ran = new Random();
        int numF = ran.nextInt(max_val) + min_val;
        return (short) numF;
    }
    @Override
    public short selectHabilidad() {
        int min_val = 1;
        int max_val = FightManager.N_ABLTS;
        Random ran = new Random();
        int numH = ran.nextInt(max_val) + min_val;
        return (short) numH;  
    }
    @Override
    public short selectAction() {
        int min_val = 1;
        int max_val = ((Luchador) this.getFighter()).getMapActions().size();
        Random ran = new Random();
        int numA = ran.nextInt(max_val) + min_val;
        return (short) numA;
    }

    @Override
    public short selectProtector() {
        int min_val = 1;
        int max_val = FightManager.N_PTCTS+1;
        Random ran = new Random();
        int numP = ran.nextInt(max_val) + min_val;
        return (short) numP;
    }
    
}

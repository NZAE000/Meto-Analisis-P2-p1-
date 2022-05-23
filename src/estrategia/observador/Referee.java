package estrategia.observador;

import ambiente.FightEnvironment;
import estrategia.luchador.Luchador;

public class Referee {
    private static final String EMPATE = null;
    private FightEnvironment FighEnv = null;

    public Referee(FightEnvironment env){
        this.FighEnv = env;
    }
    
    public String seeWinnerRound()
    {   //GANADOR DE RONDA AQUEL PELEADOR CON MAS VIDA
        if (((Luchador) this.FighEnv.getPossibleWinner1().getFighter()).getSalud() >
        ((Luchador) this.FighEnv.getPossibleWinner2().getFighter()).getSalud()){
            this.FighEnv.getPossibleWinner1().addPoint();
            return this.FighEnv.getPossibleWinner1().getName(); 
        }
        this.FighEnv.getPossibleWinner2().addPoint();
        return this.FighEnv.getPossibleWinner2().getName();
    }
    
    public String seeWinnerFight()
    {   //GANADOR DE PELEA AQUEL QUE TUVO MAS PUNTOS
        if (this.FighEnv.getPossibleWinner1().getPoints() >
        this.FighEnv.getPossibleWinner2().getPoints())
            return this.FighEnv.getPossibleWinner1().getName();

        if (this.FighEnv.getPossibleWinner2().getPoints() >
        this.FighEnv.getPossibleWinner1().getPoints())
            return this.FighEnv.getPossibleWinner2().getName();

        return EMPATE; //PUEDE QUE ESTEN EMPATADOS
    }
}

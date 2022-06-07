package estrategia.observador;

import ambiente.FightEnvironment;
import estrategia.luchador.Luchador;

public class Referee {
    private static final String EMPATE = null;
    private FightEnvironment FightEnv = null;

    public Referee(FightEnvironment env){
        this.FightEnv = env;
    }
    
    public String seeWinnerRound()
    {   //GANADOR DE RONDA AQUEL PELEADOR CON MAS VIDA
        if (player1_isWinnerRound())
            return this.FightEnv.getPossibleWinner1().getName();
            
        return player2_winnerRound();
    }

    private boolean player1_isWinnerRound()
    {
        if (((Luchador) this.FightEnv.getPossibleWinner1().getFighter()).getSalud() >
        ((Luchador) this.FightEnv.getPossibleWinner2().getFighter()).getSalud()){
            this.FightEnv.getPossibleWinner1().addPoint();
            return true;
        } return false;
    }
    private String player2_winnerRound(){
        this.FightEnv.getPossibleWinner2().addPoint();
        return this.FightEnv.getPossibleWinner2().getName();
    }
    
    public String seeWinnerFight()
    {   //GANADOR DE PELEA AQUEL QUE TUVO MAS PUNTOS
        if (player1_isWinnerFight())
            return this.FightEnv.getPossibleWinner1().getName();

        if (player2_isWinnerFight())
            return this.FightEnv.getPossibleWinner2().getName();

        return EMPATE; //PUEDE QUE ESTEN EMPATADOS
    }

    private boolean player1_isWinnerFight()
    {
        if (this.FightEnv.getPossibleWinner1().getPoints() >
        this.FightEnv.getPossibleWinner2().getPoints())
            return true;
        return false;
    }
    
    private boolean player2_isWinnerFight()
    {
        if (this.FightEnv.getPossibleWinner2().getPoints() >
        this.FightEnv.getPossibleWinner1().getPoints())
            return true;
        return false;
    } 
}

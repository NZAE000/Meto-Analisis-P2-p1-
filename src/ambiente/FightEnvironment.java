package ambiente;

import java.util.Vector;

import estrategia.luchador.Luchador;
import estrategia.observador.Referee;
import jugador.Player;

public class FightEnvironment extends Environment{
	private static final short N_ROUND = 3;
	private Referee m_referee = null;
	private Player winnerPossible1 = null;
	private Player winnerPossible2 = null;
	private Vector<RoundEnvironment> rounds = null;

    public FightEnvironment() {
		super();
		initiRounds();
		this.m_referee = new Referee(this);
	}

	private void initiRounds()
	{
		this.rounds = new Vector<RoundEnvironment>();
		for (short numR=1; numR<=N_ROUND; ++numR) rounds.add(new RoundEnvironment((short)(numR)));
	}

	private void setPossibleWinners(Player player1, Player player2)
	{
		this.winnerPossible1 = player1;
		this.winnerPossible2 = player2;
	}

	public Player getPossibleWinner1(){ return this.winnerPossible1; }
	public Player getPossibleWinner2(){ return this.winnerPossible2; }

    @Override
    public void start(Player player1, Player player2) throws Exception
	{
		setPossibleWinners(player1, player2);
		System.out.println(winnerPossible1.getName().toUpperCase() + " INICIA LA BATALLA!! ..");
		Thread.sleep(5000);

		for (short round=1; round<=N_ROUND; ++round)
		{
			// SE INICIA CADA RONDA
			this.rounds.get(round-1).start(winnerPossible1, winnerPossible2);
			viewWinnerRound(round);
			setNewLifeFighters();

			// PUEDE QUE EN LA RONDA 2 YA SE HALLE UN GANADOR
			if (round == 2 && (viewWinnerFight() != null)) break;

		}
		System.out.println(viewWinnerFight() + " ES EL GANADOR !!!\n");
    }

	private void viewWinnerRound(short round) throws InterruptedException
	{
		System.out.println("\nGANADOR RONDA " + round + ": " +  this.m_referee.seeWinnerRound() + " !!\n");
		Thread.sleep(3000);
	}

	private String viewWinnerFight() { 
		return this.m_referee.seeWinnerFight();
	}

	private void setNewLifeFighters()
	{
		((Luchador) this.winnerPossible1.getFighter()).resetSalud();
		((Luchador) this.winnerPossible2.getFighter()).resetSalud();
	}
}

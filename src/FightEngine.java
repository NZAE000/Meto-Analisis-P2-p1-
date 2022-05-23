import java.util.ArrayList;
import java.util.List;

import ambiente.*;
import jugador.*;

public class FightEngine {
	private Player myPlayer = null;
	private Player cpuOponent = null;
	private List<Environment> m_FightEnvmts = null;
	private static Integer N_ENV = 0;

	public FightEngine()
	{
		initPlayers();
		initEnvioronments();
	}

	public void run() throws Exception
	{
		System.out.println("\n\nEXTREMMME FIGGGHTERRRRR!!\n");
		while (true)
		{
			// SE INICIA CADA AMBIENTE
			for (short evnt=0; evnt<N_ENV; ++evnt)
				m_FightEnvmts.get(evnt).start(myPlayer, cpuOponent);

			resetFighters();
		}
	}

	private void initPlayers()
	{
		this.myPlayer = new User("Player1", null);
		this.cpuOponent = new Cpu("Cpu", null);
	}

	private void initEnvioronments()
	{
		this.m_FightEnvmts = new ArrayList<Environment>();
		this.m_FightEnvmts.add(new SelectEnvironment());
		this.m_FightEnvmts.add(new FightEnvironment());
		FightEngine.N_ENV = this.m_FightEnvmts.size();
	}

	private void resetFighters()
	{
		this.myPlayer.resetFighter();
		this.cpuOponent.resetFighter();
	}

}

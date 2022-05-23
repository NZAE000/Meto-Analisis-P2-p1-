package ambiente;

import estrategia.luchador.Luchador;
import estrategia.luchador.Luchador.TipoAccion;
import estrategia.luchador.decorador.Component;
import jugador.Player;

public class RoundEnvironment extends Environment{
    private static final String limpia = "\033[H\033[2J";
    private short num_ronda = 0;

    public RoundEnvironment(short n_ronda){
		super();
        this.num_ronda = n_ronda;
    }

    @Override
    public void start(Player player1, Player player2) throws Exception {
        
		showLifeBar(player1, player2);
		while (true)
		{
			//USER
			System.out.println("INGRESA ACCIÓN! : \n");
			showMenuActions(player1);
			actionTurn(player1, player2); 		
            showLifeBar(player1, player2);
			if (finished(player1, player2)) break;

			//CPU
			System.out.println("TURNO DE " + ((Luchador) player2.getFighter()).getTipo() + "!");
			Thread.sleep(1200);
			actionTurn(player2, player1);		
            showLifeBar(player1, player2);
			if (finished(player1, player2)) break;
		}
    }
    
	private void showLifeBar(Player player1, Player player2)
	{
		System.out.println(limpia);
		System.out.println("\t\t\t\tRONDA " + num_ronda);
		System.out.println(player1.getName()+ "\t\t\t\t\t\t" + player2.getName());
		System.out.println(((Luchador) player1.getFighter()).getTipo() + ": " + ((Luchador) player1.getFighter()).getSalud() + "\t\t\t\t" +
			((Luchador) player2.getFighter()).getTipo() + ": " + ((Luchador) player2.getFighter()).getSalud() + "\n");
	}

	private void showMenuActions(Player player1)
	{
		((Luchador) player1.getFighter()).getMapActions().forEach((k,v)->System.out.println(k + "-" + v.tipo + " "));
	}

	private void actionTurn(Player attacker, Player receiver) throws InterruptedException
	{
		short opAcc = attacker.selectAction();
		doAction(opAcc, attacker.getFighterProtected(), receiver.getFighterProtected());
		Thread.sleep(1500);
	}

	private void doAction(short opcion, Component attacker, Component receiver)
	{
		TipoAccion someAction = ((Luchador) attacker.getRootCmpt()).getAction(opcion, (Luchador) receiver.getRootCmpt());
		System.out.println(someAction.accion);
		
		receiver.damageIt(someAction.damage, opcion);
	}

	private boolean finished(Player player1, Player player2)
	{
		if (((Luchador) player1.getFighter()).getSalud() <= 0) return true;
		if (((Luchador) player2.getFighter()).getSalud() <= 0) return true;
		return false;
	}
}

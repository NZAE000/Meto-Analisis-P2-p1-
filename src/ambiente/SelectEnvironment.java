package ambiente;

import estrategia.Component;
import estrategia.Damageable;
import estrategia.luchador.Luchador;
import estrategia.luchador.decorador.ComponentProtector;
import jugador.Player;
import man.FightManager;

public class SelectEnvironment extends Environment{

	@Override
    public void start(Player player1, Player player2) throws Exception {
		this.my_man = FightManager.getInstance();
        selectFighters(player1, player2);
		selectProtection(player1, player2);
        selectAbilities(player1, player2);
    }

    private void selectFighters(Player player1, Player player2)
	{
		System.out.println("SELECCIONA UN LUCHADOR !! \n");
		showMenuFighters();

		//USER
		turnSelectFighter(player1);
		//CPU
		turnSelectFighter(player2);
	}

	private void showMenuFighters()
	{
		short size = FightManager.N_FTRY_FIGHTER;
		for (short opF=0; opF<size; ++opF)
			System.out.println(opF+1 + "_ " + my_man.getFightFactory(opF).getType());
	}

	private void turnSelectFighter(Player p)
	{
		short opF = (short)(p.selectFighter()-1);
		p.setFighter(my_man.getFightFactory(opF).createComponent());
		System.out.println("\n"+p.getName() + " ELIGIÓ A " + 
			((Luchador) p.getFighter()).getTipo().toUpperCase() + "!!");
	}

	private void selectProtection(Player player1, Player player2)
	{
		System.out.println("\nSELECCIONA PROTECCIÓN !! \n");
		showMenuProtectors();

		//USER
		turnSelectProtector(player1);
		//CPU
		turnSelectProtector(player2);
	}

	private void showMenuProtectors()
	{
		short size = FightManager.N_FTRY_PROTEC;
		short opP;
		for (opP=0; opP<size; ++opP){
			System.out.println(opP+1 + "_ " + this.my_man.getProtecFactory(opP).getType());
		} System.out.println(opP+1 + "_ NINGUNO");
	}

	private void turnSelectProtector(Player p)
	{
		short opP = (short)(p.selectProtector()-1);
		if (opP < FightManager.N_FTRY_PROTEC){
			Component selectProtec = my_man.getProtecFactory(opP).createComponent();
			((ComponentProtector) selectProtec).setComponent((Damageable) p.getFighter());
			p.setFighter(selectProtec);
			System.out.println("\n" + p.getName() + " AÑADIO " + ((ComponentProtector) p.getFighterProtected()).getTipo());
		}
		else{
			System.out.println("\n" + p.getName() + " SIN PROTECCION AÑADIDA");
		}
	}

	private void selectAbilities(Player player1, Player player2)
	{
		System.out.println("\nELIGE HABILIDAD!!: \n");	
		showMenuAbilities(player1);

		//USER
		turnSelectAbility(player1);
		//CPU
		turnSelectAbility(player2);
	}

	private void showMenuAbilities(Player player1)
	{
		short size = FightManager.N_ABILITIES;
		String tipo = null;
		for (short i=0; i<size; ++i){
			tipo = my_man.getAbility(i).getTipo();
			System.out.print(i+1 + "_ " + tipo);
			if (tipo.equals(((Luchador) player1.getFighter()).getHabilidad().getTipo()))
				System.out.print(" (por defecto)");
			System.out.println();
		}
	}

	private void turnSelectAbility(Player p)
	{
		short opA = (short)(p.selectHabilidad()-1);
		// Se le asigna la habilidad dada la posicion siendo la opcion ingresada
		((Luchador) p.getFighter()).setHabilidad(my_man.getAbility(opA));
		System.out.println("LA HABILIDAD DE " + ((Luchador) p.getFighter()).getTipo() + " ES.. " +
			((Luchador) p.getFighter()).getHabilidad().getTipo() + "!!\n");
	}
    
}

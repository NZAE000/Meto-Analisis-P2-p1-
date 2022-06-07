package man;

import java.util.ArrayList;
import java.util.List;
import estrategia.habilidad.*;
import fabrica.*;
import fabrica.luchadores.*;
import fabrica.protectores.*;

public final class FightManager {

    public static short N_FTRY_FIGHTER = 0, N_FTRY_PROTEC = 0, N_ABILITIES = 0;
    private List<Factory> myFactoryFght           = null;
    private List<Factory> myFactoryProt           = null;
    private List<Habilidad> abilities             = null;
    private static FightManager instance          = null;

    private FightManager() throws Exception {
        try {
            initFactories();
            initAbilities();

        } catch(NullPointerException e){
            throw new Exception("NullPointerException: FighterManager class failed to inicialized");
        }        
    }

    public static FightManager getInstance() throws Exception
    {
        if (instance == null)
            instance = new FightManager();
            
        return instance;
    }
    //INICAILIZAR FABRICAS
    private void initFactories()
    {
        initFighterFactories();
        initProtectorFactories();
        
	}
    //FABIRCAS DE LUCHADORES
    private void initFighterFactories()
    {
        myFactoryFght = new ArrayList<Factory>();
		myFactoryFght.add(new ChoroFactory());
		myFactoryFght.add(new MineroFactory());
        myFactoryFght.add(new CaleranoFactory());
        myFactoryFght.add(new AleatoryFghtFtry());
        FightManager.N_FTRY_FIGHTER = (short) myFactoryFght.size();
    }
    //FABRICAS DE PROTECTORES
    private void initProtectorFactories()
    {
        myFactoryProt = new ArrayList<Factory>();
		myFactoryProt.add(new BucalFactory());
		myFactoryProt.add(new ArmourFactory());
        FightManager.N_FTRY_PROTEC = (short) myFactoryProt.size();
    }

    //HABILIDADES PARA LUCHADORES
    private void initAbilities()
    {
        abilities = new ArrayList<Habilidad>();
        abilities.add(new Normal());
        abilities.add(new Fuerza());
        abilities.add(new Elastico());
        abilities.add(new Magia());
        FightManager.N_ABILITIES = (short) abilities.size();
    }

    //ENTREGAR FABRICA DE LUCHADOR ELEGIDO
    public Factory getFightFactory(short op)
    {
       return myFactoryFght.get(op);
    }

    //ENTREGAR FABRICA DE PROTECTOR ELEGIDO
    public Factory getProtecFactory(short op) 
    { 
        return myFactoryProt.get(op);
    }

    public Habilidad getAbility(short op) { 
        return abilities.get(op);
    }
    
}

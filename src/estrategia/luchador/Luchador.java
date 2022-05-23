package estrategia.luchador;

import java.util.HashMap;
import java.util.Map;

import estrategia.habilidad.Habilidad;
import estrategia.luchador.decorador.Component;

public abstract class Luchador implements Component{
    public class TipoAccion{
        public String tipo = null;
        public String accion = null;
        public short damage;

        public TipoAccion(String tipo, String acc, short dmg){
            this.tipo = tipo; this.accion = acc; this.damage = dmg;
        }
    }
    public class KEY { public static final int key_hit = 1, key_kick = 2, key_jump = 3, key_skill = 4, key_swap = 5;}
    private Map<Integer,TipoAccion> actions = null;
    private Habilidad habilidad;
    private short salud = 100;

    public Luchador(Habilidad habilidad) {
        this.habilidad = habilidad;
        setMapActions();
    }

    public short getSalud()             { return this.salud;     }
    public void resetSalud()            { this.salud = 100;      }
    public Habilidad getHabilidad()     { return this.habilidad; }

    public void setHabilidad(Habilidad ability)
    {
        if (!this.habilidad.getTipo().equals(ability.getTipo())){
            this.habilidad = ability;
            this.actions.get(KEY.key_skill).accion = ability.lanzar();
            this.actions.get(KEY.key_skill).damage = ability.itsDmg();
        }
    }

    public void setMapActions()
    {
        this.actions = new HashMap<>();
        actions.put(KEY.key_hit,
        new TipoAccion("Golpe", golpear(), dmgGolpe()));
        actions.put(KEY.key_kick,
        new TipoAccion("Patada", patear(), dmgPatada()));
        actions.put(KEY.key_jump, 
        new TipoAccion("Salto", saltar(), (short)0));
        actions.put(KEY.key_skill, 
        new TipoAccion("SuperHabilidad", habilidad.lanzar(), habilidad.itsDmg()));
        actions.put(KEY.key_swap, 
        new TipoAccion("ROBAR SuperHabilidad de OPONENTE", null, (short)0));
    }

    public Map<Integer,TipoAccion> getMapActions() { return this.actions; }

    public TipoAccion getAction(int opcion, Luchador opponent)
    {
        if (opcion == KEY.key_swap) { stealAbility(opponent.getHabilidad()); }
        return this.actions.get(opcion);
    }

    public void stealAbility(Habilidad ability)
    {
        this.actions.get(KEY.key_swap).accion = ability.lanzar();
        this.actions.get(KEY.key_swap).damage = ability.itsDmg();
    }
    
    abstract public String golpear();
    abstract public short dmgGolpe();
	abstract public String patear();
    abstract public short dmgPatada();
	abstract public String saltar();
    abstract public String getTipo();

    @Override
    public short damageIt(short damage, short opcion) {
        this.salud-=damage;
        return 0;
    }

    @Override
    public Component getRootCmpt() { return this; }
}

package estrategia.luchador.decorador;

import estrategia.Damageable;
import estrategia.luchador.Luchador.KEY;

public class Armour extends ComponentProtector{
    public static final String TIPO = "ARMOUR";

    public Armour(Damageable comp) { super(comp); }

    @Override
    public short damageIt(short damage, short opcion) 
    {
        if (opcion == KEY.key_kick) damage -= damage/2;
        return this.getComponent().damageIt(damage, opcion);
    }
    @Override
    public String getTipo() { return TIPO; }
    
}

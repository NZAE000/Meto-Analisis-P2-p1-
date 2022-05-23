package estrategia.luchador.decorador;

import estrategia.luchador.Luchador.KEY;

public class Bucal extends ComponentProtector{
    public static final String TIPO = "BUCAL";

    public Bucal(Component comp) { super(comp); }

    @Override
    public short damageIt(short damage, short opcion) 
    {
        if (opcion == KEY.key_hit) damage -= damage/2;
        return getComponent().damageIt(damage, opcion);
    }

    @Override
    public String getTipo() { return TIPO; }
    
}

package estrategia.luchador.decorador;

import estrategia.Damageable;

public class None extends ComponentProtector{
    public static final String TIPO = "Ninguno";

    public None(Damageable comp) { super(comp); }

    @Override
    public short damageIt(short damage, short opcion) 
    {
        return getComponent().damageIt(damage, opcion);
    }

    @Override
    public String getTipo() { return TIPO; }
    
}

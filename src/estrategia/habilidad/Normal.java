package estrategia.habilidad;

public class Normal extends Habilidad {

    public static final String TIPO = "NORMAL";

    @Override
    public String lanzar() { return "SUPER GANCHO!!!\n"; }
    @Override
    public short itsDmg()   { return 15;    }
    @Override
    public String getTipo() { return TIPO;}
    
}

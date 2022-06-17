package estrategia.habilidad;

public class Fuerza extends Habilidad{

    public static final String TIPO = "FUERZA";

    @Override
    public String lanzar() { return "AGARRE SUPER FUERTE!!!\n"; }
    @Override
    public short itsDmg()   { return 30; }
    @Override
    public String getTipo() { return TIPO; }
    
}

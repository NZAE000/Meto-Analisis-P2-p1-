package estrategia.habilidad;

public class Elastico extends Habilidad{

    public static final String TIPO = "ELÁSTICO";

    @Override
    public String lanzar() { return "COMBO SUPER ELÁSTICO!!!\n"; }
    @Override
    public short itsDmg()   { return 25; }
    @Override
    public String getTipo() { return TIPO; }
    
}

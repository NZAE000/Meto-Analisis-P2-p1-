package estrategia.habilidad;

public class Magia extends Habilidad{

    public static final String TIPO = "MAGIA";

    @Override
    public String lanzar() { return "INVOCADO SUPER PODER MÁGICO!!!\n";}
    @Override
    public short itsDmg()   { return 25; }
    @Override
    public String getTipo() { return TIPO; }
    
}

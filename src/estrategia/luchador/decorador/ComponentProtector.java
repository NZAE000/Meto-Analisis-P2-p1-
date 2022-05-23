package estrategia.luchador.decorador;

public abstract class ComponentProtector implements Component{
    private Component compnToDecorate = null;

    public ComponentProtector(Component comp) { this.compnToDecorate = comp; }
    public void setComponent(Component comp)  { this.compnToDecorate = comp; }
    public Component getComponent()           { return this.compnToDecorate;}

    @Override
    public Component getRootCmpt(){
        return this.compnToDecorate.getRootCmpt();
    }
    @Override
    abstract public short damageIt(short damage, short opcion);

    abstract public String getTipo();
}

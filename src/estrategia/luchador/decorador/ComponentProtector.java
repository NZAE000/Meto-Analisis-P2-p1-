package estrategia.luchador.decorador;

import estrategia.Component;
import estrategia.Damageable;

public abstract class ComponentProtector extends Component implements Damageable{
    private Damageable compnToDecorate = null;

    public ComponentProtector(Damageable comp) { this.compnToDecorate = comp; }
    public void setComponent(Damageable comp)  { this.compnToDecorate = comp; }
    public Damageable getComponent()           { return this.compnToDecorate;}

    @Override
    public Component getRootCmpt(){
        return ((Component) this.compnToDecorate).getRootCmpt();
    }
    @Override
    abstract public short damageIt(short damage, short opcion);

    abstract public String getTipo();
}

package estrategia.habilidad;

import estrategia.Component;

public abstract class Habilidad extends Component{

    abstract public String lanzar();
    abstract public short itsDmg();
    abstract public String getTipo();
    @Override
    public Component getRootCmpt() {
        // TODO Auto-generated method stub
        return null;
    }
	
}
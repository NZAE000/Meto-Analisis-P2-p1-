package estrategia.luchador.decorador;


public interface Component {
    abstract public short damageIt(short damage, short opcion);
    abstract public Component getRootCmpt(); // obtener el componente raiz
}

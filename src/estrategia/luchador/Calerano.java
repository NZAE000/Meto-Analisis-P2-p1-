package estrategia.luchador;

import estrategia.habilidad.Habilidad;

public class Calerano extends Luchador{
    public static final String TIPO = "Calerano";
    public Calerano(Habilidad abilidad) { super(abilidad); }

    @Override
    public String golpear()  { return "SUPER JAB CERTERO!!!\n";    }
    @Override
    public String patear()   { return "PATADA LATERAL LETAL!!!\n"; }
    @Override
    public String saltar()   { return "SALTO FANTASTICO!!!\n";     }
    @Override
    public short dmgGolpe()  { return 10;   }
    @Override
    public short dmgPatada() { return 20;   }
    @Override
    public String getTipo()  { return TIPO; }
    
}

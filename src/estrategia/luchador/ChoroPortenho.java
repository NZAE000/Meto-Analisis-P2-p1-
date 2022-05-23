package estrategia.luchador;

import estrategia.habilidad.Habilidad;

public class ChoroPortenho extends Luchador{
	public static final String TIPO = "ChoroPortenho";
	public ChoroPortenho(Habilidad abilidad) { super(abilidad); }
	
	@Override
	public String golpear()  { return "ALETAZO MARINO!!!\n";		 }
	@Override
	public String patear()   { return "PATADA DE LA JAIBAAAAA!!!\n"; } 
	@Override
	public String saltar()   { return "PIQUERO INFERNAAAAAL!!!\n";   }
	@Override
	public short dmgGolpe()  { return 10;   }
	@Override
	public short dmgPatada() { return 20;   }
	@Override
	public String getTipo()  { return TIPO; }
	
}

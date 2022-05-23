package estrategia.luchador;

import estrategia.habilidad.Habilidad;

public class MineroWarrior extends Luchador{
	public static final String TIPO = "MineroWarrior"; 
	public MineroWarrior(Habilidad abilidad) { super(abilidad); }

	@Override
	public String golpear()  { return "PUNO DEL PIRQUINEROOOO!!!\n";   }
	@Override
	public String patear()   { return "PATADA DEL CATEADOOOOOOR!!!\n"; }
	@Override
	public String saltar()   { return "SALTO EXPLOSIVOOOOO!!!\n";      }
	@Override
	public short dmgGolpe()  { return 10;   }
	@Override
	public short dmgPatada() { return 20;   }
	@Override
	public String getTipo()  { return TIPO; }

}

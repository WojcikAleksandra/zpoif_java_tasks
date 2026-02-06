package pl.edu.pw.mini.zpoif.task4a.solution;

import java.lang.reflect.*;

import pl.edu.pw.mini.zpoif.task4a.Generator;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.Puchacz;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.przyrzady.Wariometr;

public class Main {
	
	private Puchacz puchacz = (Puchacz) Generator.utworzPuchacza();;
	
	public Wariometr metoda1() throws Exception {
		return Wariometr.class.newInstance();
	}
	
	public void metoda2() throws Exception {
		Field kabina = puchacz.getClass().getDeclaredField("kabinaPierwsza");
		kabina.setAccessible(true);
		Field f2 = kabina.get(puchacz).getClass().getField("uchwytHamulcaAerodynamicznego");
		f2.setAccessible(true);
		Object hamulecAero = f2.get(kabina.get(puchacz)); // uchwyt hamulca aero w kabinie
		Field f3 = kabina.get(puchacz).getClass().getField("uchwytHamulcaKola");
		f3.setAccessible(true);
		Object hamulecKolo = f3.get(kabina.get(puchacz)); // uchwyt hamulca kola w kabinie
		Method pociagnij1 = hamulecAero.getClass().getMethod("pociagnij", int.class);
		Method pociagnij2 = hamulecKolo.getClass().getMethod("pociagnij", int.class);
		pociagnij1.invoke(hamulecAero, 50);
		pociagnij2.invoke(hamulecKolo, 25);
	}

	public void metoda4() throws Exception {
		Field kabina = puchacz.getClass().getDeclaredField("kabinaPierwsza");
		kabina.setAccessible(true);
		Object obj = kabina.get(puchacz);
		for (Field f : obj.getClass().getFields()) {
			f.setAccessible(true);
			if (f.getName().startsWith("uchwyt")) {
				Field kolor = f.get(obj).getClass().getField("kolorUchwytu");
				System.out.println(kolor.getName());
			}
		}
	}
	
	public void metoda3() throws Exception {
		Field kabina = puchacz.getClass().getDeclaredField("kabinaPierwsza");
		kabina.setAccessible(true);
		Object obj = kabina.get(puchacz);
		Field tablicaPrzyrz = obj.getClass().getField("tablicaPrzyrzadow");
		tablicaPrzyrz.setAccessible(true);
		Object tablicaObject = tablicaPrzyrz.get(obj);
		Field f = tablicaObject.getClass().getField("wariometr");
		f.setAccessible(true);
		// f.set(tablicaObject, f);
	}
	
	public static void main(String[] args) {
		
	}

}

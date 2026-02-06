package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import solution.DoIt;

public class ButtonMan extends MafiaWorker {

	protected String firstVictim = "John D.";
	protected String secondVictim = "Matt Cooper";
	protected String thirdVictim = "Unknown";

	public ButtonMan() {
		super();
	}

	public ButtonMan(String name, String surname) {
		super(name, surname);
	}

	public ButtonMan(String name) {
		super(name);
	}

	@DoIt(times = 5)
	public void killHim(String value) {
		System.out.println(value + " has been killed!");
	}

	@DoIt(times = 10)
	public void killThemAll(String value) {
		System.out.println(value + " also killed");
	}

}

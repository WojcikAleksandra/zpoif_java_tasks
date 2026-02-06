package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import solution.ImportantWorker;
import solution.InitMe;
import solution.LengthValidator;
import solution.PrimaryMafiaWorker;

@ImportantWorker(quantity = 1)
@PrimaryMafiaWorker
public class GodFather extends MafiaWorker {

	@InitMe
	protected Pocket pocket;

	public GodFather() {
		super();
	}

	public GodFather(@LengthValidator String name, String surname) {
		super(name, surname);
	}

	public GodFather(@LengthValidator String name) {
		super(name);
	}

}

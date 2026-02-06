package afera_zad2_Wojcik_Aleksandra;

import java.time.LocalDate;

public class Poledwica extends Wedlina {
	protected LocalDate dataPrzydatnosci;
	protected String szczelneOpakowanie;
		
	public Poledwica(int id, LocalDate dataPrzydatnosci, String szczelneOpakowanie) {
		super(id);
		this.dataPrzydatnosci = dataPrzydatnosci;
		this.szczelneOpakowanie = szczelneOpakowanie;
	}
}

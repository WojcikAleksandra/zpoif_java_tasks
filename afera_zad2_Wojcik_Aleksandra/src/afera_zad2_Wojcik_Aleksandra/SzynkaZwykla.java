package afera_zad2_Wojcik_Aleksandra;

import java.time.LocalDate;

public class SzynkaZwykla extends Poledwica {
	protected String bakteria;
	
	public SzynkaZwykla(int id, LocalDate dataPrzydatnosci, String szczelneOpakowanie, String bakteria) {
		super(id, dataPrzydatnosci, szczelneOpakowanie);
		this.bakteria = bakteria;
	}
}

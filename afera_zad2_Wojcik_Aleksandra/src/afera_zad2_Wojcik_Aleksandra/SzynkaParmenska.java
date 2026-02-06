package afera_zad2_Wojcik_Aleksandra;

import java.time.LocalDate;

public class SzynkaParmenska extends SzynkaZwykla {
	private String certyfikat;
	
	public SzynkaParmenska(int id, LocalDate dataPrzydatnosci, String szczelneOpakowanie, String bakteria, String certyfikat) {
		super(id, dataPrzydatnosci, szczelneOpakowanie, bakteria);
		this.certyfikat = certyfikat;
	}
}

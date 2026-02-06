package pl.edu.pw.mini.zpoif.task3.generator;

import java.util.List;

import pl.edu.pw.mini.zpoif.task3.model.StatekNawodny;
import pl.edu.pw.mini.zpoif.task3.model.jacht.Jacht;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtKabinowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtMotorowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtZaglowy;

public interface Statki {
	StatekNawodny getNajkrotszyStatek();
	JachtKabinowy getNajciezszyStatekNaJ();
	JachtZaglowy getJachtZaglowyONajmniejszejPowierzchniZagla();
	JachtMotorowy getCiezkiJachtMotorowyONajwiekszejMocyDo250KM();
	List<JachtMotorowy> getCoNajwyzej20CiezkichIMocnychJachtowMotorowych();
	List<JachtKabinowy> getJachtowKabinowychPosortowanychMalejacoWzgledemPowZagla();
	List<JachtMotorowy> get3NajmocniejszeSposrod6Najkrotszych();
	void wypiszMotorowkiDlaCrocketa();
	String getSuma10UnikalnychDlugosciJachtu();
	List<Jacht> getMotoroweINajkrotszeOdkrytopokladoweJednePoDrugich();
}

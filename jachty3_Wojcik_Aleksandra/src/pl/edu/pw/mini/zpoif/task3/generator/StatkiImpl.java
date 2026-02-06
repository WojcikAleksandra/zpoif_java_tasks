package pl.edu.pw.mini.zpoif.task3.generator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import pl.edu.pw.mini.zpoif.task3.model.StatekNawodny;
import pl.edu.pw.mini.zpoif.task3.model.jacht.Jacht;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtKabinowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtMotorowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtOdkrytopokladowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtZaglowy;

public class StatkiImpl implements Statki {
	private  List<StatekNawodny> statkiNawodne = GeneratorStatkow.generujStatkiNawodne();

	@Override
	public StatekNawodny getNajkrotszyStatek() {
		int minMasa = statkiNawodne.stream()
				.map(s -> s.getMasa())
				.min(Integer::compareTo)
				.get();
		return statkiNawodne.stream()
				.filter(s -> s.getMasa() == minMasa)
				.findFirst().get();
	}

	@Override
	public JachtKabinowy getNajciezszyStatekNaJ() {
		List<StatekNawodny> jachtyKabNaJ = statkiNawodne.stream()
		.filter(s -> s instanceof JachtKabinowy)
		.filter(s -> s.getNazwaProducenta().startsWith("J"))
		.toList();
		int maxMasa = jachtyKabNaJ.stream()
				.map(s -> s.getMasa())
				.max(Integer::compareTo)
				.get();
		return (JachtKabinowy) jachtyKabNaJ.stream()
				.filter(s -> s.getMasa() == maxMasa)
				.findFirst()
				.get();
	}

	@Override
	public JachtZaglowy getJachtZaglowyONajmniejszejPowierzchniZagla() {
		List<StatekNawodny> jachtyOlubK = statkiNawodne.stream()
				.filter(s -> s instanceof JachtZaglowy)
				.toList();
		double minPow = jachtyOlubK.stream()
				.map(s -> ((JachtZaglowy) s).getPowierzchniaZagla())
				.min(Double::compareTo)
				.get();
		return (JachtZaglowy) jachtyOlubK.stream()
				.filter(s -> ((JachtZaglowy) s).getPowierzchniaZagla() == minPow)
				.findFirst()
				.get();
	}

	@Override
	public JachtMotorowy getCiezkiJachtMotorowyONajwiekszejMocyDo250KM() {
		List<StatekNawodny> jachtyMotoroweDo250KM = statkiNawodne.stream()
				.filter(s -> s instanceof JachtMotorowy)
				.filter(s -> ((JachtMotorowy) s).getMocSilnika() <= 250)
				.toList();
		int maxMasa = jachtyMotoroweDo250KM.stream()
				.map(s -> s.getMasa())
				.max(Integer::compareTo)
				.get();
		return (JachtMotorowy) jachtyMotoroweDo250KM.stream()
				.filter(s -> s.getMasa() == maxMasa)
				.findFirst()
				.get();
	}

	@Override
	public List<JachtMotorowy> getCoNajwyzej20CiezkichIMocnychJachtowMotorowych() {
		return  statkiNawodne.stream()
				.filter(s -> s instanceof JachtMotorowy)
				.filter(s -> s.getMasa() >= 1400 && s.getDlugosc() >= 600)
				.limit(10)
				.map(s -> (JachtMotorowy) s)
				.toList();
	}

	@Override
	public List<JachtKabinowy> getJachtowKabinowychPosortowanychMalejacoWzgledemPowZagla() {
		return statkiNawodne.stream()
				.filter(s -> s instanceof JachtKabinowy)
				.skip(4)
				.sorted(new Comparator<StatekNawodny>() {

					@Override
					public int compare(StatekNawodny o1, StatekNawodny o2) {
						if (((JachtKabinowy) o1).getPowierzchniaZagla() < ((JachtKabinowy) o2).getPowierzchniaZagla())
						return 1;
						else if (((JachtKabinowy) o1).getPowierzchniaZagla() > ((JachtKabinowy) o2).getPowierzchniaZagla())
						return -1;
						else return 0;
					}
				})
				.limit(15)
				.map(s -> (JachtKabinowy) s)
				.toList();
	}

	@Override
	public List<JachtMotorowy> get3NajmocniejszeSposrod6Najkrotszych() {
		return statkiNawodne.stream()
				.skip(3)
				.filter(s -> s instanceof JachtMotorowy)
				.sorted(new Comparator<StatekNawodny>() {

					@Override
					public int compare(StatekNawodny o1, StatekNawodny o2) {
						if (o1.getDlugosc() > o2.getDlugosc())
						return 1;
						else if (o1.getDlugosc() < o2.getDlugosc())
						return -1;
						else return 0;
					}
				})
				.limit(6)
				.sorted(new Comparator<StatekNawodny>() {

					@Override
					public int compare(StatekNawodny o1, StatekNawodny o2) {
						if (((JachtMotorowy) o1).getMocSilnika() < ((JachtMotorowy) o2).getMocSilnika())
						return 1;
						else if (((JachtMotorowy) o1).getMocSilnika() > ((JachtMotorowy) o2).getMocSilnika())
						return -1;
						else return 0;
					}
				})
				.limit(3)
				.map(s -> (JachtMotorowy) s)
				.toList();
				
	}

//	@Override
//	public void wypiszMotorowkiDlaCrocketa() {
//		statkiNawodne.stream()
//		.filter(s -> s instanceof JachtMotorowy)
//		.filter(s -> ((JachtMotorowy) s).getMocSilnika() > 500)
//		.skip(1)
//		.limit(s)
//		.forEach(System.out::printf("Model %s  jest dobry do Miami Vice!"));
//	}

	@Override
	public String getSuma10UnikalnychDlugosciJachtu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jacht> getMotoroweINajkrotszeOdkrytopokladoweJednePoDrugich() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package pl.edu.pw.mini.zpoif.task3.generator;

public class Demonstrator {

	public static void main(String[] args) {
		StatkiImpl statki = new StatkiImpl();
		System.out.println(statki.getNajkrotszyStatek());
		System.out.println(statki.getNajciezszyStatekNaJ());
		System.out.println(statki.getJachtZaglowyONajmniejszejPowierzchniZagla());
		System.out.println(statki.getCiezkiJachtMotorowyONajwiekszejMocyDo250KM());
		System.out.println(statki.getCoNajwyzej20CiezkichIMocnychJachtowMotorowych());
		System.out.println(statki.getJachtowKabinowychPosortowanychMalejacoWzgledemPowZagla());
		System.out.println(statki.get3NajmocniejszeSposrod6Najkrotszych());
		
	}

}

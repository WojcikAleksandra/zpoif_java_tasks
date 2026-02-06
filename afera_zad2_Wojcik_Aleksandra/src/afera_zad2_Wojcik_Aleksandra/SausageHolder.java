package afera_zad2_Wojcik_Aleksandra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.function.Supplier;

public class SausageHolder {
	private ArrayList<Wedlina> kolekcja;
	private static IdSetter idSetter = (listaId) -> {
		Random random = new Random();
		int index = random.nextInt(listaId.size());
		int id = listaId.get(index);
		listaId.remove(index);
		return id;
	};
	private static Supplier<String> smokeSetter = () -> {
		Random random = new Random();
		int x = random.nextInt(3);
		if (x == 0) {
			return "maly";
		} else if (x == 1) {
			return "sredni";
		} else {
			return "duzy";
		}
	};
	private static Supplier<String> bacteriaSetter = () -> {
		Random random = new Random();
		int x = random.nextInt(10);
		if (x == 0) {
			return "tak";
		} else {
			return "nie";
		}
	};
	private static Supplier<String> tightSetter = () -> {
		Random random = new Random();
		int x = random.nextInt(100);
		if (x < 6) {
			return "tak";
		} else {
			return "nie";
		}
	};
	private static Supplier<String> certificateSetter = () -> {
		Random random = new Random();
		int x = random.nextInt(3);
		if (x == 0) {
			return "tak";
		} else if (x == 1) {
			return "nie";
		} else {
			return "nie wiadomo";
		}
	};
	private static Supplier<LocalDate> dateSetter = () -> LocalDate.now().minusDays(new Random().nextInt(71));
	
	public SausageHolder() {
		ArrayList<Integer> listaId = new ArrayList<>();
		for (int i = 0; i < 400; i++) {
			listaId.add(i);
		}
		for (int i = 0; i < 100; i++) {
			kolekcja.add(new Kielbasa(idSetter.setId(listaId), smokeSetter.get()));
			kolekcja.add(new SzynkaZwykla(idSetter.setId(listaId), dateSetter.get(), tightSetter.get(), bacteriaSetter.get()));
			kolekcja.add(new SzynkaParmenska(idSetter.setId(listaId), dateSetter.get(), tightSetter.get(), bacteriaSetter.get(), certificateSetter.get()));
			kolekcja.add(new Poledwica(idSetter.setId(listaId), dateSetter.get(), tightSetter.get()));
		}
		Collections.shuffle(kolekcja);
	}
}

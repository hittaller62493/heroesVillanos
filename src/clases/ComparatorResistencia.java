package clases;

import java.util.Comparator;

public class ComparatorResistencia implements Comparator<Competidor> {

	@Override
	public int compare(Competidor c1, Competidor c2) {

		if (Double.compare(c1.getDestreza(), c2.getDestreza()) == 0 && Competidor.getContador() <= 4) {
			ComparatorDestreza comparatorDestreza = new ComparatorDestreza();
			Competidor.incrementarContador();
			return comparatorDestreza.compare(c1, c2);
		} else
			return Double.compare(c1.getDestreza(), c2.getDestreza());
	}
}
package clases;

import java.util.Comparator;

public class ComparatorResistencia implements Comparator<Competidor> {

	@Override
	public int compare(Competidor c1, Competidor c2) {

		if (Double.compare(c1.getResistencia(), c2.getResistencia()) == 0 && c1.getContador() <= 4) {
			ComparatorDestreza comparatorDestreza = new ComparatorDestreza();
			c1.incrementarContador();
			return comparatorDestreza.compare(c1, c2);
		} else
			return Double.compare(c1.getResistencia(), c2.getResistencia());
	}
}
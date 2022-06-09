package clases;

import java.util.Comparator;

public class ComparatorFuerza implements Comparator<Competidor> {

	@Override
	public int compare(Competidor c1, Competidor c2) {

		if (Double.compare(c1.getFuerza(), c2.getFuerza()) == 0 && Competidor.getContador() <= 4) {
			ComparatorResistencia comparatorResistencia = new ComparatorResistencia();
			Competidor.incrementarContador();
			return comparatorResistencia.compare(c1, c2);
		} else
			return Double.compare(c1.getFuerza(), c2.getFuerza());
	}
}
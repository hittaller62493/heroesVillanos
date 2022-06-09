package clases;

import java.util.Comparator;

public class ComparatorVelocidad implements Comparator<Competidor> {

	@Override
	public int compare(Competidor c1, Competidor c2) {
		if (Double.compare(c1.getVelocidad(), c2.getVelocidad()) == 0 && Competidor.getContador() <= 4) {
			ComparatorFuerza comparatorFuerza = new ComparatorFuerza();
			Competidor.incrementarContador();
			return comparatorFuerza.compare(c1, c2);
		} else
			return Double.compare(c1.getVelocidad(), c2.getVelocidad());
	}
}
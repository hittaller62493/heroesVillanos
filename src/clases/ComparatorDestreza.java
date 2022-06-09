package clases;

import java.util.Comparator;

public class ComparatorDestreza implements Comparator<Competidor> {

	@Override
	public int compare(Competidor c1, Competidor c2) {

		if (Double.compare(c1.getDestreza(), c2.getDestreza()) == 0 && Competidor.getContador() <= 4) {
			ComparatorVelocidad comparatorVelocidad = new ComparatorVelocidad();
			Competidor.incrementarContador();
			return comparatorVelocidad.compare(c1, c2);
		} else
			return Double.compare(c1.getDestreza(), c2.getDestreza());
	}
}
package clases;

import java.util.Comparator;
/*
 * Comparador de destreza que utiliza un comparador de competidor
 */

public class ComparatorDestreza implements Comparator<Competidor> {

	/*
	 * @return comparacion de un competidor por su destreza.
	 * @param competidor c1 y c2.
	 */
	@Override
	public int compare(Competidor c1, Competidor c2) {

		if (Double.compare(c1.getDestreza(), c2.getDestreza()) == 0 && c1.getContador() <= 4) {
			ComparatorVelocidad comparatorVelocidad = new ComparatorVelocidad();
			c1.incrementarContador();
			return comparatorVelocidad.compare(c1, c2);
		} else
			return Double.compare(c1.getDestreza(), c2.getDestreza());
	}
}
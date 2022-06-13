package clases;

import java.util.Comparator;
/*
 * Comparador de velocidad que utiliza un comparador de competidor.
 */
public class ComparatorVelocidad implements Comparator<Competidor> {

	/*
	 * @return comparacion de un competidor por su velocidad.
	 * @param competidor c1 y c2.
	 */
	@Override
	public int compare(Competidor c1, Competidor c2) {
		if (Double.compare(c1.getVelocidad(), c2.getVelocidad()) == 0 && c1.getContador() <= 4) {
			ComparatorFuerza comparatorFuerza = new ComparatorFuerza();
			c1.incrementarContador();
			return comparatorFuerza.compare(c1, c2);
		} else
			return Double.compare(c1.getVelocidad(), c2.getVelocidad());
	}
}
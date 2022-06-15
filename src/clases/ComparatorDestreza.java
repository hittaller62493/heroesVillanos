package clases;

import java.util.Comparator;
/*
 * Comparador de destreza que utiliza un comparador de competidor
 */

public class ComparatorDestreza implements Comparator<Competidor> {

	/*
	 * @return comparacion de un competidor por su destreza.
	 * 
	 * @param competidor c1 y c2.
	 */
	@Override
	public int compare(Competidor c1, Competidor c2) {

		if (c1.empataCon(c2))
			return 0;

		if (Double.compare(c1.getDestreza(), c2.getDestreza()) == 0) {
			ComparatorVelocidad comparatorVelocidad = new ComparatorVelocidad();
			return comparatorVelocidad.compare(c1, c2);
		} else
			return Double.compare(c1.getDestreza(), c2.getDestreza());
	}
}
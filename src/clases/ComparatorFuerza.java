package clases;

import java.util.Comparator;
/*
 * Comparador de fuerza que utiliza un comparador de competidor.
 */

public class ComparatorFuerza implements Comparator<Competidor> {

	/*
	 * @return comparacion de un competidor por su fuerza.
	 * 
	 * @param competidor c1 y c2.
	 */
	@Override
	public int compare(Competidor c1, Competidor c2) {

		if (c1.empataCon(c2))
			return 0;

		if (Double.compare(c1.getFuerza(), c2.getFuerza()) == 0) {
			ComparatorResistencia comparatorResistencia = new ComparatorResistencia();
			return comparatorResistencia.compare(c1, c2);
		} else
			return Double.compare(c1.getFuerza(), c2.getFuerza());
	}
}
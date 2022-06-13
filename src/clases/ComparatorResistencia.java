package clases;

import java.util.Comparator;
/*
 * Comparador de resistencia que utiliza un comparador de competidor.
 */
public class ComparatorResistencia implements Comparator<Competidor> {

	/*
	 * @return comparacion de un competidor por su resistencia.
	 * @param competidor c1 y c2.
	 */
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
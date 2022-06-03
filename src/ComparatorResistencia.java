import java.util.Comparator;

public class ComparatorResistencia  implements Comparator<Personaje> {

    @Override
	public int compare(Personaje o1, Personaje o2) {
		if (o1.equals(o2))
			return 0;
		if (Integer.compare(o1.caracteristicas.get(2).getPuntos(), o2.caracteristicas.get(2).getPuntos()) == 0 && Personaje.getContador() <= 4) {
			ComparatorDestreza comparatorDestreza = new ComparatorDestreza();
            Personaje.incrementarContador();
			return comparatorDestreza.compare(o1, o2);
		} else
			return Integer.compare(o1.caracteristicas.get(2).getPuntos(), o2.caracteristicas.get(2).getPuntos());
	}
}

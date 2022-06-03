import java.util.Comparator;

public class ComparatorDestreza  implements Comparator<Personaje> {

    @Override
	public int compare(Personaje o1, Personaje o2) {
		if (o1.equals(o2))
			return 0;
		if (Integer.compare(o1.caracteristicas.get(3).getPuntos(), o2.caracteristicas.get(3).getPuntos()) == 0 && Personaje.getContador() <= 4) {
			ComparatorVelocidad comparatorVelocidad = new ComparatorVelocidad();
            Personaje.incrementarContador();
			return comparatorVelocidad.compare(o1, o2);
		} else
			return Integer.compare(o1.caracteristicas.get(3).getPuntos(), o2.caracteristicas.get(3).getPuntos());
	}
}

import java.util.Comparator;

public class ComparatorFuerza implements Comparator<Personaje>{

    @Override
	public int compare(Personaje o1, Personaje o2) {
		if (o1.equals(o2))
			return 0;
		if (Integer.compare(o1.caracteristicas.get(1).getPuntos(), o2.caracteristicas.get(1).getPuntos()) == 0 && Personaje.getContador() <= 4) {
			ComparatorResistencia comparatorResistencia = new ComparatorResistencia();
            Personaje.incrementarContador();
			return comparatorResistencia.compare(o1, o2);
		} else
			return Integer.compare(o1.caracteristicas.get(1).getPuntos(), o2.caracteristicas.get(1).getPuntos());
	}
}

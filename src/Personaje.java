import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public abstract class Personaje implements Comparable<Personaje> {
	private String nombreReal;
	private String nombrePersonaje;

	private List<Caracteristicas> caracteristicas = new ArrayList<Caracteristicas>();

	public Personaje(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
		caracteristicas.add(new Caracteristicas(Caracteristica.VELOCIDAD, velocidad));
		caracteristicas.add(new Caracteristicas(Caracteristica.FUERZA, fuerza));
		caracteristicas.add(new Caracteristicas(Caracteristica.RESISTENCIA, resistencia));
		caracteristicas.add(new Caracteristicas(Caracteristica.DESTREZA, destreza));

	}

	public Personaje(String nombre) {
		this.nombrePersonaje = nombre;
	}

	public int competir(Personaje o, Caracteristica c) {
		int contador = 0;
		ListIterator<Caracteristicas> itr = caracteristicas.listIterator(caracteristicas.indexOf(c));
		while (contador != 4) {
			if (itr.hasNext()) {
				itr.next();
			}
		}

		return 0;
	}

	@Override
	public int compareTo(Personaje o) {
		return 0;
	}

}
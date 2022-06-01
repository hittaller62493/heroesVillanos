import java.util.ArrayList;
import java.util.List;

public class Liga extends Personaje {
	private List<Personaje> personajes = new ArrayList<Personaje>();

	public Liga(String nombre) {
		super(nombre);
	}

	public void addPersonaje(Personaje personaje) {
		personajes.add(personaje);
	}

	public boolean esGanador(Personaje personaje) {
		return true;
	}

	public enum Caracteristica {
		VELOCIDAD, FUERZA, RESISTENCIA, DESTREZA
	}

}

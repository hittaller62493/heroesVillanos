
public abstract class Personaje implements Comparable<Personaje> {
	private String nombreReal;
	private String nombrePersonaje;
	private int velocidad;
	private int fuerza;
	private int resistencia;
	private int destreza;

	public Personaje(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.destreza = destreza;
	}

	public Personaje(String nombre) {
		this.nombrePersonaje = nombre;
	}

	@Override
	public int compareTo(Personaje o) {
		return 0;
	}

}
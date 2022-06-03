import java.util.ArrayList;
import java.util.List;

public abstract class Personaje implements Comparable<Personaje> {
	private static int contador=0;
	private String nombreReal;
	private String nombrePersonaje;

	public List<Caracteristicas> caracteristicas = new ArrayList<Caracteristicas>();


	public Personaje(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
		caracteristicas.add(new Caracteristicas(Caracteristica.VELOCIDAD, velocidad));
		caracteristicas.add(new Caracteristicas(Caracteristica.FUERZA, fuerza));
		caracteristicas.add(new Caracteristicas(Caracteristica.RESISTENCIA, resistencia));
		caracteristicas.add(new Caracteristicas(Caracteristica.DESTREZA, destreza));

	}

	public int competir (Personaje o, Caracteristica c) {
		if (c.equals(Caracteristica.VELOCIDAD)){
			ComparatorVelocidad compVel = new ComparatorVelocidad();
			resetearContador();
			return compVel.compare(this, o);
		}
		if (c.equals(Caracteristica.FUERZA)){
			ComparatorFuerza compFue = new ComparatorFuerza();
			resetearContador();
			return compFue.compare(this, o);
		}
		if (c.equals(Caracteristica.RESISTENCIA)){
			ComparatorResistencia compRes = new ComparatorResistencia();
			resetearContador();
			return compRes.compare(this, o);
		}
		if (c.equals(Caracteristica.DESTREZA)){
			ComparatorDestreza compDes = new ComparatorDestreza();
			resetearContador();
			return compDes.compare(this, o);
		}
		
		return 0;

		}

		public static void resetearContador() {
			contador= 0;
		}

		public static void incrementarContador() {
			contador++;
		}
		public static int getContador() {
			return contador;
		}

	public Personaje(String nombre) {
		this.nombrePersonaje = nombre;
	}

	@Override
	public int compareTo(Personaje o) {
		return 0;			
	}

}
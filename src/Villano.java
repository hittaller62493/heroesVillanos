public class Villano extends Competidor {

	public Villano(String nombreReal, String nombrePersonaje, double velocidad, double fuerza, double resistencia,
			double destreza) {
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
	}

	@Override
	public int competir(Competidor competidor, Caracteristica caracteristica) {
		
		return super.competir(competidor, caracteristica);
	}
}

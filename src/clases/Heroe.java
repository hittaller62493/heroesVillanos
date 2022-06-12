package clases;

import excepciones.CaracteristicaInvalidaEx;
import excepciones.NombreInvalidoEx;

public class Heroe extends Competidor {

	public Heroe(String nombreReal, String nombrePersonaje, double velocidad, double fuerza, double resistencia,
			double destreza) throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);

	}

}

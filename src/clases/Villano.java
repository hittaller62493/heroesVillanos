package clases;

import excepciones.CaracteristicaInvalidaEx;
import excepciones.NombreInvalidoEx;
/*
 * Villano extension de Competidor.
 */
public class Villano extends Competidor {

	/*
	 * Crea un villano recibiendo como parametros los heredados.
	 * @param nombreReal.
	 * @param nombrePersonaje.
	 * @param velocidad.
	 * @param fuerza.
	 * @param resistencia.
	 * @param destreza.
	 */
	public Villano(String nombreReal, String nombrePersonaje, double velocidad, double fuerza, double resistencia,
			double destreza) throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
	}

}

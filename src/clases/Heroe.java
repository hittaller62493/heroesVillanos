package clases;

import excepciones.CaracteristicaInvalidaEx;
import excepciones.NombreInvalidoEx;

/*
 * Heroe extension de Competidor.
 */
public class Heroe extends Competidor {

	/*
	 * Crea un heroe recibiendo como parametros los heredados.
	 * @param nombreReal.
	 * @param nombrePersonaje.
	 * @param velocidad.
	 * @param fuerza.
	 * @param resistencia.
	 * @param destreza.
	 */
	public Heroe(String nombreReal, String nombrePersonaje, double velocidad, double fuerza, double resistencia,
			double destreza) throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);

	}

}

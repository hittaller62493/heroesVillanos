package clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import excepciones.*;

/*
 * Competidor(Principal)
 */
public abstract class Competidor {
	private String nombreReal;
	private String nombrePersonaje;
	private Atributo velocidad;
	private Atributo fuerza;
	private Atributo resistencia;
	private Atributo destreza;

	/*
	 * Crea un competidor recibiendo parametros los atributos.
	 * 
	 * @param nombreReal.
	 * 
	 * @param nombrePersonaje.
	 * 
	 * @param velocidad.
	 * 
	 * @param fuerza.
	 * 
	 * @param resistencia.
	 * 
	 * @param destreza.
	 */
	public Competidor(String nombreReal, String nombrePersonaje, double velocidad, double fuerza, double resistencia,
			double destreza) throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		setNombreReal(nombreReal);
		setNombrePersonaje(nombrePersonaje);
		setAtributos(velocidad, fuerza, resistencia, destreza);
	}

	/*
	 * Crea otro tipo de competidor recibiendo de parametro el nombre.
	 * 
	 * @param nombre.
	 */
	public Competidor(String nombre) throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		setNombrePersonaje(nombre);
		setAtributos(0, 0, 0, 0);
	}

	/*
	 * @return si el competidor es heroe o no.
	 */
	public boolean esHeroe() {
		return this.getClass().equals(Heroe.class);
	}

	/*
	 * @param competidor
	 * 
	 * @param caracteristica
	 * 
	 * @return devuelve un entero que se utiliza para definir el ganador/perdedor o
	 * si hay empate.
	 */
	public int competir(Competidor competidor, Caracteristica caracteristica) throws MismoTipoCompetidorEx {

		if (this.esHeroe() == competidor.esHeroe()) {
			throw new MismoTipoCompetidorEx("No pueden competir personajes del mismo tipo.");
		}

		List<Comparator<Competidor>> listComparadores = new ArrayList<Comparator<Competidor>>();
		listComparadores.add(new ComparatorVelocidad());
		listComparadores.add(new ComparatorFuerza());
		listComparadores.add(new ComparatorResistencia());
		listComparadores.add(new ComparatorDestreza());

		Comparator aux = listComparadores.get(caracteristica.ordinal());

		return aux.compare(this, competidor);

	}

	/*
	 * @return el valor de la velocidad.
	 */
	public double getVelocidad() {
		return velocidad.getPuntos();
	}

	/*
	 * @return el valor de la fuerza.
	 */
	public double getFuerza() {
		return fuerza.getPuntos();
	}

	/*
	 * @return el valor de resistencia.
	 */
	public double getResistencia() {
		return resistencia.getPuntos();
	}

	/*
	 * @return el valor de destreza.
	 */
	public double getDestreza() {
		return destreza.getPuntos();
	}

	/*
	 * @post aumenta la velocidad.
	 * 
	 * @param velocidad.
	 */
	public void incrementarVelocidad(double velocidad) {
		this.velocidad.incrementarPuntos(velocidad);
	}

	/*
	 * @post aumenta la fuerza.
	 * 
	 * @param fuerza.
	 */
	public void incrementarFuerza(double fuerza) {
		this.fuerza.incrementarPuntos(fuerza);
	}

	/*
	 * @post aumenta la resistencia.
	 * 
	 * @param resistencia.
	 */
	public void incrementarResistencia(double resistencia) {
		this.resistencia.incrementarPuntos(resistencia);
	}

	/*
	 * @post aumenta la destreza.
	 * 
	 * @param destreza.
	 */
	public void incrementarDestreza(double destreza) {
		this.destreza.incrementarPuntos(destreza);
	}

	/*
	 * @return si el competidor ganó mediante la caracteristica dada.
	 * 
	 * @param competidor.
	 * 
	 * @param caracteristica.
	 */
	public boolean esGanador(Competidor competidor, Caracteristica caracteristica) throws MismoTipoCompetidorEx {
		return (competir(competidor, caracteristica) == 1);
	}

	/*
	 * @return el nombre real.
	 */
	public String getNombreReal() {
		return nombreReal;
	}

	/*
	 * @return el nombre del personaje.
	 */
	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	/*
	 * @return el tipo de caracteristica.
	 * 
	 * @param c: caracteristica.
	 */
	public double getCaracteristica(Caracteristica c) {

		if (c.equals(Caracteristica.VELOCIDAD)) {
			return getVelocidad();
		}
		if (c.equals(Caracteristica.FUERZA)) {
			return getFuerza();
		}
		if (c.equals(Caracteristica.RESISTENCIA)) {
			return getResistencia();
		}
		if (c.equals(Caracteristica.DESTREZA)) {
			return getDestreza();
		}

		return -2;
	}

	/*
	 * @return los datos completos.
	 */
	@Override
	public String toString() {
		return "Competidor [nombreReal=" + nombreReal + ", nombrePersonaje=" + nombrePersonaje + ", velocidad="
				+ velocidad + ", fuerza=" + fuerza + ", resistencia=" + resistencia + ", destreza=" + destreza + "]";
	}

	/*
	 * @post setea los atributos con los parametros dados.
	 * 
	 * @param velocidad.
	 * 
	 * @param fuerza.
	 * 
	 * @param resistencia.
	 * 
	 * @param desteza.
	 */
	private void setAtributos(double velocidad, double fuerza, double resistencia, double destreza)
			throws CaracteristicaInvalidaEx {
		validarCaracteristicas(velocidad, fuerza, resistencia, destreza);
		this.velocidad = new Atributo(Caracteristica.VELOCIDAD, velocidad);
		this.fuerza = new Atributo(Caracteristica.FUERZA, fuerza);
		this.resistencia = new Atributo(Caracteristica.RESISTENCIA, resistencia);
		this.destreza = new Atributo(Caracteristica.DESTREZA, destreza);
	}

	/*
	 * @post valida las caracteristicas dadas
	 * 
	 * @param velocidad
	 * 
	 * @param fuerza
	 * 
	 * @param resistencia
	 * 
	 * @param destreza
	 */
	private void validarCaracteristicas(double velocidad, double fuerza, double resistencia, double destreza)
			throws CaracteristicaInvalidaEx {
		if (velocidad < 0 || fuerza < 0 || resistencia < 0 || destreza < 0)
			throw new CaracteristicaInvalidaEx("Uno o más atributos indicados no son válidos.");
	}

	/*
	 * @post setea el nombre de un personaje con uno dado.
	 * 
	 * @param nombrePersonaje
	 */
	private void setNombrePersonaje(String nombrePersonaje) throws NombreInvalidoEx {
		if (nombrePersonaje.isBlank() || nombrePersonaje.isEmpty() || nombrePersonaje == null)
			throw new NombreInvalidoEx("El nombre indicado no es válido.");
		this.nombrePersonaje = nombrePersonaje;
	}

	/*
	 * @post setea el nombre real con uno dado.
	 * 
	 * @param nombreReal.
	 */
	private void setNombreReal(String nombreReal) throws NombreInvalidoEx {
		if (nombreReal.isBlank() || nombreReal.isEmpty() || nombreReal == null)
			throw new NombreInvalidoEx("El nombre real indicado no es válido.");
		this.nombreReal = nombreReal;
	}

	public boolean empataCon(Competidor c2) {
		return (this.getVelocidad() == c2.getVelocidad()) && (this.getFuerza() == c2.getFuerza())
				&& (this.getResistencia() == c2.getResistencia()) && (this.getDestreza() == c2.getDestreza());
	}

}
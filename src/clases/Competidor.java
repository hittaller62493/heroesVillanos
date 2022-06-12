package clases;

import excepciones.*;

public abstract class Competidor {
	private int contador = 0;
	private String nombreReal;
	private String nombrePersonaje;
	private Atributo velocidad;
	private Atributo fuerza;
	private Atributo resistencia;
	private Atributo destreza;

	public Competidor(String nombreReal, String nombrePersonaje, double velocidad, double fuerza, double resistencia,
			double destreza) throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		setNombreReal(nombreReal);
		setNombrePersonaje(nombrePersonaje);
		setAtributos(velocidad, fuerza, resistencia, destreza);
	}

	public Competidor(String nombre) throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		setNombrePersonaje(nombre);
		setAtributos(0, 0, 0, 0);
	}

	public boolean esHeroe() {
		return this.getClass().equals(Heroe.class);
	}

	public int competir(Competidor competidor, Caracteristica caracteristica) throws MismoTipoCompetidorEx {

		if (this.esHeroe() == competidor.esHeroe()) {
			throw new MismoTipoCompetidorEx("No pueden competir personajes del mismo tipo.");
		}

		if (caracteristica.equals(Caracteristica.VELOCIDAD)) {
			ComparatorVelocidad compVel = new ComparatorVelocidad();
			resetearContador();
			return compVel.compare(this, competidor);
		}
		if (caracteristica.equals(Caracteristica.FUERZA)) {
			ComparatorFuerza compFue = new ComparatorFuerza();
			resetearContador();
			return compFue.compare(this, competidor);
		}
		if (caracteristica.equals(Caracteristica.RESISTENCIA)) {
			ComparatorResistencia compRes = new ComparatorResistencia();
			resetearContador();
			return compRes.compare(this, competidor);
		}
		if (caracteristica.equals(Caracteristica.DESTREZA)) {
			ComparatorDestreza compDes = new ComparatorDestreza();
			resetearContador();
			return compDes.compare(this, competidor);
		}

		return -2;

	}

	private void resetearContador() {
		contador = 0;
	}

	public void incrementarContador() {
		contador++;
	}

	public int getContador() {
		return contador;
	}

	public double getVelocidad() {
		return velocidad.getPuntos();
	}

	public double getFuerza() {
		return fuerza.getPuntos();
	}

	public double getResistencia() {
		return resistencia.getPuntos();
	}

	public double getDestreza() {
		return destreza.getPuntos();
	}

	public void incrementarVelocidad(double velocidad) {
		this.velocidad.incrementarPuntos(velocidad);
	}

	public void incrementarFuerza(double fuerza) {
		this.fuerza.incrementarPuntos(fuerza);
	}

	public void incrementarResistencia(double resistencia) {
		this.resistencia.incrementarPuntos(resistencia);
	}

	public void incrementarDestreza(double destreza) {
		this.destreza.incrementarPuntos(destreza);
	}

	public boolean esGanador(Competidor competidor, Caracteristica caracteristica) throws MismoTipoCompetidorEx {
		return (competir(competidor, caracteristica) == 1);
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	@Override
	public String toString() {
		return "Competidor [nombreReal=" + nombreReal + ", nombrePersonaje=" + nombrePersonaje + ", velocidad="
				+ velocidad + ", fuerza=" + fuerza + ", resistencia=" + resistencia + ", destreza=" + destreza + "]";
	}

	private void setAtributos(double velocidad, double fuerza, double resistencia, double destreza)
			throws CaracteristicaInvalidaEx {
		validarCaracteristicas(velocidad, fuerza, resistencia, destreza);
		this.velocidad = new Atributo(Caracteristica.VELOCIDAD, velocidad);
		this.fuerza = new Atributo(Caracteristica.FUERZA, fuerza);
		this.resistencia = new Atributo(Caracteristica.RESISTENCIA, resistencia);
		this.destreza = new Atributo(Caracteristica.DESTREZA, destreza);
	}

	private void validarCaracteristicas(double velocidad, double fuerza, double resistencia, double destreza)
			throws CaracteristicaInvalidaEx {
		if (velocidad < 0 || fuerza < 0 || resistencia < 0 || destreza < 0)
			throw new CaracteristicaInvalidaEx("Uno o más atributos indicados no son válidos.");
	}

	private void setNombrePersonaje(String nombrePersonaje) throws NombreInvalidoEx {
		if (nombrePersonaje.isBlank() || nombrePersonaje.isEmpty() || nombrePersonaje == null)
			throw new NombreInvalidoEx("El nombre indicado no es válido.");
		this.nombrePersonaje = nombrePersonaje;
	}

	private void setNombreReal(String nombreReal) throws NombreInvalidoEx {
		if (nombreReal.isBlank() || nombreReal.isEmpty() || nombreReal == null)
			throw new NombreInvalidoEx("El nombre real indicado no es válido.");
		this.nombreReal = nombreReal;
	}

}
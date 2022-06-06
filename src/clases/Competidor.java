package clases;

import java.util.List;
import java.util.ListIterator;

import excepciones.*;

import java.util.ArrayList;

public abstract class Competidor {
	private String nombreReal;
	private String nombrePersonaje;
	private List<Atributo> atributos = new ArrayList<Atributo>();


	public Competidor(String nombreReal, String nombrePersonaje, double velocidad, double fuerza, double resistencia,
			double destreza) {
		setNombreReal(nombreReal);
		setNombrePersonaje(nombrePersonaje);
		setAtributos(velocidad, fuerza, resistencia, destreza);
	}

	public boolean esHeroe() {
		return this.getClass().equals(Heroe.class);
	}

	private void setAtributos(double velocidad, double fuerza, double resistencia, double destreza) {
		validarCaracteristicas(velocidad, fuerza, resistencia, destreza);
		atributos.add(new Atributo(Caracteristica.VELOCIDAD, velocidad));
		atributos.add(new Atributo(Caracteristica.FUERZA, fuerza));
		atributos.add(new Atributo(Caracteristica.RESISTENCIA, resistencia));
		atributos.add(new Atributo(Caracteristica.DESTREZA, destreza));
	}

	private void validarCaracteristicas(double velocidad, double fuerza, double resistencia, double destreza) {
		if (velocidad < 0 || fuerza < 0 || resistencia < 0 || destreza < 0)
			throw new CaracteristicaInvalidaEx("Uno o más atributos indicados no son válidos.");
	}


	public Competidor(String nombre) {
		if (nombre.isBlank() || nombre.isEmpty() || nombre == null)
			throw new NombreInvalidoEx("El nombre indicado no es válido.");
		this.nombrePersonaje = nombre;
		atributos.add(new Atributo(Caracteristica.VELOCIDAD, 0));
		atributos.add(new Atributo(Caracteristica.FUERZA, 0));
		atributos.add(new Atributo(Caracteristica.RESISTENCIA, 0));
		atributos.add(new Atributo(Caracteristica.DESTREZA, 0));
	}

	public int competir(Competidor competidor, Caracteristica caracteristica) {
		if (this.esHeroe() == competidor.esHeroe()){
			throw new MismoTipoCompetidorEx("No pueden competir personajes del mismo tipo.");
		} 

		int index = getIndex(caracteristica);
		if (recorrerDesde(competidor, index) == 0){
			return recorrerDesde(competidor, 0);
		}		
		return (recorrerDesde(competidor, index));
	}

	public boolean esGanador(Competidor competidor, Caracteristica caracteristica) {
		return (competir(competidor, caracteristica) == 1);		
	}

	private int getIndex(Caracteristica c){
		int index = 0;
		ListIterator<Atributo> itrThis = atributos.listIterator();
		while (itrThis.hasNext()) {
			Atributo aux = itrThis.next();
			if (aux.getCaracteristica().equals(c)) {
				index = atributos.indexOf(aux);
			}
		}
		return index;
	}

	private int recorrerDesde(Competidor competidor, int index){
		int contador = 0;
		ListIterator<Atributo> itrThis = atributos.listIterator(index);
		ListIterator<Atributo> itrOther = competidor.atributos.listIterator(index);
		while (itrThis.hasNext() && contador != 4) {
			Atributo auxThis = itrThis.next();
			Atributo auxOther = itrOther.next();
			if (auxThis.compareTo(auxOther) == 0) {
				contador++;
			} else {
				return auxThis.compareTo(auxOther);
			}
		}
		return 0;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	private void setNombreReal(String nombreReal) {
		if (nombreReal.isBlank() || nombreReal.isEmpty() || nombreReal == null)
			throw new NombreInvalidoEx("El nombre real indicado no es válido.");
		this.nombreReal = nombreReal;
	}

	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	private void setNombrePersonaje(String nombrePersonaje) {
		if (nombrePersonaje.isBlank() || nombrePersonaje.isEmpty() || nombrePersonaje == null)
			throw new NombreInvalidoEx("El nombre de personaje indicado no es válido.");
		this.nombrePersonaje = nombrePersonaje;
	}
	public List<Atributo> getAtributos() {
		return atributos;
	}



	@Override
	public String toString() {
		return "Competidor [atributos=" + atributos + ", nombrePersonaje=" + nombrePersonaje + ", nombreReal="
				+ nombreReal + "]";
	}

}
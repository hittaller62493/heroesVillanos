
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public abstract class Competidor {
	private String nombreReal;
	private String nombrePersonaje;
	private List<Atributo> atributos = new ArrayList<Atributo>();
	

	public Competidor(String nombreReal, String nombrePersonaje, double velocidad, double fuerza, double resistencia,
			double destreza) {
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
		atributos.add(new Atributo(Caracteristica.VELOCIDAD, velocidad));
		atributos.add(new Atributo(Caracteristica.FUERZA, fuerza));
		atributos.add(new Atributo(Caracteristica.RESISTENCIA, resistencia));
		atributos.add(new Atributo(Caracteristica.DESTREZA, destreza));

	}
	public Competidor(String nombre) {
		this.nombrePersonaje = nombre;
		atributos.add(new Atributo(Caracteristica.VELOCIDAD, 0));
		atributos.add(new Atributo(Caracteristica.FUERZA, 0));
		atributos.add(new Atributo(Caracteristica.RESISTENCIA, 0));
		atributos.add(new Atributo(Caracteristica.DESTREZA, 0));
	}

	public int competir(Competidor competidor, Caracteristica caracteristica) {
		// if (this.getClass().equals(competidor.getClass())){
		// 	throw new Error("leo gato");
		// } EXCEPCIONES

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
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public String getNombrePersonaje() {
		return nombrePersonaje;
	}
	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}
	public List<Atributo> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
	@Override
	public String toString() {
		return "Competidor [atributos=" + atributos + ", nombrePersonaje=" + nombrePersonaje + ", nombreReal="
				+ nombreReal + "]";
	}

}
package clases;
import java.util.ArrayList;
import java.util.List;

import excepciones.TipoCompetidorInvalidoEx;

public class Liga extends Competidor {
	private List<Atributo> atribsSinPromediar = new ArrayList<Atributo>();
	private List<Competidor> competidores = new ArrayList<Competidor>();

	public Liga(String nombre) {
		super(nombre);
		atribsSinPromediar.add(new Atributo(Caracteristica.VELOCIDAD, 0));
		atribsSinPromediar.add(new Atributo(Caracteristica.FUERZA, 0));
		atribsSinPromediar.add(new Atributo(Caracteristica.RESISTENCIA, 0));
		atribsSinPromediar.add(new Atributo(Caracteristica.DESTREZA, 0));
	}


	public void addPersonaje(Competidor competidor) {

		if (competidores.isEmpty()) 
			competidores.add(competidor);
		else 
			if(esHeroe() == competidor.esHeroe())
				competidores.add(competidor);
			else
				throw new TipoCompetidorInvalidoEx("Los competidores deben ser del mismo tipo en cada Liga.");

		ajustarPromedio(competidor);

	}

	@Override
	public boolean esHeroe() {
		return this.competidores.get(0).esHeroe();
	}

	private void ajustarPromedio(Competidor competidor){
		sumarTotal(competidor);
		promediar();
	}

	private void sumarTotal(Competidor competidor){
		for (int i = 0; i < competidor.getAtributos().size(); i++) {
			atribsSinPromediar.get(i).incrementarPuntos(competidor.getAtributos().get(i).getPuntos());
		}
	}

	private void promediar(){
		for (int i = 0; i < atribsSinPromediar.size(); i++) {
			this.getAtributos().get(i).setPuntos(atribsSinPromediar.get(i).getPuntos() / competidores.size());
		}
	}


}

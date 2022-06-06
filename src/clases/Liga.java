package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.TipoCompetidorInvalidoEx;

public class Liga extends Competidor {
	private List<Competidor> competidores = new ArrayList<Competidor>();

	public Liga(String nombre) {
		super(nombre);
	}

	public void addPersonaje(Competidor competidor) {

		if (competidores.isEmpty())
			competidores.add(competidor);
		else if (esHeroe() == competidor.esHeroe())
			competidores.add(competidor);
		else
			throw new TipoCompetidorInvalidoEx("Los competidores deben ser del mismo tipo en cada Liga.");

		ajustarPromedio(competidor);

	}

	@Override
	public boolean esHeroe() {
		return this.competidores.get(0).esHeroe();
	}

	private void ajustarPromedio(Competidor competidor) {
		for (int i = 0; i < this.getAtributos().size(); i++) {
			double actual = this.getAtributos().get(i).getPuntos() * (competidores.size() - 1)
					+ competidor.getAtributos().get(i).getPuntos();
			this.getAtributos().get(i).setPuntos(actual / competidores.size());
		}

	}

}

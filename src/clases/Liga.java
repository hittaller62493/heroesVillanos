package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.MismoTipoCompetidorEx;
import excepciones.TipoCompetidorInvalidoEx;

public class Liga extends Competidor {
	private List<Competidor> competidores = new ArrayList<Competidor>();

	public Liga(String nombre) {
		super(nombre);
	}

	public void addPersonaje(Competidor competidor) {

		if (this.equals(competidor)) {
			throw new MismoTipoCompetidorEx("No es posible a�adir una liga a si misma");
		}

		if (competidores.isEmpty())
			competidores.add(competidor);
		else if (esHeroe() == competidor.esHeroe())
			competidores.add(competidor);
		else
			throw new TipoCompetidorInvalidoEx("Los competidores deben ser del mismo tipo en cada Liga.");

	}

	@Override
	public boolean esHeroe() {
		return this.competidores.get(0).esHeroe();
	}

	@Override
	public double getVelocidad() {
		double contador = 0;
		for (int i = 0; i < competidores.size(); i++) {
			contador += competidores.get(i).getVelocidad();
		}
		return contador / competidores.size();
	}

	@Override
	public double getFuerza() {
		double contador = 0;
		for (int i = 0; i < competidores.size(); i++) {
			contador += competidores.get(i).getFuerza();
		}

		return contador / competidores.size();
	}

	@Override
	public double getResistencia() {
		double contador = 0;
		for (int i = 0; i < competidores.size(); i++) {
			contador += competidores.get(i).getResistencia();
		}

		return contador / competidores.size();
	}

	@Override
	public double getDestreza() {
		double contador = 0;
		for (int i = 0; i < competidores.size(); i++) {
			contador += competidores.get(i).getDestreza();
		}

		return contador / competidores.size();
	}

	@Override
	public String toString() {
		return "liga =" + getNombrePersonaje() + ", velocidad=" + getVelocidad() + ", fuerza=" + getFuerza()
				+ ", resistencia=" + getResistencia() + ", destreza=" + getDestreza() + "]";
	}

}

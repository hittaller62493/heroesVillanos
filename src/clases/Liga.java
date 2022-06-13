package clases;

import java.util.ArrayList;
import java.util.List;

import excepciones.CaracteristicaInvalidaEx;
import excepciones.MismoTipoCompetidorEx;
import excepciones.NombreInvalidoEx;
import excepciones.TipoCompetidorInvalidoEx;
/*
 * Liga extension de competidor
 */
public class Liga extends Competidor {
	private List<Competidor> competidores = new ArrayList<Competidor>();

	/*
	 * @return una lista de competidores
	 */
	public List<Competidor> getCompetidores() {
		return competidores;
	}
	/*
	 * Crea una liga con un nombre.
	 * @param nombre
	 */
	public Liga(String nombre) throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		super(nombre);
	}

	/*@post añade los competidores dados.
	 *@param competidor.
	 */
	public void addCompetidor(Competidor competidor) throws TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
		validarCompetidor(competidor);

		if (competidores.isEmpty())
			competidores.add(competidor);
		else if (esHeroe() == competidor.esHeroe())
			competidores.add(competidor);
		else
			throw new TipoCompetidorInvalidoEx("Los competidores deben ser del mismo tipo en cada Liga.");

	}
	/*
	 * @return si el competidor es heroe o no.
	 */
	@Override
	public boolean esHeroe() {
		return this.competidores.get(0).esHeroe();
	}

	/*
	 * @return el valor de la velocidad.
	 */
	@Override
	public double getVelocidad() {
		double contador = 0;
		for (int i = 0; i < competidores.size(); i++) {
			contador += competidores.get(i).getVelocidad();
		}
		return contador / competidores.size();
	}
	/*
	 * @return el valor de la fuerza.
	 */
	@Override
	public double getFuerza() {
		double contador = 0;
		for (int i = 0; i < competidores.size(); i++) {
			contador += competidores.get(i).getFuerza();
		}

		return contador / competidores.size();
	}
	/*
	 * @return el valor de la resistencia.
	 */
	@Override
	public double getResistencia() {
		double contador = 0;
		for (int i = 0; i < competidores.size(); i++) {
			contador += competidores.get(i).getResistencia();
		}

		return contador / competidores.size();
	}

	/*
	 * @return el valor de la destreza.
	 */
	@Override
	public double getDestreza() {
		double contador = 0;
		for (int i = 0; i < competidores.size(); i++) {
			contador += competidores.get(i).getDestreza();
		}

		return contador / competidores.size();
	}
	/*
	 * @return los datos de la liga.
	 */
	@Override
	public String toString() {
		return "liga =" + getNombrePersonaje() + ", velocidad=" + getVelocidad() + ", fuerza=" + getFuerza()
				+ ", resistencia=" + getResistencia() + ", destreza=" + getDestreza() + "]";
	}

	/*
	 * @post valida el competidor dado.
	 * @param competidor
	 */
	private void validarCompetidor(Competidor competidor) throws MismoTipoCompetidorEx, TipoCompetidorInvalidoEx {
		if (this.equals(competidor)) {
			throw new MismoTipoCompetidorEx("No es posible a�adir una liga a si misma");
		}

		if (competidores.contains(competidor)) {
			throw new TipoCompetidorInvalidoEx("Este competidor ya se encuentra en la lista");
		}
	}

}

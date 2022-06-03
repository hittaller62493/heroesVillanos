import java.util.ArrayList;
import java.util.List;

public class Liga extends Competidor {
	private List<Competidor> competidores = new ArrayList<Competidor>();

	public Liga(String nombre) {
		super(nombre);
	}

	public void addPersonaje(Competidor competidor) {
		competidores.add(competidor);
		for (int i= 0; i< competidor.getAtributos().size(); i++) {
			this.getAtributos().get(i).incrementarPuntos(competidor.getAtributos().get(i).getPuntos());			
		}

	}

	@Override
	public int competir(Competidor competidor, Caracteristica caracteristica) {
		this.getAtributos();
		return super.competir(competidor, caracteristica);
	}

	

	
}

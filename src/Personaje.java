import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public abstract class Personaje implements Comparable<Personaje> {
	private String nombreReal;
	private String nombrePersonaje;

	private Map<Caracteristica, Integer> caracteristicas = new TreeMap<Caracteristica, Integer>();



	public Personaje(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
		caracteristicas.put(Caracteristica.VELOCIDAD, velocidad);
		caracteristicas.put(Caracteristica.FUERZA, fuerza);
		caracteristicas.put(Caracteristica.RESISTENCIA, resistencia);
		caracteristicas.put(Caracteristica.DESTREZA, destreza);
		
	}

	public int competir(Personaje o, Caracteristica c) {
		int resultado = 5;
		// while (resultado != 0) {
			// if (comparoCaracteristica(o, c) == 1) // Primero comparo contra la caracteristica para ver si gano
			// 	return 1;
			// if (comparoCaracteristica(o, c) == -1) // Segundo comparo contra la caracteristica para ver si pierdo
			// 	return -1;
			if (comparoCaracteristica(o, c) == 0) { // Tercero comparo contra otras caracteristicas porque hay empate
				int i = 0;
				System.out.println("Empieza el for --- ");
				for (Entry<Caracteristica, Integer> caracteristica : caracteristicas.entrySet()) { // Recorro caracteristica por caracteristica				
					System.out.println("Comparacion: "+ i + " -> " + caracteristica.getKey() + " => " + comparoCaracteristica(o, caracteristica.getKey())); // Comparo el personaje de Input contra la caracteristica que estoy recorriendo
					i++;
				}
			}

		// }
		return resultado;
	}

	public Personaje(String nombre) {
		this.nombrePersonaje = nombre;
	}

	public Integer comparoCaracteristica(Personaje o, Caracteristica c) {
		if (this.caracteristicas.get(c) > o.caracteristicas.get(c) ) {
			System.out.println(this.caracteristicas.get(c) + " es mayor que " + o.caracteristicas.get(c));
			return 1;
		}
			
		if (this.caracteristicas.get(c) < o.caracteristicas.get(c) ){
			System.out.println(this.caracteristicas.get(c) + " es menor que " + o.caracteristicas.get(c));
			return -1;
		}
		System.out.println(this.caracteristicas.get(c) + " es igual que " + o.caracteristicas.get(c));
		return 0;
	}
	@Override
	public int compareTo(Personaje o) {
		return 0;
	}

}
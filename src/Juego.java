import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Juego {
	public static void main(String[] args) {

		// BufferedReader lector = null;
		// try {
		// 	lector = new BufferedReader(new FileReader("personajes.in"));

		// } catch (IOException e) {
		// 	System.err.println(e);
		// } finally {
		// 	try {
        //         lector.close();
		// 	} catch (Exception e) {
		// 		System.err.println(e);
		// 	}
		// }

		Personaje heroe1 = new Heroe("HeroeReal", "Heroe", 100, 80, 80, 80);
		Personaje villano1 = new Villano("VillanoReal", "Villano", 100, 80, 80, 80); // EMPATE 0

		Personaje heroe2 = new Heroe("HeroeReal", "Heroe", 120, 80, 80, 80);
		Personaje villano2 = new Villano("VillanoReal", "Villano", 100, 80, 80, 80);


		System.out.println(heroe1.competir(villano1, Caracteristica.DESTREZA));
		System.out.println(heroe2.competir(villano2, Caracteristica.DESTREZA));


		

		// heroe1.competir(villano1, Caracteristica.FUERZA);
		

	}
}

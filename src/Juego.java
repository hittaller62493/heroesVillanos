import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Juego {
	// public void menu() {
    //     Scanner entrada = new Scanner(System.in);
    //     int opcion, opcionCombate;
    //     do {
    //         System.out.println("\t.:MENU:.");
    //         System.out.println("1. Añadir personajes");
    //         System.out.println("2. Añadir Ligas");
    //         System.out.println("3. Combates");
    //         System.out.println("Opcion: ");
    //         opcion = entrada.nextInt();
    //         switch (opcion) {
    //         case 1:
    //             // Aca va el añadir los personajes
    //             break;
    //         case 2:
    //             // aca va el añadir ligas
    //         case 3:
    //             do {
    //                 System.out.println("\t.:MENU COMBATE:.");
    //                 System.out.println("1. Personaje vs Personaje");
    //                 System.out.println("2. Personaje vs Liga");
    //                 System.out.println("3. Liga vs Liga");
    //                 opcionCombate = entrada.nextInt();
    //                 switch (opcionCombate) {
    //                 case 1:
    //                     // ACÁ VA EL COMBATE DE PERSONAJE VS PERSONAJE
    //                     break;
    //                 case 2:
    //                     // ACÁ VA EL COMBATE DE PERSONAJE VS LIGA
    //                     break;
    //                 case 3:
    //                     // ACA VA EL COMBATE DE LIGA VS LIGA
    //                     break;
    //                 }

    //             } while (opcionCombate != 3);

    //             break;
    //         }

    //     } while (opcion != 3);

    // }
	public static void main(String[] args) {
		// Juego juego = new Juego();
        // juego.menu();

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

		Competidor heroe1 = new Heroe("HeroeReal", "Heroe", 200, 100, 180, 100);
		Competidor heroe2 = new Heroe("HeroeReal", "Heroe", 200, 100, 280, 0);	
		Competidor heroe3 = new Heroe("HeroeReal", "Heroe", 400, 100, 380, 10);
		
        Competidor villano3 = new Villano("VillanoReal", "Villano", 100, 100, 280, 580 );
        Competidor villano1 = new Villano("VillanoReal", "Villano", 100, 50, 80, 80);
		Competidor villano2 = new Villano("VillanoReal", "Villano", 100, 565, 80, 80);
        Liga liga = new Liga("liga1");
        Liga ligaVillanos = new Liga("villanos");
		liga.addPersonaje(heroe1);
		liga.addPersonaje(heroe2);
		liga.addPersonaje(heroe3);
        ligaVillanos.addPersonaje(villano1);
        ligaVillanos.addPersonaje(villano2);
        ligaVillanos.addPersonaje(villano3);

		// System.out.println(heroe1.competir(villano1, Caracteristica.FUERZA));
		// System.out.println(heroe1.esGanador(villano1, Caracteristica.FUERZA));
		// System.out.println("---");
		// System.out.println(heroe2.competir(villano2, Caracteristica.DESTREZA));
		// System.out.println("---");
		// System.out.println(heroe2.competir(villano2, Caracteristica.VELOCIDAD));
		// System.out.println("---");
		// System.out.println(heroe3.competir(villano3, Caracteristica.VELOCIDAD));
		// System.out.println("---");
		// System.out.println(liga.competir(villano3, Caracteristica.VELOCIDAD));
        // System.out.println(liga.getAtributos().get(0).toString());
        // System.out.println(liga.getAtributos().get(1).toString());
        // System.out.println(liga.getAtributos().get(2).toString());
        // System.out.println(liga.getAtributos().get(3).toString());

        // System.out.println("----");
        // System.out.println(ligaVillanos.getAtributos().get(0).toString());
        // System.out.println(ligaVillanos.getAtributos().get(1).toString());
        // System.out.println(ligaVillanos.getAtributos().get(2).toString());
        // System.out.println(ligaVillanos.getAtributos().get(3).toString());

        // System.out.println(liga.competir(ligaVillanos, Caracteristica.DESTREZA));
        // System.out.println(liga.competir(ligaVillanos, Caracteristica.VELOCIDAD));
        System.out.println(villano1.competir(ligaVillanos, Caracteristica.DESTREZA));
	}
}

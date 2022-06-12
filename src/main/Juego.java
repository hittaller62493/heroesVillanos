package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import excepciones.*;
import clases.*;

public class Juego {

	public void menu() throws IOException {
		Scanner entrada = new Scanner(System.in);
		int opcion, opcionCombate;
		do {
			System.out.println("\t.:MENU:.");
			System.out.println("1. Añadir personajes");
			System.out.println("2. Añadir Ligas");
			System.out.println("3. Combates");
			System.out.println("4. Salir");
			System.out.println("Opción: ");
			opcion = entrada.nextInt();
			switch (opcion) {
				case 1:
					break;
				case 2:
					// aca va el añadir ligas
				case 3:
					do {
						System.out.println("\t.:MENU COMBATE:.");
						System.out.println("1. Personaje vs Personaje");
						System.out.println("2. Personaje vs Liga");
						System.out.println("3. Liga vs Liga");
						opcionCombate = entrada.nextInt();
						switch (opcionCombate) {
							case 1:
								// ACÁ VA EL COMBATE DE PERSONAJE VS PERSONAJE
								break;
							case 2:
								// ACÁ VA EL COMBATE DE PERSONAJE VS LIGA
								break;
							case 3:
								// ACA VA EL COMBATE DE LIGA VS LIGA
								break;
						}

					} while (opcionCombate != 3);

					break;
				case 4:
					System.exit(0);
					break;
			}

		} while (opcion != 3);

	}

	public static void main(String[] args) {
		Juego juego = new Juego();
		try {
			juego.menu();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}

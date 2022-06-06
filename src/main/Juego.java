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
                menuCargarArchivo();
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

    /**
	 * @throws IOException
     * @post: Carga el archivo desde la ruta especificada.
	 */
    private void menuCargarArchivo() throws IOException {

		Scanner entradaArchivo = new Scanner(System.in);
		try {
			System.out.println("## CARGAR Archivo \nPor favor indique la ruta del archivo:");
			String rutaArchivo = entradaArchivo.nextLine();
				if (!rutaArchivo.isEmpty()) {
					cargarArchivo(rutaArchivo);
				}
			} catch (LineaErroneaEx e) {
			System.err.println(e);
			}
    }

    public void cargarArchivo(String pArchivo) throws LineaErroneaEx, IOException {
		BufferedReader lector = new BufferedReader(new FileReader(pArchivo));
		
		try {
			String linea = lector.readLine();
			while (linea != null) {
				try {
					linea = linea.trim();
					if(linea.isEmpty() || linea.isBlank()) throw new LineaErroneaEx("La linea esta vacia.");
					crearCompetidor(linea);
				} catch(LineaErroneaEx e) {
					System.err.println(e);
				}
				System.out.println(linea);
				linea = lector.readLine();
			}
			System.out.println("----------------------------------\n Competidores cargados CORRECTAMENTE desde el archivo " + pArchivo + "\n----------------------------------\n");
		} catch (FileNotFoundException e) {
			System.err.println("La ruta especificada o el archivo no existen.");
		}catch(IOException e) {
			System.err.println(e);
		} finally {
			lector.close();
		}

	 }

    private Competidor crearCompetidor(String linea) throws LineaErroneaEx {

        Competidor competidor;
		
		linea = linea.trim();
		
		String[] etiquetaYvalor = linea.split(",");

		if(!etiquetaYvalor[0].toLowerCase().trim().equals("héroe") && !etiquetaYvalor[0].toLowerCase().trim().equals("heroe") && !etiquetaYvalor[0].toLowerCase().trim().equals("villano")) {
			throw new LineaErroneaEx("Competidor no cargado: tipo de competidor inválido.");}

		if(etiquetaYvalor[1].isEmpty() || etiquetaYvalor[1].isBlank()) {
				throw new LineaErroneaEx("Competidor no cargado: nombre real no encontrado.");}
		String nombreReal = etiquetaYvalor[1].trim();
		
		if(etiquetaYvalor[2].isEmpty() || etiquetaYvalor[2].isBlank()) {
				throw new LineaErroneaEx("Competidor no cargado: nombre de personaje no encontrado.");}
		String nombrePersonaje = etiquetaYvalor[2].trim();

		if(etiquetaYvalor[3].isEmpty() || etiquetaYvalor[3].isBlank()) {
				throw new LineaErroneaEx("Competidor no cargado: nombre no encontrada.");}
		int velocidad = Integer.parseInt(etiquetaYvalor[3].trim());

		if(etiquetaYvalor[4].isEmpty() || etiquetaYvalor[4].isBlank()) {
				throw new LineaErroneaEx("Competidor no cargado: fuerza no encontrada.");}
		int fuerza = Integer.parseInt(etiquetaYvalor[4].trim());

		if(etiquetaYvalor[5].isEmpty() || etiquetaYvalor[5].isBlank()) {
				throw new LineaErroneaEx("Competidor no cargado: resistencia no encontrada.");}
		int resistencia = Integer.parseInt(etiquetaYvalor[5].trim());

		if(etiquetaYvalor[6].isEmpty() || etiquetaYvalor[6].isBlank()) {
				throw new LineaErroneaEx("Competidor no cargado: destreza no encontrada.");}
		int destreza = Integer.parseInt(etiquetaYvalor[6].trim());
		
        if(etiquetaYvalor[0].toLowerCase().equals("héroe") || etiquetaYvalor[0].toLowerCase().equals("heroe"))
            competidor = new Heroe(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
        else
            competidor = new Villano(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);

		return competidor; 
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

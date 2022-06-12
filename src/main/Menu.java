package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import clases.*;
import excepciones.*;

public class Menu {

    Map<Integer, Competidor> mapaHeroes = new HashMap<Integer, Competidor>();
    Map<Integer, Competidor> mapaLigasHeroes = new HashMap<Integer, Competidor>();
    Map<Integer, Competidor> mapaVillanos = new HashMap<Integer, Competidor>();
    Map<Integer, Competidor> mapaLigasVillanos = new HashMap<Integer, Competidor>();
    int indiceHeroes, indiceVillanos, indiceLigasHeroes, indiceLigasVillanos;

    Set<Competidor> conjuntoCompetidores = new HashSet<>();

    TreeMap<Competidor, List<Caracteristica>> mapaGeneralizado = new TreeMap<Competidor, List<Caracteristica>>();

    public void menu3() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0, opcionCombate;
        do {
            try {
                System.out.println("\t.: Bienvenidos a Heroes y Villanos :.");
                System.out.println("1. Administracion de Personajes.");
                System.out.println("2. Administracion de Ligas.");
                System.out.println("3. Realizacion de combates.");
                System.out.println("4. Reportes.");
                System.out.print("Opcion: ");
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        menuAdministracionPersonajes();
                        break;
                    case 2:
                        menuAdministracionLigas();
                        break;
                    case 3:
                        menuCombates();
                        break;
                    case 4:
                        break;
                    case 5:
                        System.exit(0);

                }

            } catch (InputMismatchException | IOException e) {
                System.err.println("Opcion invalida. Por favor vuelva a ingresar numero de opción");
                entrada.next();
            }
        } while (opcion != 4);

        // Corregir cuando el input es una letra

    }

    private void menuAdministracionPersonajes() throws IOException {
        Scanner entradaM1 = new Scanner(System.in);
        int opcionM1 = 0;
        do {
            try {
                System.out.println("--Administracion de Personajes--");
                System.out.println("1. Carga desde archivo");
                System.out.println("2. Creacion de personaje");
                System.out.println("3. Listado de personajes");
                System.out.println("4. Guardar personajes en un archivo");
                System.out.println("5. Volver a menú principal");
                System.out.print("Opcion: ");
                opcionM1 = entradaM1.nextInt();
                switch (opcionM1) {
                    case 1:
                        menuCargarArchivo();
                        break;
                    case 2:
                        crearPersonajesMenu();
                        break;
                    case 3:
                        mostrarPersonajes();
                        break;
                    case 4:
                        guardarPersonajes();
                        break;
                    case 5:
                        break;

                }
            } catch (InputMismatchException e) {
                System.err.println("Opcion invalida. Por favor vuelva a ingresar numero de opción");

            }

        } while (opcionM1 != 5);
    }

    private void guardarPersonajes() {
        // TODO Auto-generated method stub

    }

    private void menuAdministracionLigas() throws IOException {
        Scanner entradaM2 = new Scanner(System.in);
        int opcionM2 = 0;
        do {
            try {
                System.out.println("--Administracion de Liga--");
                System.out.println("1. Carga desde archivo");
                System.out.println("2. Creacion de liga");
                System.out.println("3. Listado de ligas");
                System.out.println("4. Guardar ligas en un archivo");
                System.out.println("5. Volver a menú principal");
                System.out.print("Opcion: ");
                opcionM2 = entradaM2.nextInt();
                switch (opcionM2) {
                    case 1:
                        menuCargarArchivoParaLiga();
                        break;
                    case 2:
                        crearLigaMenu();
                        break;
                    case 3:
                        mostrarLigas();
                        break;
                    case 4:
                        guardarLigas();
                        break;
                    case 5:
                        break;

                }
            } catch (InputMismatchException e) {
                System.err.println("Opcion invalida. Por favor vuelva a ingresar numero de opción");
                entradaM2.next();
            }

        } while (opcionM2 != 5);
    }

    private void guardarLigas() {
        // TODO Auto-generated method stub

    }

    private void mostrarLigas() {
        mostrarLigasHeroes();
        mostrarLigasVillanos();

    }

    private void crearLigaMenu() {
        // TODO Auto-generated method stub

    }

    private void mostrarPersonajes() {

    }

    private void menuCombates() {
        Scanner scannerCombate = new Scanner(System.in);
        int opcionCombate = 0;
        do {
            System.out.println("\t.:MENU COMBATE:.");
            System.out.println("1. Personaje vs Personaje");
            System.out.println("2. Personaje vs Liga");
            System.out.println("3. Liga vs Liga");
            System.out.print("Opcion:");

            opcionCombate = scannerCombate.nextInt();
            switch (opcionCombate) {
                case 1:
                    competirPvP();
                    break;
                case 2:
                    menuLigaVCompetidor();
                    break;
                case 3:
                    competirLvL();
                    break;
            }

        } while (opcionCombate != 3);
    }

    private void menuLigaVCompetidor() {
        Scanner entradaMenuLiga = new Scanner(System.in);
        int opcionML = 0;
        do {
            System.out.println("-- Menu Liga vs Competidor --");
            System.out.println("1. Liga Heroe vs Liga Villano");
            System.out.println("2. Heroe vs Liga Villano");
            opcionML = entradaMenuLiga.nextInt();
            switch (opcionML) {
                case 1:
                    competirLHvV();
                    break;
                case 2:
                    competirHvLV();
                    break;
            }

        } while (opcionML != 3);

    }

    private void crearPersonajesMenu() {
        Scanner entradaCreacionPj = new Scanner(System.in);
        Competidor competidor = null;
        String nombreR, nombreP, tipoCompetidor;
        double velo, fuerza, resistencia, destreza;
        try {
            System.out.println();
            System.out.println("-.Digite correctamente los siguientes datos solicitados.-");
            System.out.println("-.Los atributos deben ser numericos y positivos.-");
            System.out.print("Héroe o Villano: ");
            tipoCompetidor = entradaCreacionPj.nextLine();
            System.out.print("Nombre real: ");
            nombreR = entradaCreacionPj.nextLine();
            System.out.print("Nombre del personaje: ");
            nombreP = entradaCreacionPj.nextLine();
            System.out.print("Velocidad: ");
            velo = entradaCreacionPj.nextDouble();
            System.out.print("Fuerza: ");
            fuerza = entradaCreacionPj.nextDouble();
            System.out.print("Resistencia: ");
            resistencia = entradaCreacionPj.nextDouble();
            System.out.print("Destreza: ");
            destreza = entradaCreacionPj.nextDouble();
            competidor = crearCompetidorCargarEnMapa(competidor, nombreR, nombreP, tipoCompetidor, velo, fuerza,
                    resistencia, destreza);

            conjuntoCompetidores.add(competidor);

            System.out.println("-# Personaje añadido correctamente #-");

        } catch (InputMismatchException e) {
            System.err.println("Datos ingresados incorrectos, vuelva a seleccionar una opción.");

        }

    }

    private Competidor crearCompetidorCargarEnMapa(Competidor competidor, String nombreR, String nombreP,
            String tipoCompetidor, double v, double f, double r, double d) {
        if (tipoCompetidor.toLowerCase().trim().equals("héroe") || tipoCompetidor.toLowerCase().trim().equals("heroe"))
            competidor = cargarHeroeEnMapa(nombreR, nombreP, v, f, r, d);
        else if (tipoCompetidor.toLowerCase().trim().equals("villano"))
            competidor = cargarVillanoEnMapa(nombreR, nombreP, v, f, r, d);
        else
            throw new LineaErroneaEx("El tipo debe ser Héroe o Villano");
        return competidor;
    }

    private Competidor cargarVillanoEnMapa(String nombreR, String nombreP, double v, double f, double r, double d) {
        Competidor competidor;
        competidor = new Villano(nombreR, nombreP, v, f, r, d);
        mapaVillanos.put(indiceVillanos, competidor);
        indiceVillanos++;
        return competidor;
    }

    private Competidor cargarHeroeEnMapa(String nombreR, String nombreP, double v, double f, double r, double d) {
        Competidor competidor;
        competidor = new Heroe(nombreR, nombreP, v, f, r, d);
        mapaHeroes.put(indiceHeroes, competidor);
        indiceHeroes++;
        return competidor;
    }

    /*
     * 
     * AGREGAR TRY CATCHS:
     * 
     * Exception in thread "main" java.lang.NullPointerException: Cannot invoke
     * "clases.Competidor.competir(clases.Competidor, clases.Caracteristica)"
     * because the return value of "main.Menu.buscarHeroe(String)" is null
     */
    private void competirPvP() {
        Scanner scanner = new Scanner(System.in);
        int nHeroe, nVillano;
        String nCaracteristica;
        try {
            System.out.println("Listado de Héroes -----------------");
            mostrarHeroes();
            System.out.println("Elegir Heroe:");
            nHeroe = scanner.nextInt();
            System.out.println("Listado de Villanos -----------------");
            mostrarVillanos();
            System.out.println("Elegir Villano: ");
            nVillano = scanner.nextInt();
            System.out.println("Elegir Característica para combatir: ");
            nCaracteristica = scanner.next();
            combatir(nHeroe, nVillano, buscarCaracteristica(nCaracteristica));
        } catch (InputMismatchException e) {
            System.err.print("Datos Incorrectos");
        }
    }

    private void competirLHvV() {
        Scanner scanner = new Scanner(System.in);
        int nLigaHeroe, nVillano;
        String nCaracteristica;
        try {
            System.out.println("Listado de Liga Héroes -----------------");
            mostrarLigasHeroes();
            System.out.println("Elegir Liga de Héroes:");
            nLigaHeroe = scanner.nextInt();
            System.out.println("Listado de Villanos -----------------");
            mostrarVillanos();
            System.out.println("Elegir Villano: ");
            nVillano = scanner.nextInt();
            System.out.println("Elegir Característica para combatir: ");
            nCaracteristica = scanner.next();
            combatirLHvV(nLigaHeroe, nVillano, buscarCaracteristica(nCaracteristica));
        } catch (InputMismatchException e) {
            System.err.print("Datos Incorrectos");
        }
    }

    private void competirHvLV() {
        Scanner scanner = new Scanner(System.in);
        int nHeroe, nLigaVillano;
        String nCaracteristica;
        try {
            System.out.println("Listado de Héroes -----------------");
            mostrarHeroes();
            System.out.println("Elegir Héroe:");
            nHeroe = scanner.nextInt();
            System.out.println("Listado Ligas de Villanos -----------------");
            mostrarLigasVillanos();
            System.out.println("Elegir Villano: ");
            nLigaVillano = scanner.nextInt();
            System.out.println("Elegir Característica para combatir: ");
            nCaracteristica = scanner.next();
            combatirHvLV(nHeroe, nLigaVillano, buscarCaracteristica(nCaracteristica));
        } catch (InputMismatchException e) {
            System.err.print("Datos Incorrectos");
        }
    }

    private void competirLvL() {
        Scanner scanner = new Scanner(System.in);
        int nLigaHeroe, nLigaVillano;
        String nCaracteristica;
        try {
            System.out.println("Listado Ligas de Héroes -----------------");
            mostrarLigasHeroes();
            System.out.println("Elegir Liga Héroes:");
            nLigaHeroe = scanner.nextInt();
            System.out.println("Listado Ligas de Villanos -----------------");
            mostrarLigasVillanos();
            System.out.println("Elegir Liga de Villano: ");
            nLigaVillano = scanner.nextInt();
            System.out.println("Elegir Característica para combatir: ");
            nCaracteristica = scanner.next();
            combatirLHvLV(nLigaHeroe, nLigaVillano, buscarCaracteristica(nCaracteristica));
        } catch (InputMismatchException e) {
            System.err.print("Datos Incorrectos");
        }
    }

    /*
     * Métodos para combatir
     */

    private void combatir(int nHeroe, int nVillano, Caracteristica nCaracteristica) {
        int resultado;
        resultado = buscarHeroe(nHeroe).competir(buscarVillano(nVillano), nCaracteristica);
        if (resultado == -1)
            System.out.println("Ganó " + mapaVillanos.get(nVillano).getNombrePersonaje());
        if (resultado == 0)
            System.out.println("Hubo empate entre " + mapaHeroes.get(nHeroe).getNombrePersonaje() + "y"
                    + mapaVillanos.get(nVillano).getNombrePersonaje());
        if (resultado == 1)
            System.out.println("Ganó Independiente: " + mapaHeroes.get(nHeroe).getNombrePersonaje());
    }

    private void combatirLHvV(int nLigaHeroe, int nVillano, Caracteristica nCaracteristica) {
        int resultado;
        resultado = buscarLigaHeroe(nLigaHeroe).competir(buscarVillano(nVillano), nCaracteristica);
        if (resultado == -1)
            System.out.println("Ganó " + mapaVillanos.get(nVillano).getNombrePersonaje());
        if (resultado == 0)
            System.out.println("Hubo empate entre " + mapaLigasHeroes.get(nLigaHeroe).getNombrePersonaje() + "y"
                    + mapaVillanos.get(nVillano).getNombrePersonaje());
        if (resultado == 1)
            System.out.println("Ganó Independiente: " + mapaLigasHeroes.get(nLigaHeroe).getNombrePersonaje());
    }

    private void combatirHvLV(int nHeroe, int nLigaVillano, Caracteristica nCaracteristica) {
        int resultado;
        resultado = buscarHeroe(nHeroe).competir(buscarVillano(nLigaVillano), nCaracteristica);
        if (resultado == -1)
            System.out.println("Ganó " + mapaLigasVillanos.get(nLigaVillano).getNombrePersonaje());
        if (resultado == 0)
            System.out.println("Hubo empate entre " + mapaHeroes.get(nHeroe).getNombrePersonaje() + "y"
                    + mapaVillanos.get(nLigaVillano).getNombrePersonaje());
        if (resultado == 1)
            System.out.println("Ganó Independiente: " + mapaHeroes.get(nHeroe).getNombrePersonaje());
    }

    private void combatirLHvLV(int nLigaHeroe, int nLigaVillano, Caracteristica nCaracteristica) {
        int resultado;
        resultado = buscarLigaHeroe(nLigaHeroe).competir(buscarLigaVillano(nLigaVillano), nCaracteristica);
        if (resultado == -1)
            System.out.println("Ganó " + mapaLigasVillanos.get(nLigaVillano).getNombrePersonaje());
        if (resultado == 0)
            System.out.println("Hubo empate entre " + mapaLigasHeroes.get(nLigaHeroe).getNombrePersonaje() + "y"
                    + mapaVillanos.get(nLigaVillano).getNombrePersonaje());
        if (resultado == 1)
            System.out.println("Ganó Independiente: " + mapaLigasHeroes.get(nLigaHeroe).getNombrePersonaje());
    }

    private Caracteristica buscarCaracteristica(String nCaracteristica) {
        validarInput(nCaracteristica);
        if (nCaracteristica.toLowerCase().trim().equals("velocidad"))
            return Caracteristica.VELOCIDAD;
        if (nCaracteristica.toLowerCase().trim().equals("fuerza"))
            return Caracteristica.FUERZA;
        if (nCaracteristica.toLowerCase().trim().equals("resistencia"))
            return Caracteristica.RESISTENCIA;
        if (nCaracteristica.toLowerCase().trim().equals("destreza"))
            return Caracteristica.DESTREZA;
        return null;
    }

    private void mostrarHeroes() {
        for (Entry<Integer, Competidor> competidor : mapaHeroes.entrySet()) {
            System.out.println(competidor.getKey() + " -> " + competidor.getValue().getNombrePersonaje());
        }
    }

    private void mostrarLigasHeroes() {
        for (Entry<Integer, Competidor> competidor : mapaLigasHeroes.entrySet()) {
            System.out.println(competidor.getKey() + " -> " + competidor.getValue().getNombrePersonaje());
        }
    }

    private void mostrarVillanos() {
        for (Entry<Integer, Competidor> competidor : mapaVillanos.entrySet()) {
            System.out.println(competidor.getKey() + " -> " + competidor.getValue().getNombrePersonaje());
        }
    }

    private void mostrarLigasVillanos() {
        for (Entry<Integer, Competidor> competidor : mapaLigasVillanos.entrySet()) {
            System.out.println(competidor.getKey() + " -> " + competidor.getValue().getNombrePersonaje());
        }
    }

    private Competidor buscarHeroe(int heroeBuscado) {
        return mapaHeroes.get(heroeBuscado);
    }

    private Competidor buscarLigaHeroe(int heroeBuscado) {
        return mapaLigasHeroes.get(heroeBuscado);
    }

    private Competidor buscarVillano(int villanoBuscado) {
        return mapaVillanos.get(villanoBuscado);
    }

    private Competidor buscarLigaVillano(int villanoBuscado) {
        return mapaLigasVillanos.get(villanoBuscado);
    }

    private void validarInput(String s) {
        if (s.isBlank() || s.isEmpty() || s == null || s.equals(null))
            throw new LineaErroneaEx("Los valores ingresados no son correctos.");
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

    /**
     * @throws IOException
     * @post: Carga el archivo desde la ruta especificada.
     */
    private void menuCargarArchivoParaLiga() throws IOException {

        Scanner entradaArchivo = new Scanner(System.in);
        try {
            System.out.println("## CARGAR Archivo \nPor favor indique la ruta del archivo:");
            String rutaArchivo = entradaArchivo.nextLine();
            if (!rutaArchivo.isEmpty()) {
                cargarArchivoParaLiga(rutaArchivo);
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
                    if (linea.isEmpty() || linea.isBlank())
                        throw new LineaErroneaEx("La linea esta vacia.");
                    crearCompetidorPorArchivo(linea);
                } catch (LineaErroneaEx e) {
                    System.err.println(e);
                }
                System.out.println(linea);
                linea = lector.readLine();
            }
            System.out.println(
                    "----------------------------------\n Competidores cargados CORRECTAMENTE desde el archivo "
                            + pArchivo + "\n----------------------------------\n");
        } catch (FileNotFoundException e) {
            System.err.println("La ruta especificada o el archivo no existen.");
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            lector.close();
        }

    }

    public void cargarArchivoParaLiga(String pArchivo) throws LineaErroneaEx, IOException {
        BufferedReader lector = new BufferedReader(new FileReader(pArchivo));

        try {
            String linea = lector.readLine();
            while (linea != null) {
                try {
                    linea = linea.trim();
                    if (linea.isEmpty() || linea.isBlank())
                        throw new LineaErroneaEx("La linea esta vacia.");
                    crearLigaPorArchivo(linea);
                } catch (LineaErroneaEx e) {
                    System.err.println(e);
                }
                System.out.println(linea);
                linea = lector.readLine();
            }
            System.out.println(
                    "----------------------------------\n Ligas cargadas CORRECTAMENTE desde el archivo "
                            + pArchivo + "\n----------------------------------\n");
        } catch (FileNotFoundException e) {
            System.err.println("La ruta especificada o el archivo no existen.");
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            lector.close();
        }

    }

    private Competidor crearCompetidorPorArchivo(String linea) throws LineaErroneaEx {

        Competidor competidor;

        linea = linea.trim();

        String[] lineaLeida = linea.split(",");

        if (!lineaLeida[0].toLowerCase().trim().equals("héroe")
                && !lineaLeida[0].toLowerCase().trim().equals("heroe")
                && !lineaLeida[0].toLowerCase().trim().equals("villano")) {
            throw new LineaErroneaEx("Competidor no cargado: tipo de competidor inválido.");
        }

        if (lineaLeida[1].isEmpty() || lineaLeida[1].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: nombre real no encontrado.");
        }
        String nombreR = lineaLeida[1].trim();

        if (lineaLeida[2].isEmpty() || lineaLeida[2].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: nombre de personaje no encontrado.");
        }
        String nombreP = lineaLeida[2].trim();

        if (lineaLeida[3].isEmpty() || lineaLeida[3].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: nombre no encontrada.");
        }
        int v = Integer.parseInt(lineaLeida[3].trim());

        if (lineaLeida[4].isEmpty() || lineaLeida[4].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: fuerza no encontrada.");
        }
        int f = Integer.parseInt(lineaLeida[4].trim());

        if (lineaLeida[5].isEmpty() || lineaLeida[5].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: resistencia no encontrada.");
        }
        int r = Integer.parseInt(lineaLeida[5].trim());

        if (lineaLeida[6].isEmpty() || lineaLeida[6].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: destreza no encontrada.");
        }
        int d = Integer.parseInt(lineaLeida[6].trim());

        if (lineaLeida[0].toLowerCase().equals("héroe") || lineaLeida[0].toLowerCase().equals("heroe"))
            competidor = cargarHeroeEnMapa(nombreR, nombreP, v, f, r, d);
        else
            competidor = cargarVillanoEnMapa(nombreR, nombreP, v, f, r, d);

        conjuntoCompetidores.add(competidor);

        return competidor;
    }

    private Liga crearLigaPorArchivo(String linea) throws LineaErroneaEx {

        Liga liga;

        linea = linea.trim();

        String[] lineaLeida = linea.split(",");

        if (lineaLeida[0].isEmpty() || lineaLeida[0].isBlank()) {
            throw new LineaErroneaEx("Liga no cargada: nombre no encontrado.");
        }
        String nombreLiga = lineaLeida[0].trim();

        liga = new Liga(nombreLiga);

        for (int i = 1; i < lineaLeida.length; i++) {
            if (lineaLeida[i].isEmpty() || lineaLeida[i].isBlank()) {
                throw new LineaErroneaEx("Competidor no cargado: nombre de personaje no encontrado.");
            }
            String nombrePersonaje = lineaLeida[i].trim();
            for (Competidor competidor : conjuntoCompetidores) {
                if (competidor.getNombrePersonaje().equals(nombrePersonaje))
                    liga.addCompetidor(competidor);
            }
        }
        if (liga.esHeroe()) {
            mapaLigasHeroes.put(indiceLigasHeroes, liga);
            indiceLigasHeroes++;
        } else {
            mapaLigasVillanos.put(indiceLigasVillanos, liga);
            indiceLigasVillanos++;
        }
        conjuntoCompetidores.add(liga);

        return liga;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.menu3();

    }
}

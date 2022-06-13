package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import clases.*;
import excepciones.*;

public class Menu {

    Map<Integer, Competidor> mapaHeroes = new HashMap<Integer, Competidor>();
    Map<Integer, Liga> mapaLigasHeroes = new HashMap<Integer, Liga>();
    Map<Integer, Competidor> mapaVillanos = new HashMap<Integer, Competidor>();
    Map<Integer, Liga> mapaLigasVillanos = new HashMap<Integer, Liga>();
    int indiceHeroes, indiceVillanos, indiceLigasHeroes, indiceLigasVillanos;

    Set<Competidor> conjuntoCompetidores = new HashSet<>();

    TreeMap<Competidor, List<Caracteristica>> mapaGeneralizado = new TreeMap<Competidor, List<Caracteristica>>();

    public void menu3() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                System.out.println("\t.: Bienvenidos a Heroes y Villanos :.");
                System.out.println("1. Administración de Personajes.");
                System.out.println("2. Administración de Ligas.");
                System.out.println("3. Realización de combates.");
                System.out.println("4. Reportes.");
                System.out.println("5. Salir del juego.");
                System.out.print("Opción numérica:  ");
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
                        menuReportes();
                        break;
                    case 5:
                        System.out.println("\t-=-=-=-=-=- [ \t G \t A \t M \t E \t O \t V \t E \t R ] -=-=-=-=-=-");
                        System.exit(0);

                }

            } catch (InputMismatchException | IOException | LineaErroneaEx | NombreInvalidoEx | CaracteristicaInvalidaEx
                    | MismoTipoCompetidorEx | TipoCompetidorInvalidoEx | NoExistenCompetidoresEx e) {
                System.err.println(" ==> Opción inválida. Por favor vuelva a ingresar número de opción <==\n");
                entrada.next();
            }
        } while (opcion != 5);

        // Corregir cuando el input es una letra

    }

    private void menuAdministracionPersonajes()
            throws IOException, LineaErroneaEx, NombreInvalidoEx, CaracteristicaInvalidaEx {
        Scanner entradaM1 = new Scanner(System.in);
        int opcionM1 = 0;
        String rutaNuevoArchivo = "";
        do {
            try {
                System.out.println("\n\t[ ADMINISTRACIÓN DE PERSONAJES ]");
                System.out.println("1. Carga desde archivo");
                System.out.println("2. Creacion de personaje");
                System.out.println("3. Listado de personajes");
                System.out.println("4. Guardar personajes en un archivo");
                System.out.println("5. <== Volver a menú anterior");
                System.out.print("Opción numérica:  ");
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
                        System.out.println("\n\t [ GUARDAR COMPETIDORES ]");
                        System.out.println("Escriba la ruta del nuevo archivo: ");
                        rutaNuevoArchivo = entradaM1.next();
                        guardarPersonajes(rutaNuevoArchivo);
                        break;
                    case 5:
                        break;

                }
            } catch (InputMismatchException e) {
                System.err.println(" ==> Opción inválida. Por favor vuelva a ingresar número de opción <==\n");
                entradaM1.next();
            }

        } while (opcionM1 != 5);
    }

    private void guardarPersonajes(String nuevoArchivo) throws IOException {
        guardarCompetidores(nuevoArchivo);

    }

    private void menuAdministracionLigas() throws IOException, NombreInvalidoEx, CaracteristicaInvalidaEx,
            TipoCompetidorInvalidoEx, MismoTipoCompetidorEx, NoExistenCompetidoresEx {
        try {
            validarQueExistenCompetidores();
            Scanner entradaM2 = new Scanner(System.in);
            int opcionM2 = 0;
            String rutaNuevoArchivo = "";
            do {
                try {
                    System.out.println("\n\t[ ADMINISTRACIÓN DE LIGAS ]");
                    System.out.println("1. Carga desde archivo");
                    System.out.println("2. Creacion de liga");
                    System.out.println("3. Listado de ligas");
                    System.out.println("4. Guardar ligas en un archivo");
                    System.out.println("5. <== Volver a menú anterior");
                    System.out.print("Opción numérica:  ");
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
                            System.out.println("\n\t [ GUARDAR LIGAS ]");
                            System.out.println("Escriba la ruta del nuevo archivo: ");
                            rutaNuevoArchivo = entradaM2.next();
                            guardarLigas(rutaNuevoArchivo);
                            break;
                        case 5:
                            break;

                    }
                } catch (InputMismatchException e) {
                    System.err.println(" ==> Opción inválida. Por favor vuelva a ingresar número de opción <==\n");
                    entradaM2.next();
                }

            } while (opcionM2 != 5);
        } catch (NoExistenCompetidoresEx e) {
            System.err.println(e);
        }
    }

    private void validarQueExistenCompetidores() throws NoExistenCompetidoresEx {
        if (conjuntoCompetidores.isEmpty())
            throw new NoExistenCompetidoresEx(
                    "Se deben CARGAR o CREAR Competidores antes de ingresar a esta opción.\n");
    }

    private void guardarLigas(String rutaNuevoArchivo) throws IOException {
        guardarLigasCompetidores(rutaNuevoArchivo);

    }

    /**
     * Guarda la lista de ligas completa en disco, en el archivo especificado como
     * parámetro
     * Con el siguiente formato. Una línea por competidor:
     * NombreLiga, Competidor/Liga A, Competidor/Liga B, etc.
     * 
     * @param pArchivo nombre del archivo (path absoluto o relativo
     *                 a la carpeta src del proyecto
     */

    private void guardarLigasCompetidores(String pArchivo) throws IOException {
        FileWriter guardador = null;
        try {
            guardador = new FileWriter(pArchivo);
            for (Map.Entry<Integer, Liga> liga : mapaLigasHeroes.entrySet()) {
                System.out.println("GUARDANDO Liga: " + liga.getValue().getNombrePersonaje());
                guardador.write(serializarLiga(liga.getValue()));
            }
            for (Map.Entry<Integer, Liga> liga : mapaLigasVillanos.entrySet()) {
                System.out.println("GUARDANDO Liga: " + liga.getValue().getNombrePersonaje());
                guardador.write(serializarLiga((Liga) liga.getValue()));
            }

            guardador.close();
            System.out.println(
                    "----------------------------------\n Los competidores se guardaron CORRECTAMENTE en el archivo "
                            + pArchivo + "\n----------------------------------\n");
        } catch (FileNotFoundException e) {
            System.err.println("La ruta especificada o el archivo no existen.");
        } catch (IOException e) {
            System.err.println("Ocurri� un error intentando guardar el archivo archivo");
        } finally {
            guardador.close();
        }

    }

    /**
     * @post: Serializa los datos de la persona que se ingresa.
     * @return
     */
    public String serializarLiga(Liga c) {
        String personajes = "";
        for (Competidor competidor : c.getCompetidores()) {
            personajes = personajes + ", " + competidor.getNombrePersonaje();
        }

        return c.getNombrePersonaje() + personajes + "\n";

    }

    private void mostrarLigas() {
        mostrarLigasHeroes();
        mostrarLigasVillanos();

    }

    private void crearLigaMenu() {
        Scanner entradaCreacionLiga = new Scanner(System.in);
        Liga liga = null;
        String nombreLiga;
        int opcionMenuLiga = 0;
        try {
            System.out.println("\n\t [ CREAR LIGA ]");
            System.out.println("# Tipee correctamente los siguientes datos solicitados.");
            System.out.println("# Una vez creada, por favor añada competidores a la misma.");
            System.out.print("Nombre de Liga: ");
            nombreLiga = entradaCreacionLiga.nextLine();
            liga = new Liga(nombreLiga);
            System.out.println("\n\t [ Añadir Competidores a la Liga ]");
            System.out.println("Seleccione tipo de Liga de Héroes o Villanos: ");
            System.out.println("1. Liga de Héroes");
            System.out.println("2. Liga de Villanos");
            opcionMenuLiga = entradaCreacionLiga.nextInt();
            switch (opcionMenuLiga) {
                case 1:
                    cargarHeroesALiga(liga);
                    break;
                case 2:
                    cargarVillanosALiga(liga);
                    break;
                case 3:
                    break;

            }

            System.out.println("\n\t#### Liga añadida CORRECTAMENTE ####");

        } catch (InputMismatchException | NombreInvalidoEx | CaracteristicaInvalidaEx e) {
            System.err.println("Datos ingresados incorrectamente. Vuelva a seleccionar una opción.");

        }

    }

    private void cargarHeroesALiga(Liga liga) {
        Scanner cargaHeroesALiga = new Scanner(System.in);
        int seleccionHeroe;
        boolean cargaLiga = true;
        try {
            do {
                try {
                    System.out.println("\n\t [ Héroes disponibles para agregar a la Liga # " + liga.getNombrePersonaje()
                            + " # ]\n");
                    mostrarHeroes();
                    System.out.println("\n ==> Seleccione un héroe con opción numérica o escriba -1 para salir");
                    seleccionHeroe = cargaHeroesALiga.nextInt();
                    if (seleccionHeroe == -1) {
                        cargaLiga = false;
                    } else {
                        liga.addCompetidor(buscarHeroe(seleccionHeroe));
                        System.out.println("#- Competidor añadido correctamente -#");
                    }

                } catch (TipoCompetidorInvalidoEx | MismoTipoCompetidorEx e) {
                    System.err.println("Este competidor ya se encuentra en la liga.");
                }
            }

            while (cargaLiga);

            mapaLigasHeroes.put(indiceLigasHeroes, liga);
            indiceLigasHeroes++;
            conjuntoCompetidores.add(liga);

        } catch (InputMismatchException e) {
            System.err.println(e);
        }
    }

    private void cargarVillanosALiga(Liga liga) {
        Scanner cargaVillanosALiga = new Scanner(System.in);
        int seleccionVillano;
        boolean cargaLiga = true;
        try {

            do {
                try {
                    System.out.println("\n\t [ Villanos disponibles para agregar a la Liga # "
                            + liga.getNombrePersonaje() + " # ]\n");
                    mostrarVillanos();
                    System.out.println("\n ==> Seleccione un villano con opción numérica o escriba -1 para salir");
                    seleccionVillano = cargaVillanosALiga.nextInt();
                    if (seleccionVillano == -1) {
                        cargaLiga = false;
                    } else {
                        liga.addCompetidor(buscarVillano(seleccionVillano));
                        System.out.println("#- Competidor añadido correctamente -#");
                    }

                } catch (TipoCompetidorInvalidoEx | MismoTipoCompetidorEx e) {
                    System.err.println("Este competidor ya se encuentra en la liga.");
                }
            }

            while (cargaLiga);

            mapaLigasVillanos.put(indiceLigasVillanos, liga);
            indiceLigasVillanos++;
            conjuntoCompetidores.add(liga);

        } catch (InputMismatchException e) {
            System.err.println(e);
        }
    }

    private void mostrarPersonajes() {
        System.out.println("\n\t -------- [Lista de Competidores] --------\n");
        System.out.println("\t [Lista de Héroes]\n");
        mostrarHeroes();
        System.out.println("\n\t [Lista de Villanos]\n");
        mostrarVillanos();
        System.out.println("\t-----------------------------------------");
    }

    private void menuCombates() throws MismoTipoCompetidorEx, LineaErroneaEx {
        Scanner scannerCombate = new Scanner(System.in);
        int opcionCombate = 0;
        try {
            validarQueExistenCompetidores();

            do {
                System.out.println("\n\t [ MENU DE COMBATE ]");
                System.out.println("1. Personaje vs Personaje");
                System.out.println("2. Personaje vs Liga");
                System.out.println("3. Liga vs Liga");
                System.out.println("4. <== Volver a menú anterior");
                System.out.print("Opción numérica: ");

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
                    case 4:
                        break;
                }

            } while (opcionCombate != 4);
        } catch (NoExistenCompetidoresEx e) {
            System.err.println(e);
        }
    }

    private void menuLigaVCompetidor() throws MismoTipoCompetidorEx, LineaErroneaEx {
        Scanner entradaMenuLiga = new Scanner(System.in);
        int opcionML = 0;
        do {
            System.out.println("\n\t [ LIGA vs COMPETIDOR ]");
            System.out.println("1. Liga Heroe vs Villano");
            System.out.println("2. Heroe vs Liga Villano");
            System.out.println("3. <== Volver a menú anterior");
            opcionML = entradaMenuLiga.nextInt();
            switch (opcionML) {
                case 1:
                    competirLHvV();
                    break;
                case 2:
                    competirHvLV();
                    break;
                case 3:
                    break;
            }

        } while (opcionML != 3);

    }

    private void crearPersonajesMenu() throws LineaErroneaEx, NombreInvalidoEx, CaracteristicaInvalidaEx {
        Scanner entradaCreacionPj = new Scanner(System.in);
        Competidor competidor = null;
        String nombreR, nombreP, tipoCompetidor;
        double velo, fuerza, resistencia, destreza;
        try {
            System.out.println("\n\t [ CREAR PERSONAJE ]");
            System.out.println("# Tipee correctamente los siguientes datos solicitados.");
            System.out.println("# Los atributos deben ser numéricos y positivos.");
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

    private void menuReportes() throws LineaErroneaEx, MismoTipoCompetidorEx {
        Scanner entradaMenuReportes = new Scanner(System.in);
        int opcionR = 0;
        try {
            validarQueExistenCompetidores();
            do {
                System.out.println("\n\t [ MENU DE REPORTES ]");
                System.out.println("1. Vencedores a un Personaje ");
                System.out.println("2. Listado ordenado de competidores por características");
                System.out.println("3. <== Volver al menu anterior");

                opcionR = entradaMenuReportes.nextInt();
                switch (opcionR) {
                    case 1:
                        menuDeVencedores();
                        break;
                    case 2:
                        menuDeCompetidoresOrdenados();
                        break;
                    case 3:
                        break;
                }

            } while (opcionR != 3);
        } catch (NoExistenCompetidoresEx e) {
            System.err.println(e);
        }

    }

    private void menuDeCompetidoresOrdenados() {
        Scanner entradaMenuCompetidoresOrdenados = new Scanner(System.in);
        // String tipoCompetidor;
        // Competidor competidorAVencer = null;
        // String caracteristica;
        Caracteristica caracteristicaUno = null;
        Caracteristica caracteristicaDos = null;
        int opcionMVO = 0;

        System.out.println("\n Seleccione la PRIMER característica para ordenar");
        System.out.println("1. Velocidad");
        System.out.println("2. Fuerza");
        System.out.println("3. Resistencia");
        System.out.println("4. Destreza");
        opcionMVO = entradaMenuCompetidoresOrdenados.nextInt();
        switch (opcionMVO) {
            case 1:
                caracteristicaUno = Caracteristica.VELOCIDAD;
                System.out.println("\n # La primer característica seleccionada es: " + caracteristicaUno); {
                break;
            }
            case 2:
                caracteristicaUno = Caracteristica.FUERZA;
                System.out.println("\n # La primer característica seleccionada es: " + caracteristicaUno); {
                break;
            }
            case 3:
                caracteristicaUno = Caracteristica.RESISTENCIA;
                System.out.println("\n # La primer característica seleccionada es: " + caracteristicaUno); {
                break;
            }
            case 4:
                caracteristicaUno = Caracteristica.DESTREZA;
                System.out.println("\n # La primer característica seleccionada es: " + caracteristicaUno); {
                break;
            }
            case 5:
                break;
        }
        System.out.println("\n Seleccione la SEGUNDA característica para ordenar");
        System.out.println("1. Velocidad");
        System.out.println("2. Fuerza");
        System.out.println("3. Resistencia");
        System.out.println("4. Destreza");
        opcionMVO = entradaMenuCompetidoresOrdenados.nextInt();
        switch (opcionMVO) {
            case 1:
                caracteristicaDos = Caracteristica.VELOCIDAD;
                System.out.println("\n #La primer característica seleccionada es: " + caracteristicaDos); {
                break;
            }
            case 2:
                caracteristicaDos = Caracteristica.FUERZA;
                System.out.println("\n #La primer característica seleccionada es: " + caracteristicaDos); {
                break;
            }
            case 3:
                caracteristicaDos = Caracteristica.RESISTENCIA;
                System.out.println("\n #La primer característica seleccionada es: " + caracteristicaDos); {
                break;
            }
            case 4:
                caracteristicaDos = Caracteristica.DESTREZA;
                System.out.println("\n # La primer característica seleccionada es: " + caracteristicaDos); {
                break;
            }
            case 5:
                break;
        }
        System.out.println("\n\t [Seleccionar orden Descendente o Ascendente]");
        System.out.println("1. Mayor a menor");
        System.out.println("2. Menor a mayor");
        opcionMVO = entradaMenuCompetidoresOrdenados.nextInt();
        switch (opcionMVO) {
            case 1:
                System.out.println("\n==> LISTADO ORDENADO DE PERSONAJES POR " + caracteristicaUno + ", "
                        + caracteristicaDos + " --");
                ordenarPorCaracteristicasDescendente(caracteristicaUno, caracteristicaDos);
                break;

            case 2:
                System.out.println("\n==> LISTADO ORDENADO DE PERSONAJES POR " + caracteristicaUno + ", "
                        + caracteristicaDos + " --");
                ordenarPorCaracteristicasAscendente(caracteristicaUno, caracteristicaDos);
                break;
        }

    }

    private void ordenarPorCaracteristicasAscendente(Caracteristica caracteristicaUno,
            Caracteristica caracteristicaDos) {

        PriorityQueue<Competidor> cola = new PriorityQueue<Competidor>(
                new OrdenadorCaracteristicaAscendente(caracteristicaUno, caracteristicaDos));
        for (Competidor competidor : conjuntoCompetidores) {
            cola.add(competidor);
        }

        while (!cola.isEmpty()) {
            Competidor aux = cola.poll();
            double c1 = aux.getCaracteristica(caracteristicaUno);
            double c2 = aux.getCaracteristica(caracteristicaDos);
            System.out.println("- " + aux.getNombrePersonaje() + ", " + caracteristicaUno + ": " + c1 + ", "
                    + caracteristicaDos + ": " + c2);
        }
    }

    private void ordenarPorCaracteristicasDescendente(Caracteristica caracteristicaUno,
            Caracteristica caracteristicaDos) {

        PriorityQueue<Competidor> cola = new PriorityQueue<Competidor>(
                new OrdenadorCaracteristicaDescendente(caracteristicaUno, caracteristicaDos));
        for (Competidor competidor : conjuntoCompetidores) {
            cola.add(competidor);
        }

        while (!cola.isEmpty()) {
            Competidor aux = cola.poll();
            double c1 = aux.getCaracteristica(caracteristicaUno);
            double c2 = aux.getCaracteristica(caracteristicaDos);
            System.out.println("- " + aux.getNombrePersonaje() + ", " + caracteristicaUno + ": " + c1 + ", "
                    + caracteristicaDos + ": " + c2);
        }
    }

    private void menuDeVencedores() throws LineaErroneaEx {
        Scanner entradaMenuVencedores = new Scanner(System.in);
        Competidor competidorAVencer = null;
        String caracteristica;
        Caracteristica carac;
        int opcionML = 0;

        System.out.println("\n\t [Seleccionar Tipo de Competidor a Vencer]");
        System.out.println("1. Liga");
        System.out.println("2. Competidor");
        opcionML = entradaMenuVencedores.nextInt();
        switch (opcionML) {
            case 1:
                competidorAVencer = seleccionLiga(entradaMenuVencedores);
                System.out.println("\n#- Liga seleccionada con éxito -#");
                System.out.println("\n-- Seleccione la característica para empezar a combatir --");
                caracteristica = entradaMenuVencedores.next();
                carac = buscarCaracteristica(caracteristica);
                System.out.println("\n-- La característica seleccionada es: " + carac + " --");
                vencedoresA(competidorAVencer, carac);
                break;
            case 2:
                competidorAVencer = seleccionCompetidor(entradaMenuVencedores);
                System.out.println("\n#- Competidor seleccionado con éxito -#");
                System.out.println("\n-- Seleccione la característica para empezar a combatir --");
                caracteristica = entradaMenuVencedores.next();
                carac = buscarCaracteristica(caracteristica);
                System.out.println("\n-- La característica seleccionada es: " + carac + " --");
                vencedoresA(competidorAVencer, carac);
                break;
            case 3:
                break;
        }

    }

    private void vencedoresA(Competidor competidorAVencer, Caracteristica carac) {
        System.out.println("\n Los siguientes competidores vencen a " + competidorAVencer.getNombrePersonaje()
                + " por la característica " + carac + ": \n");
        for (Competidor competidor : conjuntoCompetidores) {
            try {
                if (competidor.esGanador(competidorAVencer, carac)) {
                    System.out.println("-> " + competidor.getNombrePersonaje());
                }
            } catch (MismoTipoCompetidorEx e) {
            }
        }
    }

    private Competidor seleccionCompetidor(Scanner entradaMenuVencedores) {
        Competidor competidorAVencer = null;
        int subComp = 0;

        System.out.println("\n\t [Selección de Tipo de Competidor]");
        System.out.println("1. Héroe");
        System.out.println("2. Villano");
        subComp = entradaMenuVencedores.nextInt();
        switch (subComp) {
            case 1:
                mostrarHeroes();
                System.out.println("\nIndique Héroe a Vencer (opción numérica): ");
                subComp = entradaMenuVencedores.nextInt();
                competidorAVencer = buscarHeroe(subComp);
                break;
            case 2:
                mostrarVillanos();
                System.out.println("\nIndique Villano a Vencer (opción numérica): ");
                subComp = entradaMenuVencedores.nextInt();
                competidorAVencer = buscarVillano(subComp);
                break;
            case 3:
                break;
        }
        return competidorAVencer;

    }

    private Competidor seleccionLiga(Scanner entradaMenuVencedores) {
        Competidor competidorAVencer = null;
        int subLiga = 0;

        System.out.println("\n\t [Selección de Tipo Liga]");
        System.out.println("1. Liga de Heroes");
        System.out.println("2. Liga de Villanos");
        subLiga = entradaMenuVencedores.nextInt();
        switch (subLiga) {
            case 1:
                mostrarLigasHeroes();
                System.out.println("\nIndique Liga a Vencer (opción numérica): ");
                subLiga = entradaMenuVencedores.nextInt();
                competidorAVencer = buscarLigaHeroe(subLiga);
                break;
            case 2:
                mostrarLigasVillanos();
                System.out.println("\nIndique Liga a Vencer (opción numérica): ");
                subLiga = entradaMenuVencedores.nextInt();
                competidorAVencer = buscarLigaVillano(subLiga);
                break;
        }
        return competidorAVencer;
    }

    private Competidor crearCompetidorCargarEnMapa(Competidor competidor, String nombreR, String nombreP,
            String tipoCompetidor, double v, double f, double r, double d)
            throws LineaErroneaEx, NombreInvalidoEx, CaracteristicaInvalidaEx {
        if (competidorEsHeroe(tipoCompetidor))
            competidor = cargarHeroeEnMapa(nombreR, nombreP, v, f, r, d);
        else if (competidorEsVillano(tipoCompetidor))
            competidor = cargarVillanoEnMapa(nombreR, nombreP, v, f, r, d);
        else
            throw new LineaErroneaEx("El tipo debe ser Héroe o Villano \n");
        return competidor;
    }

    private boolean competidorEsVillano(String tipoCompetidor) {
        return tipoCompetidor.toLowerCase().trim().equals("villano");
    }

    private boolean competidorEsHeroe(String tipoCompetidor) {
        return tipoCompetidor.toLowerCase().trim().equals("héroe")
                || tipoCompetidor.toLowerCase().trim().equals("heroe");
    }

    private Competidor cargarVillanoEnMapa(String nombreR, String nombreP, double v, double f, double r, double d)
            throws NombreInvalidoEx, CaracteristicaInvalidaEx {
        Competidor competidor;
        competidor = new Villano(nombreR, nombreP, v, f, r, d);
        mapaVillanos.put(indiceVillanos, competidor);
        indiceVillanos++;
        return competidor;
    }

    private Competidor cargarHeroeEnMapa(String nombreR, String nombreP, double v, double f, double r, double d)
            throws NombreInvalidoEx, CaracteristicaInvalidaEx {
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
    private void competirPvP() throws MismoTipoCompetidorEx, LineaErroneaEx {
        Scanner scanner = new Scanner(System.in);
        int nHeroe, nVillano;
        String nCaracteristica;
        try {
            System.out.println("\n\t [ LISTADO DE HÉROES ]\n");
            mostrarHeroes();
            System.out.println("\n# Elegir HÉROE:\n");
            nHeroe = scanner.nextInt();
            System.out.println("\n\t [ LISTADO DE VILLANOS ]\n");
            mostrarVillanos();
            System.out.println("\n# Elegir VILLANO: \n");
            nVillano = scanner.nextInt();
            System.out.println("\n# Elegir Característica para combatir: ");
            nCaracteristica = scanner.next();
            combatir(nHeroe, nVillano, buscarCaracteristica(nCaracteristica));
        } catch (InputMismatchException e) {
            System.err.print("Datos Incorrectos");
        }
    }

    private void competirLHvV() throws MismoTipoCompetidorEx, LineaErroneaEx {
        Scanner scanner = new Scanner(System.in);
        int nLigaHeroe, nVillano;
        String nCaracteristica;
        try {

            mostrarLigasHeroes();
            System.out.println("\n# Elegir LIGA de HÉROES:\n");
            nLigaHeroe = scanner.nextInt();
            System.out.println("\n\t [ LISTADO DE VILLANOS ]\n");
            mostrarVillanos();
            System.out.println("\n# Elegir VILLANO:\n");
            nVillano = scanner.nextInt();
            System.out.println("\n# Elegir Característica para combatir: ");
            nCaracteristica = scanner.next();
            combatirLHvV(nLigaHeroe, nVillano, buscarCaracteristica(nCaracteristica));
        } catch (InputMismatchException e) {
            System.err.print("Datos Incorrectos");
        }
    }

    private void competirHvLV() throws MismoTipoCompetidorEx, LineaErroneaEx {
        Scanner scanner = new Scanner(System.in);
        int nHeroe, nLigaVillano;
        String nCaracteristica;
        try {
            mostrarHeroes();
            System.out.println("\n# Elegir HÉROE:\n");
            nHeroe = scanner.nextInt();
            mostrarLigasVillanos();
            System.out.println("\n# Elegir LIGA de VILLANOS:\n");
            nLigaVillano = scanner.nextInt();
            System.out.println("\n# Elegir Característica para combatir: ");
            nCaracteristica = scanner.next();
            combatirHvLV(nHeroe, nLigaVillano, buscarCaracteristica(nCaracteristica));
        } catch (InputMismatchException e) {
            System.err.print("Datos Incorrectos");
        }
    }

    private void competirLvL() throws MismoTipoCompetidorEx, LineaErroneaEx {
        Scanner scanner = new Scanner(System.in);
        int nLigaHeroe, nLigaVillano;
        String nCaracteristica;
        try {
            mostrarLigasHeroes();
            System.out.println("\n# Elegir LIGA de HÉROES: \n");
            nLigaHeroe = scanner.nextInt();
            mostrarLigasVillanos();
            System.out.println("\n# Elegir LIGA de VILLANOS:\n");
            nLigaVillano = scanner.nextInt();
            System.out.println("\n# Elegir Característica para combatir: ");
            nCaracteristica = scanner.next();
            combatirLHvLV(nLigaHeroe, nLigaVillano, buscarCaracteristica(nCaracteristica));
        } catch (InputMismatchException e) {
            System.err.print("Datos Incorrectos");
        }
    }

    /*
     * Métodos para combatir
     */

    private void combatir(int nHeroe, int nVillano, Caracteristica nCaracteristica) throws MismoTipoCompetidorEx {
        int resultado;
        resultado = buscarHeroe(nHeroe).competir(buscarVillano(nVillano), nCaracteristica);
        if (resultado == -1)
            System.out.println(
                    "\n\t*** El Ganador del combate es: " + mapaVillanos.get(nVillano).getNombrePersonaje() + " ***\n");
        if (resultado == 0)
            System.out.println(
                    "\n\t*** Hubo EMPATE entre los competidores " + mapaHeroes.get(nHeroe).getNombrePersonaje() + " y "
                            + mapaVillanos.get(nVillano).getNombrePersonaje() + " ***\n");
        if (resultado == 1)
            System.out.println(
                    "\n\t*** El Ganador del combate es: " + mapaHeroes.get(nHeroe).getNombrePersonaje() + " ***\n");
    }

    private void combatirLHvV(int nLigaHeroe, int nVillano, Caracteristica nCaracteristica)
            throws MismoTipoCompetidorEx {
        int resultado;
        resultado = buscarLigaHeroe(nLigaHeroe).competir(buscarVillano(nVillano), nCaracteristica);
        if (resultado == -1)
            System.out.println(
                    "\n\t*** El Ganador del combate es: " + mapaVillanos.get(nVillano).getNombrePersonaje() + " ***\n");
        if (resultado == 0)
            System.out.println("\n\t*** Hubo EMPATE entre los competidores "
                    + mapaLigasHeroes.get(nLigaHeroe).getNombrePersonaje() + " y "
                    + mapaVillanos.get(nVillano).getNombrePersonaje() + " ***\n");
        if (resultado == 1)
            System.out.println("\n\t*** El Ganador del combate es: "
                    + mapaLigasHeroes.get(nLigaHeroe).getNombrePersonaje() + " ***\n");
    }

    private void combatirHvLV(int nHeroe, int nLigaVillano, Caracteristica nCaracteristica)
            throws MismoTipoCompetidorEx {
        int resultado;
        resultado = buscarHeroe(nHeroe).competir(buscarVillano(nLigaVillano), nCaracteristica);
        if (resultado == -1)
            System.out.println(
                    "\n\t*** El Ganador del combate es: " + mapaLigasVillanos.get(nLigaVillano).getNombrePersonaje());
        if (resultado == 0)
            System.out.println(
                    "\n\t*** Hubo EMPATE entre los competidores " + mapaHeroes.get(nHeroe).getNombrePersonaje() + " y "
                            + mapaVillanos.get(nLigaVillano).getNombrePersonaje() + " ***\n");
        if (resultado == 1)
            System.out.println(
                    "\n\t*** El Ganador del combate es: " + mapaHeroes.get(nHeroe).getNombrePersonaje() + " ***\n");
    }

    private void combatirLHvLV(int nLigaHeroe, int nLigaVillano, Caracteristica nCaracteristica)
            throws MismoTipoCompetidorEx {
        int resultado;
        resultado = buscarLigaHeroe(nLigaHeroe).competir(buscarLigaVillano(nLigaVillano), nCaracteristica);
        if (resultado == -1)
            System.out.println("\n\t*** El Ganador del combate es: "
                    + mapaLigasVillanos.get(nLigaVillano).getNombrePersonaje() + " ***\n");
        if (resultado == 0)
            System.out.println("\n\t*** Hubo EMPATE entre los competidores "
                    + mapaLigasHeroes.get(nLigaHeroe).getNombrePersonaje() + " y "
                    + mapaVillanos.get(nLigaVillano).getNombrePersonaje());
        if (resultado == 1)
            System.out.println("\n\t*** El Ganador del combate es: "
                    + mapaLigasHeroes.get(nLigaHeroe).getNombrePersonaje() + " ***\n");
    }

    private Caracteristica buscarCaracteristica(String nCaracteristica) throws LineaErroneaEx {
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

    private void mostrarVillanos() {
        for (Entry<Integer, Competidor> competidor : mapaVillanos.entrySet()) {
            System.out.println(competidor.getKey() + " --> " + competidor.getValue().getNombrePersonaje());
        }
    }

    private void mostrarLigasHeroes() {
        System.out.println("\n\t [ LISTADO LIGAS DE HÉROES ]\n");
        for (Entry<Integer, Liga> competidor : mapaLigasHeroes.entrySet()) {
            System.out.println(competidor.getKey() + " --> " + competidor.getValue().getNombrePersonaje());
        }
    }

    private void mostrarLigasVillanos() {
        System.out.println("\n\t [ LISTADO LIGAS DE VILLANOS ]\n");
        for (Entry<Integer, Liga> competidor : mapaLigasVillanos.entrySet()) {
            System.out.println(competidor.getKey() + " --> " + competidor.getValue().getNombrePersonaje());
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

    private void validarInput(String s) throws LineaErroneaEx {
        if (s.isBlank() || s.isEmpty() || s == null || s.equals(null))
            throw new LineaErroneaEx("Los valores ingresados no son correctos. \n");
    }

    /**
     * @throws IOException
     * @throws CaracteristicaInvalidaEx
     * @throws NombreInvalidoEx
     * @post: Carga el archivo desde la ruta especificada.
     */
    private void menuCargarArchivo() throws IOException, NombreInvalidoEx, CaracteristicaInvalidaEx {

        Scanner entradaArchivo = new Scanner(System.in);
        try {
            System.out.println("\n\t [ CARGAR Archivo ]");
            System.out.println("\nPor favor indique la ruta del archivo:");
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
     * @throws MismoTipoCompetidorEx
     * @throws TipoCompetidorInvalidoEx
     * @throws CaracteristicaInvalidaEx
     * @throws NombreInvalidoEx
     * @post: Carga el archivo desde la ruta especificada.
     */
    private void menuCargarArchivoParaLiga() throws IOException, NombreInvalidoEx, CaracteristicaInvalidaEx,
            TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {

        Scanner entradaArchivo = new Scanner(System.in);
        try {
            System.out.println("\n\t [ CARGAR Archivo ]");
            System.out.println("\nPor favor indique la ruta del archivo:");
            String rutaArchivo = entradaArchivo.nextLine();
            if (!rutaArchivo.isEmpty()) {
                cargarArchivoParaLiga(rutaArchivo);
            }
        } catch (LineaErroneaEx e) {
            System.err.println(e);
        }
    }

    public void cargarArchivo(String pArchivo)
            throws LineaErroneaEx, IOException, NombreInvalidoEx, CaracteristicaInvalidaEx {
        BufferedReader lector = new BufferedReader(new FileReader(pArchivo));

        try {
            String linea = lector.readLine();
            while (linea != null) {
                try {
                    linea = linea.trim();
                    if (linea.isEmpty() || linea.isBlank())
                        throw new LineaErroneaEx("La linea esta vacia. \n");
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

    public void cargarArchivoParaLiga(String pArchivo) throws LineaErroneaEx, IOException, NombreInvalidoEx,
            CaracteristicaInvalidaEx, TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
        BufferedReader lector = new BufferedReader(new FileReader(pArchivo));

        try {
            String linea = lector.readLine();
            while (linea != null) {
                try {
                    linea = linea.trim();
                    if (linea.isEmpty() || linea.isBlank())
                        throw new LineaErroneaEx("La línea está vacía.\n");
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

    private Competidor crearCompetidorPorArchivo(String linea)
            throws LineaErroneaEx, NombreInvalidoEx, CaracteristicaInvalidaEx {

        Competidor competidor;

        linea = linea.trim();

        String[] lineaLeida = linea.split(",");

        if (!lineaLeida[0].toLowerCase().trim().equals("héroe")
                && !lineaLeida[0].toLowerCase().trim().equals("heroe")
                && !lineaLeida[0].toLowerCase().trim().equals("villano")) {
            throw new LineaErroneaEx("Competidor no cargado: tipo de competidor inválido.\n");
        }

        if (lineaLeida[1].isEmpty() || lineaLeida[1].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: nombre real no encontrado.\n");
        }
        String nombreR = lineaLeida[1].trim();

        if (lineaLeida[2].isEmpty() || lineaLeida[2].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: nombre de personaje no encontrado.\n");
        }
        String nombreP = lineaLeida[2].trim();

        if (lineaLeida[3].isEmpty() || lineaLeida[3].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: nombre no encontrada.\n");
        }
        double v = Double.parseDouble(lineaLeida[3].trim());

        if (lineaLeida[4].isEmpty() || lineaLeida[4].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: fuerza no encontrada.\n");
        }
        double f = Double.parseDouble(lineaLeida[4].trim());

        if (lineaLeida[5].isEmpty() || lineaLeida[5].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: resistencia no encontrada.\n");
        }
        double r = Double.parseDouble(lineaLeida[5].trim());

        if (lineaLeida[6].isEmpty() || lineaLeida[6].isBlank()) {
            throw new LineaErroneaEx("Competidor no cargado: destreza no encontrada.\n");
        }
        double d = Double.parseDouble(lineaLeida[6].trim());

        if (lineaLeida[0].toLowerCase().equals("héroe") || lineaLeida[0].toLowerCase().equals("heroe"))
            competidor = cargarHeroeEnMapa(nombreR, nombreP, v, f, r, d);
        else
            competidor = cargarVillanoEnMapa(nombreR, nombreP, v, f, r, d);

        conjuntoCompetidores.add(competidor);

        return competidor;
    }

    private Liga crearLigaPorArchivo(String linea) throws LineaErroneaEx, NombreInvalidoEx, CaracteristicaInvalidaEx,
            TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {

        Liga liga;

        linea = linea.trim();

        String[] lineaLeida = linea.split(",");

        if (lineaLeida[0].isEmpty() || lineaLeida[0].isBlank()) {
            throw new LineaErroneaEx("Liga no cargada: nombre no encontrado.\n");
        }
        String nombreLiga = lineaLeida[0].trim();

        liga = new Liga(nombreLiga);

        for (int i = 1; i < lineaLeida.length; i++) {
            if (lineaLeida[i].isEmpty() || lineaLeida[i].isBlank()) {
                throw new LineaErroneaEx("Competidor no cargado: nombre de personaje no encontrado.\n");
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

    /**
     * Guarda la lista de competidores completa en disco, en el archivo especificado
     * como parámetro
     * Con el siguiente formato. Una línea por competidor:
     * Héroe/Villano, NombreReal, NombrePersonaje, Velocidad, Fuerza, Resistencia,
     * Destreza
     * 
     * @param pArchivo nombre del archivo (path absoluto o relativo
     *                 a la carpeta src del proyecto
     */
    public void guardarCompetidores(String pArchivo) throws IOException {
        FileWriter guardador = null;
        try {
            guardador = new FileWriter(pArchivo);
            for (Map.Entry<Integer, Competidor> competidor : mapaHeroes.entrySet()) {
                System.out.println("GUARDANDO Competidor: " + competidor.getValue().getNombrePersonaje());
                guardador.write(serializarCompetidor(competidor.getValue()));
            }
            for (Map.Entry<Integer, Competidor> competidor : mapaVillanos.entrySet()) {
                System.out.println("GUARDANDO Competidor: " + competidor.getValue().getNombrePersonaje());
                guardador.write(serializarCompetidor(competidor.getValue()));
            }

            guardador.close();
            System.out.println(
                    "----------------------------------\n Los competidores se guardaron CORRECTAMENTE en el archivo "
                            + pArchivo + "\n----------------------------------\n");
        } catch (FileNotFoundException e) {
            System.err.println("La ruta especificada o el archivo no existen.");
        } catch (IOException e) {
            System.err.println("Ocurri� un error intentando guardar el archivo archivo");
        } finally {
            guardador.close();
        }

    }

    /**
     * @post: Serializa los datos de la persona que se ingresa.
     * @return
     */
    public String serializarCompetidor(Competidor c) {

        return c.getClass().getName().replace("clases.", "") + ", " + c.getNombreReal() + ", " + c.getNombrePersonaje()
                + ", "
                + c.getVelocidad() + ", "
                + c.getFuerza() + ", "
                + c.getResistencia() + ", " + c.getDestreza() + "\n";
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.menu3();

    }
}

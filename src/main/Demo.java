// package main;

// import java.util.ArrayList;
// import java.util.List;

// import clases.Competidor;
// import clases.Heroe;
// import clases.Liga;
// import clases.Villano;
// import excepciones.TipoCompetidorInvalidoEx;

// public class Demo {
// public static void main(String[] args) {

// Competidor heroe1 = new Heroe("HeroeReal", "Heroe", 200, 100, 180, 100);
// Competidor heroe2 = new Heroe("HeroeReal", "Heroe", 200, 100, 280, 0);
// Competidor heroe3 = new Heroe("HeroeReal", "Heroe", 400, 100, 380, 10);

// Competidor heroe4 = new Heroe("HeroeReal", "Heroe", 300, 100, 180, 1001);
// Competidor heroe5 = new Heroe("HeroeReal", "Heroe", 300, 100, 280, 0);
// Competidor heroe6 = new Heroe("HeroeReal", "Heroe", 500, 100, 380, 101);

// Competidor villano3 = new Villano("VillanoReal", "Villano", 100, 100, 280,
// 580 );
// Competidor villano1 = new Villano("VillanoReal", "Villano", 100, 50, 80, 80);
// Competidor villano2 = new Villano("VillanoReal", "Villano", 100, 565, 80,
// 80);
// Liga liga = new Liga("liga1");
// Liga ligaVillanos = new Liga("villanos");
// liga.addCompetidor(heroe1);
// liga.addCompetidor(heroe2);
// liga.addCompetidor(heroe3);
// Liga liga2 = new Liga("liga2");
// liga2.addCompetidor(heroe4);
// liga2.addCompetidor(heroe5);
// liga2.addCompetidor(heroe6);
// // ligaVillanos.addPersonaje(villano1);
// // ligaVillanos.addPersonaje(villano2);
// // ligaVillanos.addPersonaje(villano3);

// // Liga ligaCompuesta = new Liga("ligaCompuestaDeHeroes");

// // ligaCompuesta.addPersonaje(ligaVillanos);
// // ligaCompuesta.addPersonaje(liga);
// System.out.println(liga.toString());
// System.out.println("---");
// System.out.println(liga2.toString());
// System.out.println("-------");
// liga.addCompetidor(liga2);
// System.out.println(liga.toString());
// liga.addCompetidor(liga);
// System.out.println(liga.toString());
// // liga.addPersonaje(heroe1);
// // System.out.println("---");
// // System.out.println(liga.toString());

// // System.out.println(heroe1.competir(villano1, Caracteristica.FUERZA));
// // System.out.println(heroe1.esGanador(villano1, Caracteristica.FUERZA));
// // System.out.println("---");
// // System.out.println(heroe2.competir(villano2, Caracteristica.DESTREZA));
// // System.out.println("---");
// // System.out.println(heroe2.competir(villano2, Caracteristica.VELOCIDAD));
// // System.out.println("---");
// // System.out.println(heroe3.competir(villano3, Caracteristica.VELOCIDAD));
// // System.out.println("---");
// // System.out.println(liga.competir(villano3, Caracteristica.VELOCIDAD));
// // System.out.println(liga.getAtributos().get(0).toString());
// // System.out.println(liga.getAtributos().get(1).toString());
// // System.out.println(liga.getAtributos().get(2).toString());
// // System.out.println(liga.getAtributos().get(3).toString());

// // System.out.println("----");
// // System.out.println(ligaVillanos.getAtributos().get(0).toString());
// // System.out.println(ligaVillanos.getAtributos().get(1).toString());
// // System.out.println(ligaVillanos.getAtributos().get(2).toString());
// // System.out.println(ligaVillanos.getAtributos().get(3).toString());

// // System.out.println(villano1.competir(liga, Caracteristica.DESTREZA));
// // System.out.println(heroe1.competir(ligaVillanos,
// Caracteristica.DESTREZA));
// // System.out.println(liga.competir(ligaVillanos, Caracteristica.DESTREZA));

// // // System.out.println(liga.competir(ligaVillanos,
// Caracteristica.DESTREZA));
// // // System.out.println(liga.competir(ligaVillanos,
// Caracteristica.VELOCIDAD));
// // try {
// // System.out.println(villano1.competir(heroe1, Caracteristica.DESTREZA));
// // } catch (MismoTipoCompetidorEx e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
// }
// }

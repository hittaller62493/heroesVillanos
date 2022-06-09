package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;

import clases.Caracteristica;
import clases.Competidor;
import clases.Heroe;
import clases.Liga;
import clases.Villano;
import excepciones.CaracteristicaInvalidaEx;
import excepciones.MismoTipoCompetidorEx;
import excepciones.NombreInvalidoEx;
import excepciones.TipoCompetidorInvalidoEx;

public class Tests {
	// Creo los heroes
	Competidor heroe1 = new Heroe("HeroeReal", "Heroe", 200, 100, 180, 100);
	Competidor heroe2 = new Heroe("HeroeReal", "Heroe", 300, 100, 280, 580);
	Competidor heroe3 = new Heroe("HeroeReal", "Heroe", 400, 100, 380, 10);
	Competidor heroe4 = new Heroe("HeroeReal", "Heroe", 200, 200, 200, 200);
	Competidor heroe5 = new Heroe("HeroeReal", "Heroe", 100, 200, 200, 900);

	// Creo los villanos
	Competidor villano1 = new Villano("VillanoReal", "Villano", 100, 50, 80, 80);
	Competidor villano2 = new Villano("VillanoReal", "Villano", 100, 565, 80, 80);
	Competidor villano3 = new Villano("VillanoReal", "Villano", 100, 100, 280, 580);
	Competidor villano4 = new Villano("VillanoReal", "Villano", 200, 200, 200, 200);
	Competidor villano5 = new Villano("VillanoReal", "Villano", 500, 200, 200, 200);
	
	// Creo las ligas
	Liga ligaHeroes = new Liga("heroes");
	Liga ligaVillanos = new Liga("villanos");



	//Heroes contra Villanos

	//Empate
	@Test
	public void heroeYVillanoEmpatan() {
		assertEquals(0, heroe4.competir(villano4, Caracteristica.DESTREZA));
		assertEquals(0, heroe4.competir(villano4, Caracteristica.VELOCIDAD));
		assertEquals(0, heroe4.competir(villano4, Caracteristica.FUERZA));
		assertEquals(0, heroe4.competir(villano4, Caracteristica.RESISTENCIA));
	}

	//Desempate
	@Test
	public void heroeYVillanoDesempatanPorVelocidad() {
		assertEquals(1, heroe2.competir(villano3, Caracteristica.FUERZA));
	}

	//Gana
	@Test
	public void heroeLeGanaAVillanoPorFuerza(){
		assertEquals(1, heroe4.competir(villano3, Caracteristica.FUERZA));
	}
	@Test
	public void heroeLeGanaAVillanoPorDestreza(){
		assertEquals(1, heroe4.competir(villano2, Caracteristica.DESTREZA));
	}
	@Test
	public void heroeLeGanaAVillanoPorResistencia(){
		assertEquals(1, heroe3.competir(villano3, Caracteristica.RESISTENCIA));
	}
	@Test
	public void heroeLeGanaAVillanoPorVelocidad(){
		assertEquals(1, heroe4.competir(villano3, Caracteristica.VELOCIDAD));
	}

	//Pierde
	@Test
	public void heroePierdeContraVillanoPorFuerza(){
		assertEquals(-1, heroe2.competir(villano2, Caracteristica.FUERZA));
	}
	@Test
	public void heroePierdeContraVillanoPorDestreza(){
		assertEquals(-1, heroe3.competir(villano3, Caracteristica.DESTREZA));
	}
	@Test
	public void heroePierdeContraVillanoPorResistencia(){
		assertEquals(-1, heroe1.competir(villano3, Caracteristica.RESISTENCIA));
	}
	@Test
	public void heroePierdeContraVillanoPorVelocidad(){
		assertEquals(-1, heroe5.competir(villano5, Caracteristica.VELOCIDAD));
	}



	//Villanos contra Heroes

	//Gana
	@Test
	public void villanoGanaContraHeroePorVelocidad() {
		assertEquals(1, villano5.competir(heroe5, Caracteristica.VELOCIDAD));
	}
	@Test
	public void villanoGanaContraHeroePorDestreza() {
		assertEquals(1, villano3.competir(heroe3, Caracteristica.DESTREZA));
	}
	@Test
	public void villanoGanaContraHeroePorFuerza() {
		assertEquals(1, villano2.competir(heroe2, Caracteristica.FUERZA));
	}
	@Test
	public void villanoGanaContraHeroePorResistencia() {
		assertEquals(1, villano3.competir(heroe1, Caracteristica.RESISTENCIA));
	}
	
	//Pierde

	@Test
	public void villanoPierdeContraHeroePorVelocidad() {
		assertEquals(-1, villano2.competir(heroe2, Caracteristica.VELOCIDAD));
	}
	@Test
	public void villanoPierdeContraHeroePorDestreza() {
		assertEquals(-1, villano2.competir(heroe4, Caracteristica.DESTREZA));
	}
	@Test
	public void villanoPierdeContraHeroePorFuerza() {
		assertEquals(-1, villano3.competir(heroe4, Caracteristica.FUERZA));
	}
	@Test
	public void villanoPierdeContraHeroePorResistencia() {
		assertEquals(-1, villano3.competir(heroe3, Caracteristica.RESISTENCIA));
	}

	//Caso de empate, mejora y luego desempate
	@Test
	public void empatanMejoraDestrezaYLuegoDesempatan() {
		// Empatan
		assertEquals(0, heroe4.competir(villano4, Caracteristica.DESTREZA));
		// Heroe4 mejora 50 de destreza
		heroe4.incrementarDestreza(50);
		assertEquals(1, heroe4.competir(villano4, Caracteristica.DESTREZA));
	}
	@Test
	public void empatanMejoraFuerzaYLuegoDesempatan() {
		// Empatan
		assertEquals(0, heroe4.competir(villano4, Caracteristica.FUERZA));
		// Villano4 mejora 100 de fuerza
		villano4.incrementarFuerza(100);
		assertEquals(-1, heroe4.competir(villano4, Caracteristica.FUERZA));
	}
	@Test
	public void empatanYMejoraVelocidadYLuegoDesempatan() {
		// Empatan
		assertEquals(0, heroe4.competir(villano4, Caracteristica.VELOCIDAD));
		// Heroe4 mejora 150 de velocidad
		heroe4.incrementarVelocidad(150);
		assertEquals(1, heroe4.competir(villano4, Caracteristica.VELOCIDAD));
	}
	@Test
	public void empatanYMejoraResistenciaLuegoDesempatan() {
		// Empatan
		assertEquals(0, heroe4.competir(villano4, Caracteristica.RESISTENCIA));
		// Villano4 mejora 250 de resistencia
		villano4.incrementarResistencia(250);
		assertEquals(-1, heroe4.competir(villano4, Caracteristica.RESISTENCIA));
	}

	//Test de Excepciones 

	//CaracteristicaInvalidaEx
	@Test(expected = CaracteristicaInvalidaEx.class)
	public void creoHeroeConAtributosNegativos() {
		Heroe heroeNegativo = new Heroe("Julio", "Batman", -233, 244, -90, 1);
	}

	@Test(expected = CaracteristicaInvalidaEx.class)
	public void creoVillanoConAtributosNegativos() {
		Villano villanoNegativo = new Villano("Ramon", "Spiderman", 223, -202, -90, 1);
	}

	//NombreInvalidoEx
	@Test(expected = NombreInvalidoEx.class)
	public void creoCompetidorSinNombre() {
		Competidor sinNombre = new Villano("", "", 223, 802, 560, 1);
	}
	@Test(expected = NombreInvalidoEx.class)
	public void creoCompetidorConEspacios() {
		Competidor nombreConEspacios = new Heroe("    ", "      ", 223, 802, 560, 1);
	}

	@Test(expected = MismoTipoCompetidorEx.class)
	public void compitenDosCompetidoresDelMismoTipo() {
		heroe1.competir(heroe2, Caracteristica.DESTREZA);
	}

	@Test(expected = TipoCompetidorInvalidoEx.class)
	public void composicionDeLigasIncopatibles() {
		ligaHeroes.addPersonaje(heroe1);
		ligaVillanos.addPersonaje(villano3);

		Liga ligaCompuestaIncopatible = new Liga("ligaCompuestaIncopatible");
		ligaCompuestaIncopatible.addPersonaje(ligaHeroes);
		ligaCompuestaIncopatible.addPersonaje(ligaVillanos);
	}

	@Test(expected = MismoTipoCompetidorEx.class)
	public void compitenDosLigasDelMismoTipo() {
		Liga otraLigaHeroes = new Liga("LigaDeHeroes");
		otraLigaHeroes.addPersonaje(heroe4);
		ligaHeroes.addPersonaje(heroe1);
		ligaHeroes.competir(otraLigaHeroes, Caracteristica.DESTREZA);
	}
	@Test(expected = MismoTipoCompetidorEx.class)
	public void ligasAutocompiten() {
		ligaVillanos.addPersonaje(villano1);
		ligaVillanos.addPersonaje(villano2);
		assertEquals(1, ligaVillanos.competir(ligaVillanos, Caracteristica.DESTREZA));
	}


	//Ligas contra..
	@Test
	public void ligaDeVillanoContraHeroes() {
		ligaVillanos.addPersonaje(villano1);
		assertEquals(-1, ligaVillanos.competir(heroe1, Caracteristica.DESTREZA));
	}

	@Test
	public void heroeContraLigaDeVillano() {
		ligaVillanos.addPersonaje(villano1);
		assertEquals(1, heroe1.competir(ligaVillanos, Caracteristica.DESTREZA));
	}
	@Test
	public void villanoContraLigaDeHeroes() {
		ligaHeroes.addPersonaje(heroe2);
		assertEquals(-1, villano1.competir(ligaHeroes, Caracteristica.DESTREZA));
	}
	@Test
	public void ligaHeroesContraLigaVillanos() {
		ligaVillanos.addPersonaje(villano1);
		ligaHeroes.addPersonaje(heroe1);
		assertEquals(1, ligaHeroes.competir(ligaVillanos, Caracteristica.DESTREZA));
	}
	@Test
	public void ligaVillanosContraLigaHeroes() {
		ligaVillanos.addPersonaje(villano1);
		ligaHeroes.addPersonaje(heroe2);

		assertEquals(-1, ligaVillanos.competir(ligaHeroes, Caracteristica.DESTREZA));
	}
}

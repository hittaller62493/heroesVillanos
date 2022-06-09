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

	// Creo los villanos
	Competidor villano1 = new Villano("VillanoReal", "Villano", 100, 50, 80, 80);
	Competidor villano2 = new Villano("VillanoReal", "Villano", 100, 565, 80, 80);
	Competidor villano3 = new Villano("VillanoReal", "Villano", 100, 100, 280, 580);
	Competidor villano4 = new Villano("VillanoReal", "Villano", 200, 200, 200, 200);

	// Creo las ligas
	Liga ligaHeroes = new Liga("heroes");
	Liga ligaVillanos = new Liga("villanos");

	@Test
	public void heroeYVillanoEmpatan() {
		assertEquals(0, heroe4.competir(villano4, Caracteristica.DESTREZA));
		assertEquals(0, heroe4.competir(villano4, Caracteristica.VELOCIDAD));
		assertEquals(0, heroe4.competir(villano4, Caracteristica.FUERZA));
		assertEquals(0, heroe4.competir(villano4, Caracteristica.RESISTENCIA));
	}

	@Test
	public void heroeYVillanoDesempatanPorVelocidad() {
		assertEquals(1, heroe2.competir(villano3, Caracteristica.FUERZA));
	}

	@Test
	public void villanoPierdeContraPorVelocidad() {
		assertEquals(-1, villano2.competir(heroe2, Caracteristica.VELOCIDAD));
	}

	@Test
	public void empatanYLuegoDesempatan() {
		// Empatan
		assertEquals(0, heroe4.competir(villano4, Caracteristica.DESTREZA));
		// Heroe4 mejora 50 de destreza
		heroe4.incrementarDestreza(50);
		assertEquals(1, heroe4.competir(villano4, Caracteristica.DESTREZA));
	}

	@Test(expected = CaracteristicaInvalidaEx.class)
	public void creoHeroeConAtributosNegativos() {
		Heroe heroeNegativo = new Heroe("Julio", "Batman", -233, 244, -90, 1);
	}

	@Test(expected = CaracteristicaInvalidaEx.class)
	public void creoVillanoConAtributosNegativos() {
		Villano villanoNegativo = new Villano("Ramon", "Spiderman", 223, -202, -90, 1);
	}

	@Test(expected = NombreInvalidoEx.class)
	public void creoCompetidorSinNombre() {
		Competidor sinNombre = new Villano("", "", 223, -202, -90, 1);
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
}

package tests;

import org.junit.Test;
import org.junit.Assert;
import clases.*;
import excepciones.*;

public class Tests {
	// Creo los heroes
	Competidor heroe1, heroe2, heroe3, heroe4, heroe5, villano1, villano2, villano3, villano4, villano5;
	Liga ligaHeroes, ligaVillanos;

	public Tests() {

		try {
			heroe1 = new Heroe("HeroeReal", "Heroe", 200, 100, 180, 100);
			heroe2 = new Heroe("HeroeReal", "Heroe", 300, 100, 280, 580);
			heroe3 = new Heroe("HeroeReal", "Heroe", 400, 100, 380, 10);
			heroe4 = new Heroe("HeroeReal", "Heroe", 200, 200, 200, 200);
			heroe5 = new Heroe("HeroeReal", "Heroe", 100, 200, 200, 900);

			// Creo los villanos
			villano1 = new Villano("VillanoReal", "Villano", 100, 50, 80, 80);
			villano2 = new Villano("VillanoReal", "Villano", 100, 565, 80, 80);
			villano3 = new Villano("VillanoReal", "Villano", 100, 100, 280, 580);
			villano4 = new Villano("VillanoReal", "Villano", 200, 200, 200, 200);
			villano5 = new Villano("VillanoReal", "Villano", 500, 200, 200, 200);

			// Creo las ligas
			ligaHeroes = new Liga("heroes");
			ligaVillanos = new Liga("villanos");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// Heroes contra Villanos

	// Empate
	@Test
	public void heroeYVillanoEmpatan() throws MismoTipoCompetidorEx {
		Assert.assertEquals(0, heroe4.competir(villano4, Caracteristica.DESTREZA));
		Assert.assertEquals(0, heroe4.competir(villano4, Caracteristica.VELOCIDAD));
		Assert.assertEquals(0, heroe4.competir(villano4, Caracteristica.FUERZA));
		Assert.assertEquals(0, heroe4.competir(villano4, Caracteristica.RESISTENCIA));
	}

	// Desempate
	@Test
	public void heroeYVillanoDesempatanPorVelocidad() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, heroe2.competir(villano3, Caracteristica.FUERZA));
	}

	// Gana
	@Test
	public void heroeLeGanaAVillanoPorFuerza() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, heroe4.competir(villano3, Caracteristica.FUERZA));
	}

	@Test
	public void heroeLeGanaAVillanoPorDestreza() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, heroe4.competir(villano2, Caracteristica.DESTREZA));
	}

	@Test
	public void heroeLeGanaAVillanoPorResistencia() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, heroe3.competir(villano3, Caracteristica.RESISTENCIA));
	}

	@Test
	public void heroeLeGanaAVillanoPorVelocidad() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, heroe4.competir(villano3, Caracteristica.VELOCIDAD));
	}

	// Pierde
	@Test
	public void heroePierdeContraVillanoPorFuerza() throws MismoTipoCompetidorEx {
		Assert.assertEquals(-1, heroe2.competir(villano2, Caracteristica.FUERZA));
	}

	@Test
	public void heroePierdeContraVillanoPorDestreza() throws MismoTipoCompetidorEx {
		Assert.assertEquals(-1, heroe3.competir(villano3, Caracteristica.DESTREZA));
	}

	@Test
	public void heroePierdeContraVillanoPorResistencia() throws MismoTipoCompetidorEx {
		Assert.assertEquals(-1, heroe1.competir(villano3, Caracteristica.RESISTENCIA));
	}

	@Test
	public void heroePierdeContraVillanoPorVelocidad() throws MismoTipoCompetidorEx {
		Assert.assertEquals(-1, heroe5.competir(villano5, Caracteristica.VELOCIDAD));
	}

	// Villanos contra Heroes

	// Gana
	@Test
	public void villanoGanaContraHeroePorVelocidad() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, villano5.competir(heroe5, Caracteristica.VELOCIDAD));
	}

	@Test
	public void villanoGanaContraHeroePorDestreza() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, villano3.competir(heroe3, Caracteristica.DESTREZA));
	}

	@Test
	public void villanoGanaContraHeroePorFuerza() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, villano2.competir(heroe2, Caracteristica.FUERZA));
	}

	@Test
	public void villanoGanaContraHeroePorResistencia() throws MismoTipoCompetidorEx {
		Assert.assertEquals(1, villano3.competir(heroe1, Caracteristica.RESISTENCIA));
	}

	// Pierde

	@Test
	public void villanoPierdeContraHeroePorVelocidad() throws MismoTipoCompetidorEx {
		Assert.assertEquals(-1, villano2.competir(heroe2, Caracteristica.VELOCIDAD));
	}

	@Test
	public void villanoPierdeContraHeroePorDestreza() throws MismoTipoCompetidorEx {
		Assert.assertEquals(-1, villano2.competir(heroe4, Caracteristica.DESTREZA));
	}

	@Test
	public void villanoPierdeContraHeroePorFuerza() throws MismoTipoCompetidorEx {
		Assert.assertEquals(-1, villano3.competir(heroe4, Caracteristica.FUERZA));
	}

	@Test
	public void villanoPierdeContraHeroePorResistencia() throws MismoTipoCompetidorEx {
		Assert.assertEquals(-1, villano3.competir(heroe3, Caracteristica.RESISTENCIA));
	}

	// Caso de empate, mejora y luego desempate
	@Test
	public void empatanMejoraDestrezaYLuegoDesempatan() throws MismoTipoCompetidorEx {
		// Empatan
		Assert.assertEquals(0, heroe4.competir(villano4, Caracteristica.DESTREZA));
		// Heroe4 mejora 50 de destreza
		heroe4.incrementarDestreza(50);
		Assert.assertEquals(1, heroe4.competir(villano4, Caracteristica.DESTREZA));
	}

	@Test
	public void empatanMejoraFuerzaYLuegoDesempatan() throws MismoTipoCompetidorEx {
		// Empatan
		Assert.assertEquals(0, heroe4.competir(villano4, Caracteristica.FUERZA));
		// Villano4 mejora 100 de fuerza
		villano4.incrementarFuerza(100);
		Assert.assertEquals(-1, heroe4.competir(villano4, Caracteristica.FUERZA));
	}

	@Test
	public void empatanYMejoraVelocidadYLuegoDesempatan() throws MismoTipoCompetidorEx {
		// Empatan
		Assert.assertEquals(0, heroe4.competir(villano4, Caracteristica.VELOCIDAD));
		// Heroe4 mejora 150 de velocidad
		heroe4.incrementarVelocidad(150);
		Assert.assertEquals(1, heroe4.competir(villano4, Caracteristica.VELOCIDAD));
	}

	@Test
	public void empatanYMejoraResistenciaLuegoDesempatan() throws MismoTipoCompetidorEx {
		// Empatan
		Assert.assertEquals(0, heroe4.competir(villano4, Caracteristica.RESISTENCIA));
		// Villano4 mejora 250 de resistencia
		villano4.incrementarResistencia(250);
		Assert.assertEquals(-1, heroe4.competir(villano4, Caracteristica.RESISTENCIA));
	}

	// Test de Excepciones

	// CaracteristicaInvalidaEx
	@Test(expected = CaracteristicaInvalidaEx.class)
	public void creoHeroeConAtributosNegativos() throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		Heroe heroeNegativo = new Heroe("Julio", "Batman", -233, 244, -90, 1);
	}

	@Test(expected = CaracteristicaInvalidaEx.class)
	public void creoVillanoConAtributosNegativos() throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		Villano villanoNegativo = new Villano("Ramon", "Spiderman", 223, -202, -90, 1);
	}

	// NombreInvalidoEx
	@Test(expected = NombreInvalidoEx.class)
	public void creoCompetidorSinNombre() throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		Competidor sinNombre = new Villano("", "", 223, 802, 560, 1);
	}

	@Test(expected = NombreInvalidoEx.class)
	public void creoCompetidorConEspacios() throws NombreInvalidoEx, CaracteristicaInvalidaEx {
		Competidor nombreConEspacios = new Heroe("    ", "      ", 223, 802, 560, 1);
	}

	@Test(expected = MismoTipoCompetidorEx.class)
	public void compitenDosCompetidoresDelMismoTipo() throws MismoTipoCompetidorEx {
		heroe1.competir(heroe2, Caracteristica.DESTREZA);
	}

	@Test(expected = TipoCompetidorInvalidoEx.class)
	public void composicionDeLigasIncopatibles()
			throws TipoCompetidorInvalidoEx, MismoTipoCompetidorEx, NombreInvalidoEx, CaracteristicaInvalidaEx {
		ligaHeroes.addCompetidor(heroe1);
		ligaVillanos.addCompetidor(villano3);

		Liga ligaCompuestaIncopatible = new Liga("ligaCompuestaIncopatible");
		ligaCompuestaIncopatible.addCompetidor(ligaHeroes);
		ligaCompuestaIncopatible.addCompetidor(ligaVillanos);
	}

	@Test(expected = MismoTipoCompetidorEx.class)
	public void compitenDosLigasDelMismoTipo()
			throws NombreInvalidoEx, CaracteristicaInvalidaEx, TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
		Liga otraLigaHeroes = new Liga("LigaDeHeroes");
		otraLigaHeroes.addCompetidor(heroe4);
		ligaHeroes.addCompetidor(heroe1);
		ligaHeroes.competir(otraLigaHeroes, Caracteristica.DESTREZA);
	}

	@Test(expected = MismoTipoCompetidorEx.class)
	public void ligasAutocompiten() throws TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
		ligaVillanos.addCompetidor(villano1);
		ligaVillanos.addCompetidor(villano2);
		Assert.assertEquals(1, ligaVillanos.competir(ligaVillanos, Caracteristica.DESTREZA));
	}

	// Ligas contra..
	@Test
	public void ligaDeVillanoContraHeroes() throws TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
		ligaVillanos.addCompetidor(villano1);
		Assert.assertEquals(-1, ligaVillanos.competir(heroe1, Caracteristica.DESTREZA));
	}

	@Test
	public void heroeContraLigaDeVillano() throws TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
		ligaVillanos.addCompetidor(villano1);
		Assert.assertEquals(1, heroe1.competir(ligaVillanos, Caracteristica.DESTREZA));
	}

	@Test
	public void villanoContraLigaDeHeroes() throws TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
		ligaHeroes.addCompetidor(heroe2);
		Assert.assertEquals(-1, villano1.competir(ligaHeroes, Caracteristica.DESTREZA));
	}

	@Test
	public void ligaHeroesContraLigaVillanos() throws TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
		ligaVillanos.addCompetidor(villano1);
		ligaHeroes.addCompetidor(heroe1);
		Assert.assertEquals(1, ligaHeroes.competir(ligaVillanos, Caracteristica.DESTREZA));
	}

	@Test
	public void ligaVillanosContraLigaHeroes() throws TipoCompetidorInvalidoEx, MismoTipoCompetidorEx {
		ligaVillanos.addCompetidor(villano1);
		ligaHeroes.addCompetidor(heroe2);

		Assert.assertEquals(-1, ligaVillanos.competir(ligaHeroes, Caracteristica.DESTREZA));
	}
}

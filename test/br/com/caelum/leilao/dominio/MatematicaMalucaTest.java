package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaMalucaTest {
	@Test
	public void deveEntenderNumeroMaiorQueTrinta() {
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		assertEquals(32 * 4, matematicaMaluca.contaMaluca(32));
	}

	@Test
	public void deveEntenderNumeroIgualATrinta() {
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		assertEquals(30 * 3, matematicaMaluca.contaMaluca(30));
	}

	@Test
	public void deveEntenderNumeroMenorQueTrintaMaiorQueDez() {
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		assertEquals(28 * 3, matematicaMaluca.contaMaluca(28));
	}

	@Test
	public void deveEntenderNumeroIgualADez() {
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		assertEquals(10 * 2, matematicaMaluca.contaMaluca(10));
	}

	@Test
	public void deveEntederNumeroMenorQueDez() {
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		assertEquals(8 * 2, matematicaMaluca.contaMaluca(8));
	}
}
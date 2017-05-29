package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnoBissextoTest {
	@Test
	public void deveIdentificarAnoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();
		
		assertTrue(anoBissexto.ehBissexto(1988));
		assertTrue(anoBissexto.ehBissexto(1992));
	}
	
	@Test
	public void deveIdentificarAnoNaoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();
		
		assertFalse(anoBissexto.ehBissexto(2015));
		assertFalse(anoBissexto.ehBissexto(2017));
	}
}
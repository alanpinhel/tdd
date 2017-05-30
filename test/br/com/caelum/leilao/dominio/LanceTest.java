package br.com.caelum.leilao.dominio;

import org.junit.Before;
import org.junit.Test;

public class LanceTest {
	private Usuario alan;

	@Before
	public void setUp() {
		this.alan = new Usuario("Alan");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarLanceParaValorZero() {
		new Lance(alan, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarLanceParaValorNegativo() {
		new Lance(alan, -1);
	}
}
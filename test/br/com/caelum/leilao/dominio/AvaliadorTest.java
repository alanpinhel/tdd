package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTest {
	@Test
	public void deveIdentificarMaiorEMenorLanceEmOrdemCrescente() {
		Usuario joao = new Usuario("Jõao");
		Usuario jose = new Usuario("José");
		Usuario alan = new Usuario("Alan");
		
		Lance primeiroLance = new Lance(joao, 250.00);
		Lance segundoLance = new Lance(jose, 300.00);
		Lance terceiroLance = new Lance(alan, 450.00);
		
		Leilao leilao = new Leilao("Macbook Air");
		leilao.propoe(primeiroLance);
		leilao.propoe(segundoLance);
		leilao.propoe(terceiroLance);
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		double maiorEsperado = 450.00;
		double menorEsperado = 250.00;
		
		Assert.assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.0001);
		Assert.assertEquals(menorEsperado, avaliador.getMenorLance(), 0.0001);
	}
	
	@Test
	public void deveIdentificarMediaDeLances() {
		Usuario joao = new Usuario("Jõao");
		Usuario jose = new Usuario("José");
		
		Lance primeiroLance = new Lance(joao, 250.00);
		Lance segundoLance = new Lance(jose, 300.00);
		
		Leilao leilao = new Leilao("Macbook Air");
		leilao.propoe(primeiroLance);
		leilao.propoe(segundoLance);
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		double mediaEsperada = 275.00;
		
		//Assert.assertEquals(mediaEsperada, avaliador.getMediaDeLances(), 0.0001);
	}
	
	@Test
	public void deveIdentificarMaiorEMenorParaApenasUmLance() {
		Usuario joao = new Usuario("João");
		
		Lance lance = new Lance(joao, 200.00);
		
		Leilao leilao = new Leilao("Macbook Air");
		leilao.propoe(lance);
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		Assert.assertEquals(200.00, avaliador.getMaiorLance(), 0.0001);
		Assert.assertEquals(200.00, avaliador.getMenorLance(), 0.0001);
	}
	
	@Test
	public void deveIdentificarMaiorEMenorEmOrdemAleatoria() {
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario alan = new Usuario("Alan");
		
		Lance primeiroLance = new Lance(joao, 200.00);
		Lance segundoLance = new Lance(maria, 450.00);
		Lance terceiroLance = new Lance(alan, 120.00);
		Lance quartoLance = new Lance(joao, 700.00);
		Lance quintoLance = new Lance(maria, 630.00);
		Lance sextoLance = new Lance(alan, 230.00);
		
		Leilao leilao = new Leilao("Macbook Air");
		leilao.propoe(primeiroLance);
		leilao.propoe(segundoLance);
		leilao.propoe(terceiroLance);
		leilao.propoe(quartoLance);
		leilao.propoe(quintoLance);
		leilao.propoe(sextoLance);
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		Assert.assertEquals(700.00, avaliador.getMaiorLance(), 0.0001);
		Assert.assertEquals(120.00, avaliador.getMenorLance(), 0.0001);
	}
	
	@Test
	public void deveIdentificarMaiorEMenorEmOrdemDecrescente() {
		Usuario alan = new Usuario("Alan");
		Usuario leticia = new Usuario("Leticia");
		
		Leilao leilao = new Leilao("Macbook Air");
		leilao.propoe(new Lance(alan, 400));
		leilao.propoe(new Lance(leticia, 300));
		leilao.propoe(new Lance(alan, 200));
		leilao.propoe(new Lance(leticia, 100));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		Assert.assertEquals(400.00, avaliador.getMaiorLance(), 0.0001);
		Assert.assertEquals(100.00, avaliador.getMenorLance(), 0.0001);
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Usuario alan = new Usuario("Alan");
		Usuario leticia = new Usuario("Leticia");
		
		Leilao leilao = new Leilao("Macbook Air");
		leilao.propoe(new Lance(alan, 100));
		leilao.propoe(new Lance(leticia, 200));
		leilao.propoe(new Lance(alan, 300));
		leilao.propoe(new Lance(leticia, 400));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		List<Lance> maiores = avaliador.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
	}
	
	@Test
	public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
		Usuario alan = new Usuario("Alan");
		Usuario leticia = new Usuario("Leticia");
		
		Leilao leilao = new Leilao("Macbook Air");
		leilao.propoe(new Lance(alan, 100));
		leilao.propoe(new Lance(leticia, 200));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		List<Lance> maiores = avaliador.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
	}
	
	@Test
	public void deveDevolverListaVaziaCasoNaoHajaLances() {
		Leilao leilao = new Leilao("Macbook Air");
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		List<Lance> maiores = avaliador.getTresMaiores();
		
		assertEquals(0, maiores.size());
	}
}
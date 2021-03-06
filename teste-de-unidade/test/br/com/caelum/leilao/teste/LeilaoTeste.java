package br.com.caelum.leilao.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

class LeilaoTeste {
	
	private Leilao leilao;
	private Usuario philSpancer;
	private Usuario bruno;

	@BeforeEach
	void setUp() {
		leilao = new Leilao("Xbox Serie X");
		
		philSpancer = new Usuario("Phil Spancer");
		bruno = new Usuario("bruno");
	}
	

	@Test
	void deveIngnorarLancesSeguidoDoMesmoUsuario() {
		


		leilao.propoe(new Lance(philSpancer, 3500.50));
		leilao.propoe(new Lance(philSpancer, 4500.50));

		assertEquals(1, leilao.getLances().size());
		assertEquals(3500.50, leilao.getLances().get(0).getValor());

	}

	@Test
	void deveingnorarMaisque5Lances() {



		leilao.propoe(new Lance(philSpancer, 1500.50));
		leilao.propoe(new Lance(bruno, 2500.50));
		leilao.propoe(new Lance(philSpancer, 3500.50));
		leilao.propoe(new Lance(bruno, 4500.50));
		leilao.propoe(new Lance(philSpancer, 5500.50));
		leilao.propoe(new Lance(bruno, 6500.50));
		leilao.propoe(new Lance(philSpancer, 7500.50));
		leilao.propoe(new Lance(bruno, 8500.50));
		leilao.propoe(new Lance(philSpancer, 9500.50));
		leilao.propoe(new Lance(bruno, 10500.50));
		leilao.propoe(new Lance(philSpancer, 11500.50));
		leilao.propoe(new Lance(bruno, 12500.50));

		assertEquals(10, leilao.getLances().size());
		assertEquals(10500.50, leilao.getLances().get(9).getValor());

	}

	@Test
	void deveDobrarUltimoLance() {


		leilao.propoe(new Lance(philSpancer, 9500.50));
		leilao.propoe(new Lance(bruno, 10500.50));
		leilao.dobraLance(philSpancer);

		assertEquals(19001.00, leilao.getLances().get(2).getValor());

	}

	@Test
	void naoDeveDobrarCasoNaoHajaLance() {

		leilao.dobraLance(philSpancer);
		assertEquals(0.0, leilao.getLances().size());
	}

}

package br.com.caelum.leilao.teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.builder.LeilaoBuilder;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

class TesetLance {
	private Leilao leilao;
	private Usuario philSpancer;
	private Usuario bruno;

	@BeforeEach
	void setUp() {
		
		philSpancer = new Usuario("Phil Spancer");
		bruno = new Usuario("bruno");
	}
	@Test
	void naoPodeSerIgualZeroOuMenor() {
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {
			    new LeilaoBuilder().para("Xbox Serie x").lance(bruno, 0).constroe();
			  });
	}

}

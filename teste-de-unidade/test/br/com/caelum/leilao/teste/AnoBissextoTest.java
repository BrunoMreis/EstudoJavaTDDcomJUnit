package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.AnoBissexto;

class AnoBissextoTest {

	@Test
	void test() {
		
		AnoBissexto bissexto = new AnoBissexto();
		
		assertEquals(true, bissexto.ehBissexto(2020));
		assertEquals(false, bissexto.ehBissexto(2019));
		assertEquals(false, bissexto.ehBissexto(200));
		
	}

}

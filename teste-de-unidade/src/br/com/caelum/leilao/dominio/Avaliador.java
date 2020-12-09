package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

	private Double maiorValor = Double.NEGATIVE_INFINITY;
	private Double menorValor = Double.POSITIVE_INFINITY;
	private Double medioValor;
	private List<Lance> maiores; 



	public void avalia(Leilao l) {
		if(l.getLances().size() == 0 ) {
			throw new RuntimeException("Não pode ser avalidado sem algum lance");
		}
		
		
		double aux = 0;
		for (Lance lance : l.getLances()) {
			aux += lance.getValor();
			if (maiorValor < lance.getValor())
				maiorValor = lance.getValor();
			if (menorValor > lance.getValor())
				menorValor = lance.getValor();
		}
	
		setMedioValor(aux / l.getLances().size());

		pegaOmaioresNumeros(l);
	}

	private void pegaOmaioresNumeros(Leilao l) {
		maiores = new ArrayList<Lance>(l.getLances());

		Collections.sort(maiores, new Comparator<Lance>() {
			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor())
					return 1;
				if (o1.getValor() > o2.getValor())
					return -1;
				return 0;
			}
		});
		
		maiores = maiores.subList(0, maiores.size()>3 ? 3 : maiores.size());
	}

	public List<Lance> getTresMaiores() {
		return maiores;
	}

	public Double getMaiorValor() {
		return maiorValor;
	}

	public void setMaiorValor(Double maiorValor) {
		this.maiorValor = maiorValor;
	}

	public Double getMenorValor() {
		return menorValor;
	}

	public void setMenorValor(Double menorValor) {
		this.menorValor = menorValor;
	}

	public Double getMedioValor() {
		return medioValor;
	}

	public void setMedioValor(Double medioValor) {
		this.medioValor = medioValor;
	}

	public List<Lance> getMaiores() {
		return maiores;
	}

	public void setMaiores(List<Lance> maiores) {
		this.maiores = maiores;
	}

	
}

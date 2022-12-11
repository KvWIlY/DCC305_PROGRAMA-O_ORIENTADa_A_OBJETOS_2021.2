package Cachorro;

import java.util.Random;

public class PastorAlemao extends Cachorro {
	public PastorAlemao() {
		setRaca("Pastor Alemao");
		setComportamento(" Energetico e Ativo");
		setTemperamento(" Calmo e Equilibrado");
		this.gerarCor();
	}
	
	@Override 
	public void latir () {
		System.out.println("Latido: Moderado");
	}
	
	public void gerarCor () {
		
		Random r1 = new Random ();
		
		int cores = r1.nextInt(6);
		
		switch (cores) {//funcao que gera randomicamente o pelo do cachorro
		case 0: 
			this.setCorPelo("Cor: Ruivo");
			break;
		case 1: 
			this.setCorPelo("Cor: Branco");
			break;
		case 2: 
			this.setCorPelo("Cor: Preto com Cinza");
			break;
		case 3: 
			this.setCorPelo("Cor: Malhado");
			break;
		case 4: 
			this.setCorPelo("Cor: Marrom");
			break;
		case 5: 
			this.setCorPelo("Cor: Preto");
			break;
		
		} 	
	}
}

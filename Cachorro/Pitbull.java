package Cachorro;

import java.util.Random;

public class Pitbull extends Cachorro {
	public Pitbull() {
		setRaca("Pitbull");
		setComportamento(" Energetico e Inquieto");
		setTemperamento(" Docil e Leal");
		this.gerarCor();
	}
	
	@Override 
	public void latir () {
		System.out.println("Latido: Silencioso");
	}
	
	public void gerarCor () {//funcao que gera randomicamente o pelo do cachorro
		
		Random r1 = new Random ();
		
		int cores = r1.nextInt(8);
		
		switch (cores) {
		case 0: 
			this.setCorPelo("Cor: Tigrada");
			break;
		case 1: 
			this.setCorPelo("Cor: Branco");
			break;
		case 2: 
			this.setCorPelo("Cor: Ferrugem");
			break;
		case 3: 
			this.setCorPelo("Cor: Vermelha");
			break;
		case 4: 
			this.setCorPelo("Cor: Castanho");
			break;
		case 5: 
			this.setCorPelo("Cor: Preto");
			break;
		case 6: 
			this.setCorPelo("Cor: Marrom");
			break;
		case 7: 
			this.setCorPelo("Cor: Cinzento");
			break;
		
		
		} 
	}
}

package Cachorro;

import java.util.Random;

public class Pinscher extends Cachorro {
	public Pinscher() {
		setRaca("Pinscher");
		setComportamento(" Afetuoso e Brincalhão");
		setTemperamento(" Ativo e Energetico");
		this.gerarCor();
	}
	
	@Override 
	public void latir () {
		System.out.println("Latido: Inteso");
	}
	public void gerarCor () {//funcao que gera randomicamente o pelo do cachorro
		
		Random r1 = new Random ();
		
		int cores = r1.nextInt(2);
		
		switch (cores) {
		case 0: 
			this.setCorPelo("Cor: Creme");
			break;
		case 1: 
			this.setCorPelo("Cor: Vermelho");
			break;
		} 
	}
}
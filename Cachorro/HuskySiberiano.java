package Cachorro;
import java.util.Random;

public class HuskySiberiano extends Cachorro {
	public HuskySiberiano() {
		setRaca("Husky Siberiano");
		setComportamento(" Inquieto e Destrutivo");
		setTemperamento(" Amigavel, Ativo e Gosta de Brincar");
		this.gerarCor();
	}
	
	@Override 
	public void latir () {
		System.out.println("Uivo: Inteso");
	}	
		public void gerarCor () {//funcao que gera randomicamente o pelo do cachorro
		
		Random r1 = new Random ();
		
		int cores = r1.nextInt(8);
		
		switch (cores) {
		case 0: 
			this.setCorPelo("Cor: Branco");
			break;
		case 1: 
			this.setCorPelo("Cor: Branco com Preto");
			break;
		case 2: 
			this.setCorPelo("Cor: Preto");
			break;
		case 3: 
			this.setCorPelo("Cor: Cinza");
			break;
		case 4: 
			this.setCorPelo("Cor: Marrom");
			break;
		case 5: 
			this.setCorPelo("Cor: Amarelo");
			break;
		case 6: 
			this.setCorPelo("Cor: Preto");
			break;
		case 7: 
			this.setCorPelo("Cor: Cobre");
			break;
		case 8: 
			this.setCorPelo("Cor: Marrom com Branco");
			break;
		
		} 
	}
}
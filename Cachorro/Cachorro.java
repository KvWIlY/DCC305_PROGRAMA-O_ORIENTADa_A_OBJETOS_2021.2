package Cachorro;
public class Cachorro {
	//atributos
	private String nomeCachorro; 
	private String nomeDono;
	
	private String pelo;
	private String corPelo;
	private String focinho;
	private String raca;
	private String sentimentos;
	private String comportamento;
	private String temperamento;
	
	//getters e setters
	public String getSentimentos() {
		return sentimentos;
	}
	public void setSentimentos(String sentimentos) {
		this.sentimentos = sentimentos;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getNomeCachorro() {
		return nomeCachorro;
	}
	public void setNomeCachorro(String nomeCachorro) {
		this.nomeCachorro = nomeCachorro;
	}
	public String getNomeDono() {
		return nomeDono;
	}
	
	public void setMudarDono(String nomeDono) {
		System.out.println("O cachorro mudou de dono!");
		this.nomeDono = nomeDono;
	}
	
	public String getPelo() {
		return pelo;
	}
	public void setPelo(String pelo) {
		this.pelo = pelo;
	}
	public String getCorPelo() {
		return corPelo;
	}
	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}
	public String getFocinho() {
		return focinho;
	}
	public void setFocinho(String focinho) {
		this.focinho = focinho;
	}
	public String getComportamento() {
		return comportamento;
	}
	public void setComportamento(String comportamento) {
		this.comportamento = comportamento;
	}
	public String getTemperamento() {
		return temperamento;
	}
	public void setTemperamento(String temperamento) {
		this.temperamento = temperamento;
	}
	
	//metodos 
	public void correr (){
		System.out.println("Cachorro correndo");
	}
	public void passear (){
		System.out.println("Dono passeando com o cachorro");
	}
	public void adoeceu (){
		System.out.println("O cachorro ficou doente :(");
	}
	public void acidente (){
		System.out.println("O cachorro se acidentou");
	}
	public void perderPata (){
		System.out.println("O cachorro perdeu uma pata");
	}
	public void latir (){
		System.out.println("O cachorro esta latindo ");
	}

}

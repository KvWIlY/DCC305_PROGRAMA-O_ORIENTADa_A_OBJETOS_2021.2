//definicao da classe

public class Quadrado extends ObjetoGeometrico {
float lado;

public Quadrado(float lado) {
	this.lado = lado;
}

	@Override
	public double calcularArea() {
		return lado * lado;
	}
	
}

//definicao da classe

public class Trapezio extends ObjetoGeometrico {
float baseA, baseB, altura;

public Trapezio(float baseA, float baseB, float altura) {
	this.baseA = baseA;
	this.baseB = baseB;
	this.altura = altura;
}
	
	@Override
	public double calcularArea() {
		
		return ((baseA + baseB)/2) * altura;
	}
}

//definicao da classe

public class Triangulo extends ObjetoGeometrico {
float base, altura;

public Triangulo(float base, float altura) {
	this.base = base;
	this.altura = altura;
}

	@Override
	public double calcularArea() {
		
		return (base * altura) / 2;
	}
}
//definicao da classe

public class Circunferencia extends ObjetoGeometrico {
float raio;
float pi = 3.14f;

public Circunferencia(float raio) {
	this.raio = raio;
}
	@Override
	public double calcularArea() {
		
		return (pi * (raio * raio));
		
	}
}

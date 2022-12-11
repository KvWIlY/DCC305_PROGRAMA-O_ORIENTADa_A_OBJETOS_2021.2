//Main para teste das classes

public class Main {
	public static void main(String[] args) {
		Triangulo triangulo = new Triangulo(7, 3);
		Quadrado quadrado = new Quadrado(5);
		Circunferencia circunferencia = new Circunferencia(6);
		Trapezio trapezio = new Trapezio(6, 2, 4);
		
		System.out.println(triangulo.calcularArea());
		System.out.println(quadrado.calcularArea());
		System.out.printf("%.2f\n", circunferencia.calcularArea());
		System.out.println(trapezio.calcularArea());
	}
}

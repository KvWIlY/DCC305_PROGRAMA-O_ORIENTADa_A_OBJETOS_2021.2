package empresa;

class Calendar {
	
	static int maxMonthsInYear = 12;
	
	private int day;
	private int month;
	private int year;
		
	public Calendar(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String formatedDate() {
		return String.format("%02d/%02d/%d",this.day, this.month, this.year);
	}
	
	public int getDay() { return day; }
	
	public void setDay(int day) { this.day = day; }
	
	public int getMonth() {	return month; }
	
	public void setMonth(int month) { this.month = month; }
	
	public int getYear() {	return year; }
	
	public void setYear(int year) { this.year = year; }
	
}

public class Funcionario {
	
	private String nome;
	private String departamento;
	private double salario;
	private Calendar dataEntrada;
	private String rg;

	
	public Funcionario() {
		this.dataEntrada = new Calendar(0, 0, 0);
	}
	
	// Metodos especificos 
	public boolean aumentarSalario(double aumento){
		
		// resolve o aumento
		this.salario += aumento;
		
		System.out.println("O funcionario "
				+this.nome+" recebeu "
				+aumento+" de bonificacao!"
		);
		
		return true;
		
	}
	
	double ganhosAnuais() {		
		return this.salario * Calendar.maxMonthsInYear;		
	}
	
	void mostraInfos() {
		System.out.println("=== Funcionario: "+this.nome+" ===");
		System.out.println("= Nome: "+this.nome);
		System.out.println("= Departamento: "+this.departamento);
		System.out.println("= Salario: "+this.salario);
		System.out.println("= Data de entrada: ");
		System.out.println("= \tDia: "+this.dataEntrada.getDay());
		System.out.println("= \tMes: "+this.dataEntrada.getMonth());
		System.out.println("= \tAno: "+this.dataEntrada.getYear());
		System.out.println("===================================");
	}
	
	// Getters and Setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Calendar getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
			
}














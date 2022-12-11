package empresa;

public class TestaFuncionario {

	public static void main(String[] args) {
		
		
		Funcionario f1 = new Funcionario();
		f1.setNome("Pedro");
		f1.setSalario(1500);
		f1.aumentarSalario(500);
		f1.setDepartamento("Contabilidade");
		f1.setRg("2135465798");
		f1.setDataEntrada(new Calendar (12,8,2000));
		
		System.out.println("Ganhos anuais: " + f1.ganhosAnuais());
		System.out.println("Salario atual: " + f1.getSalario());
		
		
		f1.mostraInfos();
		
		
		
	}

}

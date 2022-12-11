package Q1E2;
import java.util.Scanner;

public class Interface {
	Scanner in = new Scanner(System.in);   
    String entradaString;  
    int entradaInt;     
    int op;        
    int i;
	Aluno a = new Aluno();      
	public void it1(){
		System.out.println("========== Agenda do estudante ==========");
            System.out.println("Codigo      Operacao");
            System.out.println(" [0]    Sair da agenda");
            System.out.println(" [1]    Mudar informacoes do Aluno");
            System.out.println(" [2]    Inserir Disciplina");
            System.out.println(" [3]    Inserir Atividade/Prova/Seminario");
            System.out.println(" [4]    Inserir quadro de horario\n");
            System.out.println(" [5]    Quadro de horario do aluno");
            System.out.println(" [6]    Disciplinas do aluno");
            System.out.println(" [7]    Pendencias do aluno");
            System.out.println(" [8]    Soma das notas (Disciplina)");
            System.out.println(" [9]    Media das notas (Disciplina)");
            System.out.println(" [10]    Informacoes do aluno\n");
            System.out.println("Digite o codigo da operacao que deseja realizar : ");
	}
	
	public void  f1(){
		System.out.println("========== Agenda do estudante ==========");
        System.out.println("Digite o seu nome : ");
        a.setNome(in.nextLine());
        
        System.out.println("Digite seu curso : ");
        a.setCurso(in.nextLine());
        
        System.out.println("Digite o seu periodo : ");
        try{
            a.setPeriodo(in.nextInt());
            in.nextLine();
        }
        catch(Exception e){
            System.out.println("O valor digitado deve ser inteiro...");
            System.out.println("Digite novamente : ");
            in.nextLine();
            a.setPeriodo(in.nextInt());
            in.nextLine();
        }
        System.out.println("\n");
        do{
            Interface inter1 = new Interface();
            inter1.it1();
            
            op = in.nextInt();
            in.nextLine();
            
            switch(op){
                case 0 -> System.out.println("Volte sempre...");
                case 1 -> {
                    System.out.print("Digite o seu nome : ");
                    a.setNome(in.nextLine());
                    
                    System.out.print("Digite seu curso : ");
                    a.setCurso(in.nextLine());
                    
                    System.out.print("Digite o seu periodo : ");
                    try{
                        a.setPeriodo(in.nextInt());
                        in.nextLine();
                    }
                    catch(Exception e){
                        System.out.println("O valor digitado deve ser inteiro...");
                        System.out.print("Digite novamente : ");
                        in.nextLine();
                        a.setPeriodo(in.nextInt());
                        in.nextLine();
                    }
                    
                    System.out.println("\n");
                }
                case 2 -> {
                    a.showMateriasCode();
                    
                    System.out.println("Digite o codigo da disciplina: ");
                    try{
                    	entradaInt = in.nextInt();
                        a.addMateria(entradaInt);
                        in.nextLine();
                    }
                    catch(Exception e){
                        System.out.println("O valor digitado deve ser inteiro...");
                        System.out.println("Digite novamente : ");
                        in.nextLine();
                        entradaInt = in.nextInt();
                        a.addMateria(entradaInt);
                        in.nextLine();
                    }
                    System.out.println("Digite o nome da disciplina");
                    a.getMateria(entradaInt).setNome(in.nextLine());
                    
                    System.out.println("Digite o nome do professor");
                    a.getMateria(entradaInt).setProfessor(in.nextLine());
                    
                    System.out.println("\n");
                }
                case 3 -> {
                    a.showMateriasCode();
                    
                    System.out.println("Insira o codigo da disciplina : ");
                    try{
                    	entradaInt = in.nextInt();
                        in.nextLine();
                    }
                    catch(Exception e){
                        System.out.println("O valor digitado deve ser inteiro...");
                        System.out.println("Digite novamente : ");
                        in.nextLine();
                        entradaInt = in.nextInt();
                        in.nextLine();
                    }
                    System.out.println("Insira o nome da pendencia : ");
                    entradaString = in.nextLine();
                    a.getMateria(entradaInt).addAtividade(entradaString);
                    
                    System.out.println("Digite o prazo : formato(dd.mm.aaaa)");
                    a.getMateria(entradaInt).getAtividade(entradaString).setDataEntrega(in.nextLine());
                    
                    System.out.println("Digite a nota da pendencia : ");
                    try{
                        a.getMateria(entradaInt).getAtividade(entradaString).setNota(in.nextFloat());
                        in.nextLine();
                    }
                    catch(Exception e){
                        System.out.println("O valor digitado deve ser real...");
                        System.out.println("Digite novamente : ");
                        in.nextLine();
                        a.getMateria(entradaInt).getAtividade(entradaString).setNota(in.nextFloat());
                        in.nextLine();
                    }
                    
                    System.out.println("\n");
                }
                case 4 -> {
                    System.out.println("insira o seu quadro de horarios : ");
                    
                    for(i =0; i < a.getMateria().getLastElement(); i++){
                        System.out.printf("Diciplina %s \n",a.getMateria().getElement(i).getNome());
                        System.out.println("Insira os horarios : ");
                        a.getMateria().getElement(i).addHorario(in.nextLine());
                        System.out.println("Insira os dias da semana\n(Seg / Ter / Qua / Qui / Sex / Sab /Dom) ");
                        a.getMateria().getElement(i).addDias(in.nextLine());
                    }
                    System.out.println("\n");
                }
                case 5 -> a.horario();
                case 6 -> a.printMateria();
                case 7 -> a.getPendencia();
                case 8 -> {
                    a.showMateriasCode();
                    System.out.println("\nDigite o codigo da disciplina : ");
                    
                    try{
                    	entradaInt = in.nextInt();
                        in.nextLine();
                    }
                    catch(Exception e){
                        System.out.println("O valor digitado deve ser inteiro...");
                        System.out.println("Digite novamente : ");
                        in.nextLine();
                        entradaInt = in.nextInt();
                        in.nextLine();
                    }
                    
                    System.out.printf("A soma das notas de %s e : %.2f",a.getMateria(entradaInt).getNome(),a.getMateria(entradaInt).somaNotas());
                    System.out.println("\n");
                }
                case 9 -> {
                    a.showMateriasCode();
                    System.out.println("\nDigite o codigo da disciplina : ");
                    
                    try{
                    	entradaInt = in.nextInt();
                        in.nextLine();
                    }
                    catch(Exception e){
                        System.out.println("O valor digitado deve ser inteiro...");
                        System.out.println("Digite novamente : ");
                        in.nextLine();
                        entradaInt = in.nextInt();
                        in.nextLine();
                    }
                    
                    System.out.printf("A media das notas de %s e : %.2f",a.getMateria(entradaInt).getNome(),a.getMateria(entradaInt).mediaNotas(a.getMateria(entradaInt).somaNotas(),a.getMateria(entradaInt).getAtividade().getLastElement()));
                    System.out.println("\n");
                }
                case 10 -> a.info();
                default -> System.out.println("Operação invalida!");
            }
            
        } while(op != 0);
	}
}

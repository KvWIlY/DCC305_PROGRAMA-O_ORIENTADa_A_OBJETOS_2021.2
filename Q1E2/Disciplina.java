package Q1E2;

public class Disciplina {
	private String nome;
    private int codigo;
    private final MateriaArray<String> horarios;
    private final MateriaArray<String> diasSemana;
    private String Professor;
    private final MateriaArray<Atividade> atividade;
    
    public void info() {
    	System.out.printf("\n====== Informacoes de %s ======\n",this.nome);
        System.out.printf("Codigo : %d\n",this.codigo);
        System.out.printf("Professor : %s\n\n",this.Professor);
    }
    
    public void addAtividade(String nome) {
    	Atividade x = new Atividade();
    	x.setTitulo(nome);
    	this.atividade.add(x);
    }
    
    public void addHorario(String horario) {this.horarios.add(horario);}
    
    public void addDias(String dias){this.diasSemana.add(dias);}
    
    public void planejamentoSemanal(){
        System.out.printf("Disciplina:  %s",this.getNome());
        System.out.println("Dias da semana : ");
        for(int cont = 0; cont < this.getDiasSemana().getLastElement();cont++){
            System.out.printf("%s ",this.diasSemana.getElement(cont));
        }
        System.out.println("");
        System.out.println("Horarios : ");
        for(int cont = 0; cont < this.horarios.getLastElement();cont++){
            System.out.printf("%s ",this.horarios.getElement(cont));
        }
        System.out.println("\n");
    }
    
    public float somaNotas(){
        float soma = 0;
        for(int cont = 0; cont < this.getAtividade().getLastElement();cont++){
            soma += this.getAtividade().getElement(cont).getNota();
        }return soma;
    }
    
    public float mediaNotas(float soma, float atividades){
        float media = (soma/atividades);
        return media;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Disciplina() {
        this.atividade = new MateriaArray(1);
        this.horarios = new MateriaArray(1);
        this.diasSemana = new MateriaArray(1);
    }
     
    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome; }

    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    public String getProfessor() { return Professor; }

    public void setProfessor(String Professor) {  this.Professor = Professor;}
    
    public MateriaArray<Atividade> getAtividade(){return this.atividade;}
    
    public Atividade getAtividade(String nome){
        int i;
        for(i = 0; i < this.atividade.getLastElement(); i++){
            if(this.atividade.getElement(i).getTitulo().equals(nome)){break;}
        }return this.atividade.getElement(i);
    }

    public MateriaArray<String> getHorarios() {return horarios;}

    public MateriaArray<String> getDiasSemana() {return diasSemana;}
}

package Q1E2;

public class Aluno {
	private String nomeAluno;
	private String curso;
	private int periodo;
	private final MateriaArray<Disciplina> materia;
	
	public void addMateria(int codigin) {
		Disciplina x = new Disciplina();
		x.setCodigo(codigin);
		this.materia.add(x);
	}
	
	public void removeMateria(int codigin) {this.materia.remove(this.getMateria(codigin));}
	
	public void printMateria() {
		if(this.getMateria().getSize() == 1) {
			System.out.println("Não a materias cadastradas...");
			return;
		}
		System.out.println("===== Disciplinas ===== ");
		for(int i = 0; i < this.getMateria().getLastElement(); i++) {
			this.getMateria().getElement(i).info();
		}
	}
	
	public void getPendencia() {
		int i,j;
		if(this.getMateria().getSize() == 1) {
			System.out.println("Não a materias cadastradas...");
			return;
		}
		System.out.println("======== Pendencias ========");
        for(i = 0; i < this.getMateria().getLastElement(); i++){
            System.out.printf("%s : \n",this.getMateria().getElement(i).getNome());
            for(j = 0; j < this.getMateria().getElement(i).getAtividade().getLastElement(); j++){
                this.getMateria().getElement(i).getAtividade().getElement(j).info();
            }
        }
	}
	
	public void horario(){
        int i;
        System.out.println("====== Horarios ======");
        for(i = 0; i < this.getMateria().getLastElement();i++){
            this.getMateria().getElement(i).planejamentoSemanal();
        }
    }
	
	public void info(){
        System.out.println("======== Informacoes do aluno ======== ");
        System.out.printf("Aluno : %s\nCurso : %s\nPeriodo : %d\n",this.nomeAluno,this.curso,this.periodo);
    }
	
	public void showMateriasCode(){
        System.out.println("Disciplinas atuais : ");
        for(int i = 0; i < this.getMateria().getLastElement(); i++){
            System.out.printf("(%s)[%d] ",this.getMateria().getElement(i).getNome(),this.getMateria().getElement(i).getCodigo());
        }
        System.out.println("");
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Aluno() {this.materia = new MateriaArray(1);}
     
    public String getNome() {return nomeAluno;}

    public void setNome(String nome) {this.nomeAluno = nome;}

    public String getCurso() {return curso;}

    public void setCurso(String curso) {this.curso = curso;}

    public int getPeriodo() {return periodo;}

    public void setPeriodo(int periodo) {this.periodo = periodo;}
    
    public Disciplina getMateria(int codigin){
        int i;
        for(i = 0; i < this.materia.getLastElement(); i++){
            if(this.materia.getElement(i).getCodigo() == codigin){
                break;}
        } return this.materia.getElement(i);
    }
    
    public MateriaArray<Disciplina> getMateria(){return this.materia;}
}

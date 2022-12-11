package Q1E2;

public class Atividade{
	private String titulo;
    private String dataEntrega;
    private float nota;
    
    public void info(){
        System.out.printf("%s\n",this.titulo);
        System.out.printf("prazo : %s\n",this.dataEntrega);
        System.out.printf("nota : %.2f\n\n",this.nota);
    }
    
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getDataEntrega() {return dataEntrega;}
    public void setDataEntrega(String dataEntrega) {this.dataEntrega = dataEntrega;}

    public float getNota() {return nota;}
    public void setNota(float nota) {this.nota = nota;}
}

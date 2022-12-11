package Rato;
import java.util.ArrayList;

public class Celula {
    static public Celula destino;

    int x;
    int y;
    int H;
    int G;
    int F;
    ArrayList<Celula> adjCelulas;

    Celula(){};

    Celula(int x, int y){
        this.x = x;
        this.y = y;
        this.adjCelulas = new ArrayList<>();
    };
    
    public double dist(Celula c){
        return Math.pow((c.x - x), 2) + Math.pow((c.y - y), 2);
    }

    public int custoG(int antG){
        G = antG + 1;
        return G;
    }

    public int custoH(){
        int custoH = 0;
        // determina se esta abaixo ou acima
        boolean estaAcima = y < destino.y;
        // determina se estou a esquerda do destino
        boolean estaEsquerda = x < destino.x;

        int _y = y;
        if(estaAcima){
            while(_y < destino.y){
                custoH++;
                _y++;
            }
        } else {
            while(_y > destino.y){
                custoH++;
                _y--;
            } 
        } 

        int _x = x;
        if(estaEsquerda){
            while(_x < destino.x){
                custoH++;
                _x++;
            }
        } else {
            while(_x > destino.y){
                custoH++;
                _x--;
            } 
        } 
        
        H = custoH;
        return H;
    }

    public int custoF(){
        F = G + H;
        return F;
    }

    public void position(){
        System.out.println("Cell("+x+","+y+")");
    }

    public boolean isDestino(){
        return x == destino.x && y == destino.y;
    }

    public boolean comparator(Celula celula){
        return celula.x == x && celula.y == y;
    }

}


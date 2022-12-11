package Rato;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Random;

class CellComparatorA implements Comparator<Celula> {
    @Override
    public int compare(Celula a, Celula b) {
        return a.F < b.F ? 1 : -1;
    }
}

class CellComparatorB implements Comparator<Celula> {
    @Override
    public int compare(Celula a, Celula b) {
        return a.F > b.F ? 1 : -1;
    }
}

public class Rato implements Runnable {
    
    private int ID = -1;

    char[][] mapaClone;

    private Random r = new Random();

    // celula inicial
    Celula posicaoAtual;

    PriorityQueue<Celula> abertos;
    Stack<Celula> fechados = new Stack<>();
    Stack<Celula> endline = new Stack<>();
    Celula[][] mapaCelulas = new Celula[Constants.mapa.length][Constants.mapa[0].length];
    
    Rato(int x, int y){
        
        this.posicaoAtual = new Celula(x, y);
        r.setSeed(System.currentTimeMillis() * r.nextInt(5));

        mapaClone = Constants.mapaClone();

        int n = r.nextInt(10);
        if(n > 5 && n % 2 == 0)
            abertos = new PriorityQueue<Celula>(new CellComparatorA());
        else
            abertos = new PriorityQueue<Celula>(new CellComparatorB());
        this.posicaoAtual = new Celula(x, y);
    }

    public void setId(int id){
        this.ID = id;
    }

    private void pausa(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeCells(){
        char[][] mapa = Constants.mapa;

        Celula.destino = new Celula(26, 8);
        for(int y = 0; y < mapa.length; y++){
            for(int x = 0; x < mapa[0].length; x++){                
                Celula celula = new Celula(x, y);
                mapaCelulas[y][x] = celula;
            }
        }

        for(int y = 0; y < mapa.length; y++){
            for(int x = 0; x < mapa[0].length; x++){    
                
                if((y+1 < mapa.length) && Constants.tokenComparator(mapa[y+1][x]))
                    mapaCelulas[y][x].adjCelulas.add(mapaCelulas[y+1][x]);
                if((x+1 < mapa[0].length) && Constants.tokenComparator(mapa[y][x+1]))
                    mapaCelulas[y][x].adjCelulas.add(mapaCelulas[y][x+1]);
                if((y-1 >= 0) && Constants.tokenComparator(mapa[y-1][x]))
                    mapaCelulas[y][x].adjCelulas.add(mapaCelulas[y-1][x]);
                if((x-1 >= 0) && Constants.tokenComparator(mapa[y][x-1]))
                    mapaCelulas[y][x].adjCelulas.add(mapaCelulas[y][x-1]);
                    
            }
        }
    }

    public void start() {
        makeCells();
        // no inicial
        int x = posicaoAtual.x;
        int y = posicaoAtual.y;
        posicaoAtual = mapaCelulas[y][x];
        posicaoAtual.G = 0; // G inicial
    }

    public boolean heuristica(){

        int n = r.nextInt(100);
        if(n % 2 == 0 && n > 50) 
            return false;

        if(posicaoAtual.isDestino()) return true;

        // o proprio valor inicial entra na lista aberta
        abertos.add(posicaoAtual);  
        
        mapaClone[posicaoAtual.y][posicaoAtual.x] = '+';

        boolean caminhoSemSaida = true;
        // adicionando todos os adjacentes do valor inicial na lista aberta
        for(Celula node : posicaoAtual.adjCelulas){
            if(!fechados.contains(node) && !endline.contains(node)) {
                caminhoSemSaida = false;
                // antes de adicionar na lista vou calcular o custo G, H e F
                node.custoG(posicaoAtual.G);
                node.custoH();
                node.custoF();
                abertos.add(node);
            }
        }

        for(Celula node : abertos){
            double d = node.dist(posicaoAtual);
            if(d > 1) abertos.remove(node);
        }

        abertos.remove(posicaoAtual);
        fechados.add(posicaoAtual); 

        if(caminhoSemSaida) {
            Stack<Celula> fechadosClone = Constants.stackClone(fechados);
            
            Celula c = fechadosClone.pop();          
            endline.push(c);
            fechados.remove(c);

            while(!fechadosClone.empty()){
                boolean achouSaida = false;

                posicaoAtual = fechadosClone.pop();
                endline.push(posicaoAtual);
                fechados.remove(posicaoAtual);

                for(Celula node : posicaoAtual.adjCelulas){
                    if(!fechados.contains(node)){
                        achouSaida = true;                        
                        break;                    
                    }
                } 
                pausa(Constants.TIME_SLEEP_RATO);
                if(achouSaida) return false;       
            }
        }
        posicaoAtual = abertos.poll();         
        return false;
    }   

    Celula getPos(){
        return this.posicaoAtual;
    }

    @Override
    public void run() {
        start();
        
    
        while(!heuristica() && !Constants.STOP)
            pausa(Constants.TIME_SLEEP_RATO);
        Constants.STOP = true;

        pausa(this.ID * 250);
        System.out.println("Rato: " + this.ID);
        Constants.desenhaMapa(mapaClone);
    }
}

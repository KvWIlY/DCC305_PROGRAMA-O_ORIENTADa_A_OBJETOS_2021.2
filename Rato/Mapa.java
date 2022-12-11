package Rato;

import java.io.IOException;
import java.util.ArrayList;

public class Mapa implements Runnable {

    ArrayList<Rato> ratos = new ArrayList<>();

    private void limpaTela(){
        if (System.getProperty("os.name").contains("Windows")){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void pausa(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(!Constants.STOP){
            char[][] mapa = Constants.mapaClone();
            update(mapa);
            draw(mapa);
            pausa(Constants.TIME_SLEEP_MAPA);
            limpaTela();
        }
        System.out.println("Finalizado");
    }

    public void update(char[][] mapa) {
        for(int id = 0; id < ratos.size(); id++){
            Rato r = ratos.get(id);    
            r.setId(id+1);                    
            mapa[r.getPos().y][r.getPos().x] = (char)(id + '0');
        }

    }

    public void draw(char[][] mapa) {   
        for(int y = 0; y < mapa.length; y++){
            for(int x = 0; x < mapa[0].length; x++){                              
            Constants.skin(mapa[y][x]); //Rodar de preferencia no vscode!!
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {

        Rato ratoA = new Rato(1, 0);
        Rato ratoB = new Rato(1, 0);
        Rato ratoC = new Rato(1, 0);
       

        Thread tRatoA = new Thread(ratoA);
        Thread tRatoB = new Thread(ratoB);
        Thread tRatoC = new Thread(ratoC);
    

        Mapa mapa = new Mapa();    
        mapa.ratos.add(ratoA);
        mapa.ratos.add(ratoB);
        mapa.ratos.add(ratoC);
        
        Thread tMapa = new Thread(mapa);
        
        tMapa.start();
        tRatoA.start();
        tRatoB.start();
        tRatoC.start();
        
    }

}

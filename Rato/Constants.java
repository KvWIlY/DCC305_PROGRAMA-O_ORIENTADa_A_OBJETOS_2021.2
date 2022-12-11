package Rato;

import java.util.Stack;

public class Constants {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
	//private static final String ANSI_RED = "\u001B[31m";
    //private static final String ANSI_GREEN = "\u001B[32m";
	//private static final String ANSI_YELLOW = "\u001B[33m";
    //private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    //private static final String ANSI_CYAN = "\u001B[36m";
    //private static final String ANSI_WHITE = "\u001B[37m";
    
    //private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    //private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    //private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    //private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    static boolean STOP         = false;
    static char TOKEN_LIBERADO  = ' ';
    static char TOKEN_PAREDE    = '*';
    static char TOKEN_SAIDA     = 'S';
    static char TOKEN_ENTRADA   = 'E';
    static int  TIME_SLEEP_MAPA = 250;
    static int  TIME_SLEEP_RATO = 500;
    static int  NRATOS          = 1;
    static char[][] mapa = {
        {'*','E','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
        {'*',' ','*',' ',' ',' ',' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','*'},
        {'*',' ','*','*','*','*','*',' ',' ',' ','*',' ',' ',' ','*','*','*','*','*','*','*','*',' ','*','*','*','*',' ','*',' ','*',' ','*'},
        {'*',' ',' ',' ',' ',' ',' ',' ','*',' ',' ',' ','*',' ',' ',' ',' ','*',' ',' ',' ',' ',' ','*',' ',' ',' ',' ','*',' ','*',' ','*'},
        {'*',' ','*','*','*','*','*','*','*',' ','*',' ','*','*','*','*',' ','*',' ','*','*','*','*','*','*','*','*','*','*',' ',' ',' ','*'},
        {'*',' ',' ',' ',' ',' ','*',' ',' ',' ','*',' ','*',' ',' ',' ',' ',' ',' ',' ','*',' ',' ','*',' ',' ',' ',' ','*','*','*',' ','*'},
        {'*',' ','*','*','*','*','*',' ','*','*','*',' ','*',' ','*','*',' ','*','*',' ',' ',' ','*','*',' ','*','*',' ',' ','*','*',' ','*'},
        {'*',' ',' ',' ',' ',' ',' ',' ','*',' ',' ',' ','*',' ','*',' ',' ',' ',' ',' ','*',' ',' ',' ',' ','*',' ',' ','*',' ',' ',' ','*'},
        {'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','S','*','*','*','*','*','*'}
    };

    static private void resetColor(){
        System.out.print(ANSI_RESET);
    }

    static private void charColor(String color, char c){
        System.out.print(color + c);
        resetColor();
    }

    static public void skin(char c){
        if(c == TOKEN_PAREDE)
            charColor(ANSI_RED_BACKGROUND, c);
        else if(c == TOKEN_LIBERADO)
            charColor(ANSI_WHITE_BACKGROUND, c);
        else if(c == TOKEN_ENTRADA)
            charColor(ANSI_GREEN_BACKGROUND+ANSI_BLACK, c);
        else if(c == TOKEN_SAIDA)
            charColor(ANSI_YELLOW_BACKGROUND+ANSI_BLACK, c);
        else
            charColor(ANSI_PURPLE, c);
    }

    static char[][] mapaClone(){
        char[][] _mapa = new char[mapa.length][mapa[0].length];
        for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[0].length; j++){
                _mapa[i][j] = mapa[i][j];
            }
        }
        return _mapa;
    }

    static Stack<Celula> stackClone(Stack<Celula> stack){
        Stack<Celula> _stack = new Stack<>();
        for(Celula celula : stack)
            _stack.add(celula);
        return _stack;
    }

    static boolean tokenComparator(char tokenA){
        return ((tokenA == TOKEN_LIBERADO) || (tokenA == TOKEN_SAIDA)) && !(tokenA == TOKEN_ENTRADA);
    }

    static void desenhaMapa(char[][] mapa) {
        for(int y = 0; y < mapa.length; y++){
            for(int x = 0; x < mapa[0].length; x++){
                System.out.print(mapa[y][x]);
            }
            System.out.println();
        }
    }
}

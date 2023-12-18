package codsoft.numbers.game;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScan;

    private int turns;

    private boolean quit = false;


    public Player(int maxAttempts){
        this.inputScan = new Scanner(System.in);
        this.turns = maxAttempts;
    }


    public boolean isQuit(){
        return this.quit;
    }

    public void decrementTurns(){
        turns--;
    }
}
    


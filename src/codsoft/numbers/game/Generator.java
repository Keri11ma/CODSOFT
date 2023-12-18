package codsoft.numbers.game;
import java.util.Random;
public class Generator {
    private final Random random;

    private final int range;

    public Generator(int range){
        this.random = new Random();
        this.range = range;
    }



    public int generateCode(){

        return random.nextInt(range) + 1;
    }
}

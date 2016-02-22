
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 22.02.2016.
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        generate(data, 1000, 100);

    }

    public static void generate(ArrayList target, int pointer, int max){
        Random random = new Random();
        for (int i=0; i<pointer; i++){
            int value = random.nextInt(max);
        }


    }
}

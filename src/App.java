import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by User on 22.02.2016.
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> data = new ArrayList<>();
        generate(data, 10000, 100);
        System.out.println(data.size()+" fuck");
        IntegerMultithreadSorter ims = new IntegerMultithreadSorter(data);
        List<Integer> resultData = ims.calculate();
        System.out.println(resultData.toArray());
    }

    public static void generate(ArrayList target, int capacity, int maxValue){
        Random random = new Random();
        for (int i=0; i<capacity; i++){
            int value = random.nextInt(maxValue);
            target.add(value);
        }


    }
}

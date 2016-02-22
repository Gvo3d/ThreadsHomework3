import java.util.ArrayList;

/**
 * Created by User on 22.02.2016.
 */
public class SorThread implements Runnable{
    ArrayList<Integer> data;
    ArrayList<Integer> result;

    public SorThread(ArrayList<Integer> data, ArrayList<Integer> result) {
        this.data = data;
        this.result = result;
    }

    @Override
    public void run() {

    }
}

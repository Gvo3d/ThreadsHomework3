import java.util.ArrayList;

/**
 * Created by User on 22.02.2016.
 */
public class SorterClass implements Runnable{
    ArrayList<Integer> data;
    private int cpus;
    ArrayList<Integer> result;
    ArrayList<SorThread> runnable = new ArrayList<>();
    Exe

    public SorterClass(ArrayList<Integer> data) {
        this.data = data;
        Runtime runt= Runtime.getRuntime();
        cpus = runt.availableProcessors();
    }

    @Override
    public void run() {
        int tempPer = data.size()/cpus;
        int tempLeft=0;
        for (int i=0; i<cpus; i++){
            ArrayList<Integer> smallData = new ArrayList<>();
            for (int j=tempLeft; j<(tempLeft+tempPer); j++){
                smallData.add(data.get(j));
                tempLeft++;
            }
            runnable.add()
        }

    }
}

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by User on 22.02.2016.
 */
public class SortingThread implements Callable<List<Integer>> {
    private List<Integer> data;

    public SortingThread(List<Integer> data) {
        this.data = data;
    }

    @Override
    public List<Integer> call() throws Exception {
        data.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1<o2) return -1;
                if (o1>o2) return 1;
                return 0;
            }
        });
        System.out.println("threadended");
        return data;
    }
}

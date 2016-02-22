import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by User on 22.02.2016.
 */
public class IntegerMultithreadSorter {
    private List<Integer> data;
    private int cpus;
    private ArrayList<Callable> runnable = new ArrayList<>();
    private ForkJoinPool pool = new ForkJoinPool();

    public IntegerMultithreadSorter(List<Integer> data) {
        this.data = data;
        Runtime runt = Runtime.getRuntime();
        cpus = runt.availableProcessors();
    }

    public List<Integer> calculate() throws ExecutionException, InterruptedException {
        createThreadsPool();
        ArrayList<Future<List<Integer>>> futures = new ArrayList<>(cpus-1);
        ExecutorService service = Executors.newFixedThreadPool(cpus-1);
        int i=0;
        for (Future<List<Integer>> fut:futures){
            fut = service.submit(runnable.get(i));
            System.out.println("threadstart");
            i++;
        }
        i=0;
        ArrayList<List<Integer>> resultData= new ArrayList<>();
        for (Future fut:futures){
            resultData.add((List<Integer>) fut.get());
            i++;
        }
        List<Integer> result = sortResultArrays(resultData);
        return result;
    }

    private void createThreadsPool() {
        int threadDataCapacity = data.size() / cpus;
        int temporaryStepValue = 0;
        for (int i = 0; i < cpus; i++) {
            List<Integer> oneThreadData;
            if (i<cpus-1){
                oneThreadData = data.subList(temporaryStepValue, threadDataCapacity);
            } else {
                int ending=(data.size());
                oneThreadData = data.subList(temporaryStepValue, ending-1);
            }
            runnable.add(new SortingThread(oneThreadData));
            temporaryStepValue += threadDataCapacity;
        }
    }

    private List<Integer> sortResultArrays(List<List<Integer>> result){
        TempSortObject tso;
        int arraysQuantity = result.size();
        ArrayList<LinkedList<Integer>> resultData = new ArrayList<>(arraysQuantity);
        LinkedList<Integer> sortResult = new LinkedList<>();
        for (int i=0; i<result.size(); i++){
            int tempSize = result.get(i).size();
            LinkedList<Integer> temp = new LinkedList<>();
            temp.addAll(result.get(i));
            resultData.add(temp);
        }
        System.out.println("resultData is "+resultData.size());
        for (int i=0; i<data.size()-1; i++){
            tso=null;
            for (LinkedList<Integer> oneOfTheArrays:resultData){
                if (tso==null) {
                    tso = new TempSortObject(oneOfTheArrays);
                } else if ((oneOfTheArrays.getFirst()!=null)&&(oneOfTheArrays.getFirst()<tso.getData().getFirst())) {
                    tso = new TempSortObject(oneOfTheArrays);
                }
            }
            sortResult.add(tso.getData().pollFirst());
        }
        return sortResult;
    }
}

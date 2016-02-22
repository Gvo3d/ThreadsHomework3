import java.util.LinkedList;

/**
 * Created by Gvozd on 22.02.2016.
 */
public class TempSortObject {
    LinkedList<Integer> data;

    public TempSortObject(LinkedList<Integer> data) {
        this.data = data;
    }

    public LinkedList<Integer> getData() {
        return data;
    }

    public void setData(LinkedList<Integer> data) {
        this.data = data;
    }
}

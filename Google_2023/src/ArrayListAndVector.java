import java.util.ArrayList;
import java.util.Vector;

public class ArrayListAndVector {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        vector.add(null);
        arrayList.add(1);
        System.out.println(arrayList);
        System.out.println(vector);
    }
}

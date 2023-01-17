import java.util.concurrent.atomic.AtomicInteger;

interface ArrayReader {
      int get(int index);
 }

public class ArrayReaderInteractiveProblem {
 private final static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(i.getAndIncrement());
        System.out.println(i.get());
    }
}

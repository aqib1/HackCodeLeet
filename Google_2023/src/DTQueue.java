import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Objects;

// FIFO data structure
public class DTQueue<T> {
    private DTQueue<T> head;
    private DTQueue<T> tail;
    private int size;
    private T value;

    public DTQueue() {
        this(null);
    }

    public DTQueue(T value) {
        this(value, null);
    }

    public DTQueue(T value, DTQueue<T> tail) {
        this.value = value;
        this.tail = tail;
    }

    public T enqueue(T value) {
        addElement(value);
        ++size;
        return value;
    }

    public T dequeue() {
        if(size == 0) throw new NoSuchElementException("Queue is empty");

        T first = this.head.value;
        this.head = this.head.tail;
        --size;
        return first;
    }

    private void addElement(T value) {
        DTQueue<T> queue = new DTQueue<>(value);
        if(Objects.isNull(head)) {
            head = tail = queue;
        } else {
              this.tail.tail = queue;
              this.tail = this.tail.tail;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{ ");
        DTQueue<T> pointer = this.head;
        while(!Objects.isNull(pointer)) {
            sb.append(pointer.value).append(" ");
            pointer = pointer.tail;
        }
        sb.append(" }");
        return sb.toString();
    }

    public static void main(String[] args) {
        DTQueue<Integer> dtQueue = new DTQueue<>();
        dtQueue.enqueue(1);
        dtQueue.enqueue(2);
        dtQueue.enqueue(3);
        System.out.println(dtQueue);
        System.out.println(dtQueue.dequeue());
        System.out.println(dtQueue.dequeue());
        System.out.println(dtQueue.dequeue());
//        System.out.println(dtQueue.dequeue());
        System.out.println(dtQueue);
    }
}

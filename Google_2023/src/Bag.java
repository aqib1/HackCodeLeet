import java.util.Objects;

public class Bag<T> {
    private T value;
    private Bag<T> previous;
    private int size;

    public Bag() {
        this(null, null);
    }

    public Bag(T value, Bag<T> previous) {
        this.value = value;
        this.previous = previous;
    }

    public T add(T value) {
        addElement(value);
        return value;
    }

    private void addElement(T value) {
        this.previous = new Bag<>(value, this.previous);
        this.value = value;
        size++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{ ");
        Bag<T> pointer = this.previous;
        while(!Objects.isNull(pointer)) {
            sb.append(pointer.value).append(" ");
            pointer = pointer.previous;
        }
        sb.append(" }");
        return sb.toString();
    }


    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);

        System.out.println(bag);
    }
}

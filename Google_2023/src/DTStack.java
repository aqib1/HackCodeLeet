import java.util.*;

public class DTStack<T> implements Iterable<T> {
    private T value;
    private DTStack<T> previous;
    private DTStack<T> iteratorReference;
    private int size = 0;

    public DTStack() {
        this(null);
    }

    public DTStack(T value) {
        this(value, null);
    }

    public DTStack(T value, DTStack<T> previous) {
        this.value = value;
        this.previous = previous;
    }

    public T push(T value) {
        addElement(value);
        size++;
        return value;
    }

    public T pop() {
        if(size == 0) throw new EmptyStackException();
        T value = this.value;
        this.previous = this.previous.previous;
        size--;
        return value;
    }

    private void addElement(T value) {
        this.previous = new DTStack<>(value, this.previous);
        this.value = value;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if(Objects.isNull(this.previous)) return "{ }";
        final StringBuilder sb = new StringBuilder("{ ");
        DTStack<T> pointer = this.previous;
        while(!Objects.isNull(pointer)) {
            sb.append(pointer.value).append(" ");
            pointer = pointer.previous;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>() {
            int elementToRead = size;
            private DTStack<T> iteratorReference = previous;
            @Override
            public boolean hasNext() {
                return elementToRead != 0;
            }

            @Override
            public T next() {
                if(Objects.isNull(iteratorReference)) throw new NoSuchElementException();
                T value = this.iteratorReference.value;
                --elementToRead;
                this.iteratorReference = this.iteratorReference.previous;
                return value;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }
        };
    }

    public static void main(String[] args) {
        DTStack<Integer> dtStack = new DTStack<>();
        dtStack.push(1);
        dtStack.push(2);
        dtStack.push(3);
//        System.out.println(dtStack);

        for (Integer integer : dtStack) {
            System.out.println(integer);
        }

        System.out.println("POP -> " + dtStack.pop());

        for (Integer integer : dtStack) {
            System.out.println(integer);
        }


    }
}

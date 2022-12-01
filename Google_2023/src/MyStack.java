import java.util.Objects;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        // Stack in java is a LIFO data structure
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(12);
        stack.push(1111);
        System.out.println(stack.pop());

        // Let's Create our own Stack data structure.
        DSStack<Integer> dsStack = new DSStack<>();
        dsStack.push(1);
        dsStack.push(23);
        dsStack.push(111);
        System.out.println(dsStack);
        System.out.println(dsStack.pop());
        System.out.println(dsStack);
    }
}
class DSStack<T> {
    private T value;
    private DSStack<T> previous;

    public DSStack() {
        this(null);
    }

    public DSStack(T value) {
        this(value, null);
    }

    public DSStack(T value, DSStack<T> previous) {
        this.value = value;
        this.previous = previous;
    }

    // O(1)
    public T push(T value) {
        addElement(value);
        return value;
    }

    // O(1)
    public T pop() {
        T current = this.value;
        this.previous = this.previous.previous;
        this.value = this.previous.value;
        return current;
    }

    private void addElement(T value) {
       this.previous = new DSStack<>(value, this.previous);
       this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[ ");
        DSStack<T> pointer = previous;
        while(!Objects.isNull(pointer)) {
            sb.append(pointer.value).append(" ");
            pointer = pointer.previous;
        }
        sb.append("]");

        return sb.toString();
    }
}
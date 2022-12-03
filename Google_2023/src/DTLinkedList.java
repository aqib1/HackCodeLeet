import java.util.NoSuchElementException;
import java.util.Objects;

public class DTLinkedList<T> {
    private Node<T> current;
    private int size;
    public DTLinkedList() {

    }

    public T push(T value) {
        addElement(value);
        ++size;
        return value;
    }

    public T pop() {
        if(size == 0) throw new NoSuchElementException("LinkedList is empty");
        T value = this.current.value;
        this.current = this.current.previous;
        this.current.next = null;
        --size;
        return value;
    }

    public T delete(T value) {
        if(size == 0) throw new NoSuchElementException("LinkedList is empty");
        Node<T> pointer = this.current;
        while(!Objects.isNull(pointer)) {
            if(value == pointer.value) {
                delete(pointer);
            }
            pointer = pointer.previous;
        }
        return value;
    }

    // 3 2 1
    private void delete(Node<T> pointer) {
        if(Objects.isNull(pointer.next)) {
            this.current = this.current.previous;
            this.current.next = null;
        } else if(Objects.isNull(pointer.previous)) {
            pointer.next.previous = null;
        } else {
            pointer.previous.next = pointer.next;
            pointer.next.previous = pointer.previous;
        }
    }

    private void addElement(T value) {
        Node<T> node = new Node<>(value);
        if(Objects.isNull(current)) {
            current = node;
        } else {
            current.next = node;
            node.previous = current;
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{ ");
        Node<T> pointer = current;
        while(!Objects.isNull(pointer)) {
            sb.append(pointer.value).append(" ");
            pointer = pointer.previous;
        }

        sb.append(" }");
        return sb.toString();
    }

    class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        DTLinkedList<Integer> dtLinkedList = new DTLinkedList<>();
        dtLinkedList.push(1);
        dtLinkedList.push(2);
        dtLinkedList.push(3);
        System.out.println(dtLinkedList);
        System.out.println(dtLinkedList.delete(2));
        System.out.println(dtLinkedList);

    }
}

import java.util.Arrays;
import java.util.Objects;

public class DSLists {

    static class DList<T> {
        private static final Integer INITIAL_LIMIT = 3;
        private T[] table;
        private int size;
        private int capacity;

        public DList() {
            table = (T[]) new Object[INITIAL_LIMIT];
            capacity = table.length;
            size = 0;
        }

        public T get(int index) {
            Objects.checkIndex(index, size);
            return table[index];
        }

        public T add(T element, int index) {
            Objects.checkIndex(index, size);
            T oldValue = table[index];
            table[index] = element;
            return oldValue;
        }

        public void removeAt(int index) {
            Objects.checkIndex(index, size);
            final int newSize;

            if((newSize = size - 1) > index)
                System.arraycopy(table,
                        index + 1,
                        table,
                        index,
                        newSize - index);

            table[size = newSize] = null;
        }

        public void add(T element) {
            if (size >= capacity) {
                resize();
            }
            table[size++] = element;
        }

        private void resize() {
            capacity += capacity >> 1;
            table = Arrays.copyOf(table, capacity);
        }

        public int getSize() {
            return size;
        }

        public int getCapacity() {
            return capacity;
        }

        public String toString() {
            StringBuilder toString = new StringBuilder("[");
            for(int i = 0; i < size; i++) {
                toString.append(table[i]);
                if(i < size - 1) {
                    toString.append(", ");
                }
            }
            toString.append("]");
            return toString.toString();
        }
    }

    public static void main(String[] args) {
        DList<Integer> dList = new DList<>();
        dList.add(1);
        dList.add(2);
        dList.add(3);
        dList.add(4);
        dList.add(5);


        dList.removeAt(4);
//        dList.add(10, -1);
        System.out.println(dList);
    }
}

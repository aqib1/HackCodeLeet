import java.util.*;
import java.util.stream.IntStream;

public class Graph {
    static class Vertex {
        private int label;
        private Vertex(int label) {
            this.label = label;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return label == vertex.label;
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "label=" + label +
                    '}';
        }
    }

    private Map<Vertex, Set<Vertex>> adjacencyList = new HashMap<>();

    public boolean constructGraphAndCheck(int K, int [] A, int [] B) {
        IntStream.range(0, A.length).forEach(key -> {
            adjacencyList.putIfAbsent(new Vertex(A[key]), new HashSet<>());
            adjacencyList.get(new Vertex(A[key])).add(new Vertex(B[key]));
            adjacencyList.putIfAbsent(new Vertex(B[key]), new HashSet<>());
            adjacencyList.get(new Vertex(B[key])).add(new Vertex(A[key]));
        });



        return checkValidation(K);
    }

    private boolean checkValidation(int k) {
        for(int key = 1; key < k; key++) {
            if((!adjacencyList.containsKey(new Vertex(key)) ||
                    !adjacencyList.containsKey(new Vertex(key + 1)))  ||
                    (!adjacencyList.get(new Vertex(key)).contains(new Vertex(key + 1))
                    && !adjacencyList.get(new Vertex(key + 1)).contains(new Vertex(key)))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println(graph.constructGraphAndCheck(4, new int[] {1, 2, 1, 3}, new int[] {2, 4, 3, 4}));
    }
}

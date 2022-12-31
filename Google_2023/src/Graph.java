import java.util.*;

class Vertex<T> {
    private T data;

    public Vertex(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return ""+data;
    }
}

public class Graph<T> {
    private Map<Vertex<T>, List<Vertex<T>>> graph = new HashMap<>();

    public void addVertex(T t) {
        graph.putIfAbsent(new Vertex<>(t), new ArrayList<>());
    }

    public void removeVertex(T t) {
        Vertex<T> vertex = new Vertex<>(t);
        graph.remove(vertex);
        graph.values().forEach(values -> values.remove(vertex));
    }

    public void addEdge(T t1, T t2) {
        Vertex<T> vertex1 = new Vertex<>(t1);
        Vertex<T> vertex2 = new Vertex<>(t2);

        Optional.ofNullable(graph.get(vertex1))
                .orElseThrow()
                .add(vertex2);

        Optional.ofNullable(graph.get(vertex2))
                .orElseThrow()
                .add(vertex1);
    }

    public void removeEdge(T t1, T t2) {
        Vertex<T> vertex1 = new Vertex<>(t1);
        Vertex<T> vertex2 = new Vertex<>(t2);

        Optional.ofNullable(graph.get(vertex1))
                .orElseThrow()
                .remove(vertex2);

        Optional.ofNullable(graph.get(vertex2))
                .orElseThrow()
                .remove(vertex1);
    }

    public List<Vertex<T>> getAdjVertices(T t) {
        return graph.get(new Vertex<>(t));
    }

    public Set<T> depthFirstTraversal(T root) {
        if(!this.graph.containsKey(new Vertex<>(root))) {
            throw new NoSuchElementException("Root vertex not found for {"+ root+ "}");
        }

        Set<T> visited = new LinkedHashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            T vertex = stack.pop();
            if(!visited.contains(vertex)) {
                visited.add(vertex);
                for(Vertex<T> v : getAdjVertices(vertex)) {
                    stack.push(v.getData());
                }
            }
        }

        return visited;
    }

    public Set<T> breadthFirstTraversal(T root) {
        if(!this.graph.containsKey(new Vertex<>(root))) {
            throw new NoSuchElementException("Root vertex not found for {"+ root+ "}");
        }

        Set<T> visited = new LinkedHashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while(!queue.isEmpty()) {
            T node = queue.poll();
            for(Vertex<T> v : getAdjVertices(node)) {
                if(!visited.contains(v.getData())) {
                    visited.add(v.getData());
                    queue.add(v.getData());
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addVertex("Zoli");
        graph.addVertex("Alex");
        graph.addVertex("Steph");
        graph.addVertex("Bob");
        graph.addVertex("Mark");
        graph.addEdge("Zoli", "Steph");
        graph.addEdge("Zoli", "Alex");
        graph.addEdge("Alex", "Steph");
        graph.addEdge("Alex", "Mark");
        graph.addEdge("Steph", "Bob");
        graph.addEdge("Mark", "Bob");

//        System.out.println(graph.getAdjVertices("Zoli"));
//        System.out.println(graph.depthFirstTraversal("Zoli"));

        System.out.println(graph.breadthFirstTraversal("Zoli"));
    }
}

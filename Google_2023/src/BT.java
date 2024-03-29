import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BT<V> {
    private Node<V> root;

    public BT() {

    }

    // O(Log N) and in worst case it will be O(h) where h is the height of BT
    public void put(Integer key, V value) {
        if(Objects.isNull(root)) {
            this.root = new Node<>(key, value);
        } else {
            put(key, value, root);
        }
    }

    // O(Log N) and in worst case it will be O(h) where h is the height of BT
    public Node<V> get(Integer key) {
        return get(this.root, key);
    }


    // O(Log N) and in worst case it will be O(h) where h is the height if BT
    public Node<V> min() {

        return null;
    }

    private Node<V> get(Node<V> root, Integer key) {
        if(Objects.isNull(root)) return null;
        if(Objects.equals(root.getKey(), key)) return root;

        if(key < root.getKey()) return get(root.left, key);
        else return get(root.right, key);
    }

    private void put(Integer key, V value, Node<V> root) {
        if(key < root.getKey()) {
            if(Objects.isNull(root.left)) {
                root.left = new Node<>(key, value);
            } else {
                put(key, value, root.left);
            }
        } else {
            if(Objects.isNull(root.right)) {
                root.right = new Node<>(key, value);
            } else {
                put(key, value, root.right);
            }
        }
    }

    // O(1)
    public Node<V> peek() {return this.root;}

    // BFS (Breath first Search) O(N) where N are the number of nodes.
    public void bfs() {
        Queue<Node<V>> queue = new LinkedList<>();
        queue.add(this.root);

        while(!queue.isEmpty()) {
            Node<V> node = queue.poll();
            System.out.println("Value -> " + node.value);
            System.out.println("Key -> " + node.key);
            if(!Objects.isNull(node.left)) {
                queue.add(node.left);
            }
            if(!Objects.isNull(node.right)) {
                queue.add(node.right);
            }
        }
    }


    // DFS (Depth First Search)

    // L,N,R - O(N) where N is number of nodes
    public void inOrder() {
        inOrder(this.root);
    }

    // N,L,R - O(N) where N is number of nodes
    public void preOrder() {
        preOrder(this.root);
    }

    // L,R,N - O(N) where N is number of nodes
    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node<V> root) {
        if(Objects.isNull(root)) return;
        inOrder(root.left);
        inOrder(root.right);
        System.out.println("Value -> " + root.value);
        System.out.println("Key -> " + root.key);
    }

    private void preOrder(Node<V> root) {
        if(Objects.isNull(root)) return;
        System.out.println("Value -> " + root.value);
        System.out.println("Key -> " + root.key);
        inOrder(root.left);
        inOrder(root.right);
    }

    private void inOrder(Node<V> root) {
        if(Objects.isNull(root)) return;
        inOrder(root.left);
        System.out.println("Value -> " + root.value);
        System.out.println("Key -> " + root.key);
        inOrder(root.right);
    }

    class Node<V> {
        private Integer key;
        private V value;
        private Node<V> left, right;

        public Node(Integer key, V value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<V> getLeft() {
            return left;
        }

        public void setLeft(Node<V> left) {
            this.left = left;
        }

        public Node<V> getRight() {
            return right;
        }

        public void setRight(Node<V> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("key=").append(key);
            sb.append(", value=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        BT<String> bt = new BT<>();
        bt.put(5, "Aqib");
        bt.put(3, "Ali");
        bt.put(6, "Ahmad");
        bt.put(4, "Fahad");
//        bt.bfs();
        System.out.println(bt.get(16));
    }
}

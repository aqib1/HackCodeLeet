import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BTTree<T> {
	enum BT_TRAVERSAL {
		IN_ORDER, PRE_ORDER, POST_ORDER, SPIRAL_ORDER
	}

	private Node<T> root;

	public void add(T data, int key) {
		if (Objects.isNull(data))
			throw new NullPointerException();
		if (Objects.isNull(root))
			addRoot(data, key);
		else
			addChild(root, data, key);
	}

	private void addChild(Node<T> node, T data, int key) {
		if (key > node.key) {
			// right
			if (Objects.isNull(node.right))
				node.right = new Node<>(key, data);
			else
				addChild(node.right, data, key);

		} else {
			// left
			if (Objects.isNull(node.left))
				node.left = new Node<>(key, data);
			else
				addChild(node.left, data, key);
		}
	}

	private void addRoot(T t, int key) {
		root = new Node<>(key, t);
	}

	public void print(BT_TRAVERSAL bTraversal) {
		switch (bTraversal) {
		case IN_ORDER:
			inOrderTraversal(root);
			break;
		case POST_ORDER:
			postOrderTraversal(root);
			break;
		case PRE_ORDER:
			preOrderTraversal(root);
			break;
		case SPIRAL_ORDER:
			printSpiral(root);
			break;
		default:
			inOrderTraversal(root);
		}
	}

	// n(logn)
	public T find(int key) {
		return search(root, key);
	}

	private T search(Node<T> n, int key) {
		if (n.key == key)
			return n.data;
		if (key > n.key)
			return search(n.right, key);
		else
			return search(n.left, key);
	}

	// Spiral/ZigZag
	public void printSpiral(Node<T> root) {
		Stack<Node<T>> leftToRight = new Stack<>();
		Stack<Node<T>> rightToLeft = new Stack<>();
		leftToRight.push(root);

		while (!leftToRight.isEmpty()) {
			Node<T> node = leftToRight.pop();
			if (!Objects.isNull(node)) {
				System.out.println(node.data);
				rightToLeft.push(node.right);
				rightToLeft.push(node.left);
				while (!rightToLeft.isEmpty()) {
					node = rightToLeft.pop();
					if (!Objects.isNull(node)) {
						System.out.println(node.data);
						leftToRight.push(node.left);
						leftToRight.push(node.right);
					}
				}
			}
		}
	}

	// N-L-R
	public void levelOrderPrintUsingQueue() {
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> root = queue.poll();
			System.out.println(root);
			if (!Objects.isNull(root.left))
				queue.add(root.left);
			if (!Objects.isNull(root.right))
				queue.add(root.right);
		}
	}

	public int height() {
		return height(root);
	}

	private int height(BTTree<T>.Node<T> root) {
		if (Objects.isNull(root))
			return -1;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// L-N-R
	private void inOrderTraversal(Node<T> node) {
		if (Objects.isNull(node))
			return;
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);

	}

	// L-R-N
	private void postOrderTraversal(Node<T> node) {
		if (Objects.isNull(node))
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.data);
	}

	// N-L-R
	private void preOrderTraversal(Node<T> node) {
		if (Objects.isNull(node))
			return;
		System.out.println(node.data);
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
	}

	public static void main(String[] args) {
		BTTree<Integer> bt = new BTTree<Integer>();
		bt.add(3, 8);
		bt.add(12, 4);
		bt.add(11, 10);
		bt.add(8, 6);
		bt.add(81, 3);
		bt.add(78, 12);
//		bt.print(BT_TRAVERSAL.SPIRAL_ORDER);
		System.out.println(bt.height());
	}

	class Node<V> {
		private V data;
		private int key;
		private Node<V> left;
		private Node<V> right;

		public Node() {
		}

		public Node(int key, V data) {
			this.key = key;
			this.data = data;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public void setData(V data) {
			this.data = data;
		}

		public V getData() {
			return data;
		}

		public void setLeft(Node<V> left) {
			this.left = left;
		}

		public Node<V> getLeft() {
			return left;
		}

		public void setRight(Node<V> right) {
			this.right = right;
		}

		public Node<V> getRight() {
			return right;
		}
	}
}

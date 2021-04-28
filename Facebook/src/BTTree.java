import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

enum Traverse {
	BFS, //
	IN_ORDER, //
	PRE_ORDER, //
	POST_ORDER, //
	ZIGZAG //
}

public class BTTree<T> {
	private Node<T> root;

	public void add(int key, T data) {
		if (Objects.isNull(root))
			root = new Node<>(key, data);
		else
			addChild(key, data, root);

	}

	private void addChild(int key, T data, Node<T> root) {
		if (key > root.key) {
			if (Objects.isNull(root.right))
				root.right = new Node<>(key, data);
			else
				addChild(key, data, root.right);
		} else {
			if (Objects.isNull(root.left))
				root.left = new Node<>(key, data);
			else
				addChild(key, data, root.left);
		}

	}

	public void print(Traverse traverse) {
		switch (traverse) {
		case BFS: {
			levelOrder(root);
			break;
		}
		case IN_ORDER: {
			inOrder(root);
			break;
		}
		case PRE_ORDER: {
			preOrder(root);
			break;
		}
		case POST_ORDER: {
			postOrder(root);
			break;
		}
		case ZIGZAG: {
			zigZag(root);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + traverse);
		}
	}

	private void zigZag(Node<T> root) {
		Stack<Node<T>> leftToRight = new Stack<>();
		Stack<Node<T>> rightToLeft = new Stack<>();
		leftToRight.push(root);
		while (!leftToRight.isEmpty()) {
			Node<T> node = leftToRight.pop();
			if (!Objects.isNull(node)) {
				System.out.println(node.key + " = " + node.data);
				rightToLeft.push(node.right);
				rightToLeft.push(node.left);
				if (leftToRight.isEmpty()) {
					while (!rightToLeft.isEmpty()) {
						node = rightToLeft.pop();
						if (!Objects.isNull(node)) {
							System.out.println(node.key + " = " + node.data);
							leftToRight.push(node.left);
							leftToRight.push(node.right);
						}
					}
				}
			}
		}
	}

	private void levelOrder(Node<T> root) {
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			System.out.println(node.key + " = " + node.data);
			if (!Objects.isNull(node.left))
				queue.add(node.left);
			if (!Objects.isNull(node.right))
				queue.add(node.right);
		}
	}

	// L-N-R
	private void inOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;

		inOrder(root.left);
		System.out.println(root.key + " = " + root.data);
		inOrder(root.right);
	}

	// N-L-R
	private void preOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;
		System.out.println(root.key + " = " + root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	// L-R-N
	private void postOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.key + " = " + root.data);
	}
	
	public int maxWidthByLevel() {
		int height = height();
		int maxWidth = -1;
		for(int level = 1; level <= height; level++) {
			maxWidth = Math.max(maxWidth, width(level));
		}
		return maxWidth;
	}
	public int width(int level) {
		return width(root, level);
	}

	private int width(Node<T> root, int level) {
		if(Objects.isNull(root))
			return 0;
		if(level == 1)
			return 1;
		if(level > 1)
			return width(root.left , level - 1) + width(root.right, level - 1);
		return 0;
	}

	public int maxHeightByNodes(int nodes) {
		return nodes - 1;
	}
	
	public int minNodesByHeight() { 
		return height() + 1;
	}
	
	public int maxNodesByHeight() {
		return (int) Math.pow(2, height() + 1) - 1;
	}
	
	public int minHeightByNodes(int nodes) {
		return log2(nodes);
	}
	
	private int log2(int nodes) {
		return (int) (Math.log(nodes) / Math.log(2));
	}

	public int height() {
		return height(root);
	}
	
	private int height(Node<T> root) {
		if(Objects.isNull(root))
			return -1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	public class Node<M> {
		private Node<M> left;
		private Node<M> right;
		private M data;
		private int key;

		public Node() {

		}

		public Node(int key, M data) {
			this.key = key;
			this.data = data;
		}

		public Node(Node<M> left, Node<M> right, M data, int key) {
			super();
			this.left = left;
			this.right = right;
			this.data = data;
			this.key = key;
		}

		public Node<M> getLeft() {
			return left;
		}

		public void setLeft(Node<M> left) {
			this.left = left;
		}

		public Node<M> getRight() {
			return right;
		}

		public void setRight(Node<M> right) {
			this.right = right;
		}

		public M getData() {
			return data;
		}

		public void setData(M data) {
			this.data = data;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

	}
	
	public int numberOfVisibleLeftNodes() {
		return height() + 1;
	}
	
	public static void main(String[] args) {
		BTTree<Integer> bt = new BTTree<>();
		bt.add(7, 7);
		bt.add(2, 2);
		bt.add(10, 10);
		bt.add(1, 1);
		bt.add(4, 4);
		bt.add(8, 8);
		bt.add(9, 9);
		bt.add(12, 12);
//		bt.print(Traverse.ZIGZAG);
//		System.out.println(bt.height());
//		System.out.println(bt.maxWidthByLevel());
		System.out.println(bt.minNodesByHeight());
		System.out.println(bt.minHeightByNodes(5));
//		System.out.println(bt.width(2));
//		System.out.println(bt.maxNodesByHeight());
	}
}

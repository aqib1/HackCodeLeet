package tree.binaryTree;

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

public class BTree<T> {
	public static void main(String[] args) {
		BTree<Integer> bt = new BTree<>();
		bt.add(7, 7);
		bt.add(2, 2);
		bt.add(10, 10);
		bt.add(1, 1);
		bt.add(4, 4);
		bt.add(8, 8);
		bt.add(12, 12);
//		bt.print(Traverse.ZIGZAG);
		System.out.println(bt.width(2));
//		System.out.println(bt.maxNodesByHeight());
	}

	private Node<T> root;

	// Time complexity O(h) where h is the height of BTree
	public void add(int key, T value) {
		if (Objects.isNull(root))
			root = new Node<>(key, value);
		else
			add(root, key, value);
	}

	private void add(Node<T> root, int key, T value) {
		if (key > root.key) {
			if (Objects.isNull(root.right))
				root.right = new Node<>(key, value);
			else
				add(root.right, key, value);
		} else {
			if (Objects.isNull(root.left))
				root.left = new Node<>(key, value);
			else
				add(root.left, key, value);
		}

	}

	// O(h)
	public int height() {
		return height(root);
	}

	public int width(int level) {
		return width(root, level);
	}

	private int width(Node<T> root, int level) {
		if (Objects.isNull(root))
			return 0;
		if (level == 1)
			return 1;
		if (level > 1)
			return width(root.left, level - 1) + width(root.right, level - 1);
		return 0;
	}

	public int maxNodesByHeight() {
		return (int) Math.pow(2, height() + 1) - 1;
	}

	private int height(Node<T> root) {
		if (Objects.isNull(root))
			return -1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public void print(Traverse traverse) {
		switch (traverse) {
		case BFS:
			levelTraversal(root);
			break;
		case IN_ORDER:
			InOrderTraversal(root);
			break;
		case PRE_ORDER:
			preOrderTraversal(root);
		case POST_ORDER:
			postOrderTraversal(root);
			break;
		case ZIGZAG:
			spiralTraversal(root);
			break;
		default:
			InOrderTraversal(root);
		}
	}

	private void spiralTraversal(Node<T> root) {
		Stack<Node<T>> leftToRight = new Stack<>();
		Stack<Node<T>> rightToLeft = new Stack<>();
		leftToRight.add(root);
		while (!leftToRight.isEmpty()) {
			Node<T> n = leftToRight.pop();
			if (!Objects.isNull(n)) {
				System.out.println(n.key);
				rightToLeft.push(n.right);
				rightToLeft.push(n.left);
				while (!rightToLeft.isEmpty()) {
					n = rightToLeft.pop();
					if (!Objects.isNull(n)) {
						System.out.println(n.key);
						leftToRight.push(n.left);
						leftToRight.push(n.right);
					}
				}
			}
		}
	}

	// L-R-N O(h) where h is the height
	private void postOrderTraversal(Node<T> root) {
		if (Objects.isNull(root))
			return;
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		System.out.println(root.key);
	}

	// N-L-R O(h) where h is the height
	private void preOrderTraversal(Node<T> root) {
		if (Objects.isNull(root))
			return;
		System.out.println(root.key);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	// L-N-R O(h) where h is the height
	private void InOrderTraversal(Node<T> root) {
		if (Objects.isNull(root))
			return;
		InOrderTraversal(root.left);
		System.out.println(root.key);
		InOrderTraversal(root.right);
	}

	private void levelTraversal(Node<T> root) {
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> data = queue.poll();
			if (!Objects.isNull(data)) {
				System.out.println(data.key + ":" + data.value);
				if (!Objects.isNull(data.left))
					queue.add(data.left);
				if (!Objects.isNull(data.right))
					queue.add(data.right);
			}
		}
	}

	class Node<M> {
		private Node<M> left;
		private Node<M> right;
		private int key;
		private M value;

		public Node(int key, M value) {
			this.value = value;
			this.key = key;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
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

		public M getValue() {
			return value;
		}

		public void setValue(M value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value + "";
		}
	}

}

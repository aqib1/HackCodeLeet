package tree;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import stack.Stack;

enum Traversal {
	BFS, IN_ORDER, // DFS
	PRE_ORDER, // DFS
	POST_ORDER, // DFS
	SPIRAL
}

public class BinaryTree<T> {
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();
		bt.add(3, 8);
		bt.add(12, 4);
		bt.add(11, 10);
		bt.add(8, 6);
		bt.add(81, 3);
		bt.add(78, 12);
		bt.add(71, 9);
		bt.print(Traversal.SPIRAL);
		System.out.println(bt.width(3));

	}

	private Node<T> root;

	public void add(T t, int key) {
		if (Objects.isNull(root))
			addRoot(t, key);
		else
			addChild(root, t, key);
	}

	// O(h) where h is the height of binary tree
	private void addChild(Node<T> root, T t, int key) {
		if (key > root.key) {
			if (Objects.isNull(root.right))
				root.right = new Node<>(key, t);
			else
				addChild(root.right, t, key);
		} else {
			if (Objects.isNull(root.left))
				root.left = new Node<>(key, t);
			else
				addChild(root.left, t, key);
		}
	}

	// O(h) where h is the height of binary tree
	public T find(int key) {
		return search(root, key);
	}

	public int height() {
		return height(root);
	}

	public void print(Traversal traversal) {
		switch (traversal) {
		case BFS:
			levelOrderPrint(root);
			break;
		case IN_ORDER:
			inOrderPrint(root);
			break;
		case PRE_ORDER:
			preOrderPrint(root);
			break;
		case POST_ORDER:
			postOrderPrint(root);
			break;
		case SPIRAL:
			spiralOrder(root);
			break;
		}
	}

	private void spiralOrder(BinaryTree<T>.Node<T> root) {
		Stack<Node<T>> leftToRight = new Stack<>();
		Stack<Node<T>> rightToLeft = new Stack<>();
		leftToRight.push(root);
		while (!leftToRight.isEmpty()) {
			Node<T> node = leftToRight.pop();
			if (!Objects.isNull(node)) {
				System.out.println(node.key);
				rightToLeft.push(node.right);
				rightToLeft.push(node.left);
				while (!rightToLeft.isEmpty()) {
					node = rightToLeft.pop();
					if (!Objects.isNull(node)) {
						System.out.println(node.key);
						leftToRight.push(node.left);
						leftToRight.push(node.right);
					}
				}
			}
		}

	}

	// O(h)
	private void levelOrderPrint(BinaryTree<T>.Node<T> root) {
		if (Objects.isNull(root))
			throw new EmptyStackException();

		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			System.out.print(node);

			if (!Objects.isNull(node.left))
				queue.add(node.left);
			if (!Objects.isNull(node.right))
				queue.add(node.right);
		}
	}

	// L-R-N O(h)
	private void postOrderPrint(BinaryTree<T>.Node<T> root) {
		if (Objects.isNull(root))
			return;
		postOrderPrint(root.left);
		postOrderPrint(root.right);
		System.out.print(root);
	}

	// N-L-R O(h)
	private void preOrderPrint(BinaryTree<T>.Node<T> root) {
		if (Objects.isNull(root))
			return;
		System.out.print(root);
		preOrderPrint(root.left);
		preOrderPrint(root.right);
	}

	// L-N-R O(h)
	private void inOrderPrint(BinaryTree<T>.Node<T> root) {
		if (Objects.isNull(root))
			return;
		inOrderPrint(root.left);
		System.out.print(root);
		inOrderPrint(root.right);
	}

	// O(h)
	private int height(Node<T> root) {
		if (Objects.isNull(root))
			return -1;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
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

	private T search(BinaryTree<T>.Node<T> root, int key) {
		if (key == root.key)
			return root.data;
		if (root.key < key)
			return search(root.right, key);
		else
			return search(root.left, key);
	}

	private void addRoot(T t, int key) {
		root = new Node<>(key, t);
	}

	class Node<M> {
		private M data;
		private int key;
		private Node<M> left;
		private Node<M> right;

		public Node() {
			this(0, null);
		}

		public Node(M data) {
			this(0, data);
		}

		public Node(int key) {
			this(key, null);
		}

		public Node(int key, M data) {
			this.key = key;
			this.data = data;
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

		@Override
		public String toString() {
			return data + ", " + key + "\n";
		}
	}
}

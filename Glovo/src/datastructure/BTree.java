package datastructure;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

enum Traversal {
	BFS, IN_ORDER, // DFS
	PRE_ORDER, // DFS
	POST_ORDER, // DFS
	SPIRAL
}

public class BTree<T> {

	public static void main(String[] args) {
		BTree<Integer> bt = new BTree<>();
		bt.add(6, 8);
		bt.add(12, 4);
		bt.add(11, 10);
		bt.add(8, 6);
		bt.add(81, 3);
		bt.add(78, 12);
		bt.add(71, 9);
		bt.add(2, 19);
		bt.add(4, 29);
		bt.add(1, 11);
		bt.add(5, 9);
		bt.print(Traversal.SPIRAL);
//		System.out.println(bt.height());
//		System.out.println("Depth is : " + bt.depth(bt.getNode(71, 9)));
//		System.out.println("Level is : " + bt.level(bt.getNode(71, 9)));

		System.out
				.println("n/o nodes : " + bt.distanceBetweenNodes(bt.getRoot(), bt.getNode(71, 9), bt.getNode(13, 11)));

	}

	private Node<T> root;

	public void add(int key, T data) {
		if (Objects.isNull(root)) {
			addRoot(key, data);
		} else {
			addChild(key, data, root);
		}
	}

	public void print(Traversal traversal) {
		switch (traversal) {
		case IN_ORDER -> inOrder(root);
		case PRE_ORDER -> preOrder(root);
		case POST_ORDER -> postOrder(root);
		case SPIRAL -> spiral(root);
		default -> bfs(root);
		}
	}

	private void spiral(Node<T> root) {
		Stack<Node<T>> leftToRight = new Stack<>();
		Stack<Node<T>> rightToLeft = new Stack<>();
		leftToRight.add(root);
		while (!leftToRight.isEmpty()) {
			Node<T> current = leftToRight.pop();
			if (!Objects.isNull(current)) {
				System.out.print(current);
				rightToLeft.push(current.right);
				rightToLeft.push(current.left);
			}
			if (leftToRight.isEmpty()) {
				while (!rightToLeft.isEmpty()) {
					current = rightToLeft.pop();
					if (!Objects.isNull(current)) {
						System.out.print(current);
						leftToRight.push(current.left);
						leftToRight.push(current.right);
					}
				}
			}
		}
	}

	private void bfs(Node<T> root) {
		if (Objects.isNull(root))
			return;
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> current = queue.poll();
			System.out.print(current);
			if (!Objects.isNull(current.left))
				queue.add(current.left);
			if (!Objects.isNull(current.right))
				queue.add(current.right);
		}
	}

	// L, R, N
	private void postOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;
		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root);
	}

	// N, L, R
	private void preOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;
		System.out.print(root);
		preOrder(root.left);
		preOrder(root.right);
	}

	// L, N, R
	private void inOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;
		inOrder(root.left);
		System.out.print(root);
		inOrder(root.right);
	}

	public Node<T> find(Node<T> node) {
		return search(root, node);
	}

	private Node<T> search(Node<T> root, Node<T> node) {
		if (root.equals(node))
			return node;
		if (node.key > root.key)
			return search(root.right, node);
		else
			return search(root.left, node);
	}

	private void addChild(int key, T data, Node<T> root) {
		if (key < root.getKey()) {
			if (Objects.isNull(root.left))
				root.left = new Node<>(key, data);
			else
				addChild(key, data, root.left);
		} else {
			if (Objects.isNull(root.right))
				root.right = new Node<>(key, data);
			else
				addChild(key, data, root.right);
		}
	}

	private void addRoot(int key, T data) {
		root = new Node<>(key, data);
	}

	public int height() {
		return height(root);
	}

	public int height(Node<T> node) {
		if (Objects.isNull(node))
			return -1;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public int level(Node<T> node) {
		return depth(node) + 1;
	}

	public int depth(Node<T> node) {
		return depth(0, root, node);
	}

	private int depth(int depth, Node<T> root, Node<T> node) {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		if (root.equals(node))
			return depth;
		if (node.key > root.key) {
			return depth(++depth, root.right, node);
		} else
			return depth(++depth, root.left, node);
	}

	public Node<T> getNode(int key, T data) {
		return new Node<>(key, data);
	}

	public Node<T> getRoot() {
		return root;
	}

	public int distanceBetweenNodes(Node<T> source, Node<T> node1, Node<T> node2) {
		if (Objects.isNull(source)) {
			return -1;
		}
		if (node1.equals(node2)) {
			return 0;
		}
		Node<T> LCA = leastCommonAncestor(source, node1, node2);
		try {
			return depth(0, LCA, node1) + depth(0, LCA, node2) + 1;
		} catch (EmptyStackException e) {
			return -1;
		}
	}
	
	private Node<T> leastCommonAncestor(Node<T> source, Node<T> node1, Node<T> node2) {
		if (node1.key > source.key && node2.key > source.key)
			return leastCommonAncestor(source.right, node1, node2);
		else if (node1.key < source.key && node2.key < source.key)
			return leastCommonAncestor(source.left, node1, node2);
		else
			return source;
	}

	public class Node<M> {

		private Node<M> left;
		private Node<M> right;
		private int key;
		private M data;

		public Node() {
			this(0, null);
		}

		public Node(int key, M data) {
			this(key, data, null, null);
		}

		public Node(int key, M data, Node<M> left, Node<M> right) {
			this.key = key;
			this.left = left;
			this.right = right;
			this.data = data;
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

		@Override
		public int hashCode() {
			return key;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			return this.key == ((Node<M>) obj).getKey();
		}

		@Override
		public String toString() {
			return key + ", " + data + "\n";
		}
	}
}

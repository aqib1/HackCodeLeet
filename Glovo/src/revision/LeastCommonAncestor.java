package revision;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class LeastCommonAncestor {
	enum Traversal {
		BFS, IN_ORDER, // DFS
		PRE_ORDER, // DFS
		POST_ORDER, // DFS
		SPIRAL
	}

	static class BT<M> {

		private Node<M> root;
		
		//O(h) where h is the height of binary tree
		//In the case of balanced we will have O(LogN) where N is number of nodes
		public int distanceBwNodes(Node<M> source, Node<M> n1, Node<M> n2) {
			if(Objects.isNull(source))
				return 0;
			if(source.equals(n1) && source.equals(n2))
				return 0;
				
			Node<M> lca = leastComonAnsc(source, n1, n2);
			if(lca == null)
				return 0;
			return depth(lca, n1) + depth(lca, n2) + 1;
		}
		
		//O(h) but in balanced one it will be O(LogN)
		public Node<M> leastComonAnsc(Node<M> source, Node<M> n1, Node<M> n2) {
			if (Objects.isNull(source))
				return null;
			if (n1.getKey() > source.getKey() && n2.getKey() > source.getKey()) {
				return leastComonAnsc(source.right, n1, n2);
			} else if (n1.getKey() < source.getKey() && n2.getKey() < source.getKey()) {
				return leastComonAnsc(source.left, n1, n2);
			} else {
				return source;
			}
		}

		// O(h)
		public int height(Node<M> node) {
			if (Objects.isNull(node))
				return -1;
			int left = height(node.left);
			int right = height(node.right);
			return Math.max(left, right) + 1;
		}

		// O(h)
		public int level(Node<M> source, Node<M> node) {
			return depth(source, node) + 1;
		}
		
		public int depth(Node<M> source, Node<M> node) {
			return depth(source, node, 0);
		}

		private int depth(BT<M>.Node<M> source, BT<M>.Node<M> node, int i) {
			if (source == null)
				return 0;
			if (node.equals(source))
				return i;
			else if (node.key > source.key) {
				return depth(source.right, node, ++i);
			} else
				return depth(source.left, node, ++i);
		}

		//O(h)
		public void add(Node<M> data) {
			if (Objects.isNull(root)) {
				addRoot(data);
			} else {
				addChild(root, data);
			}

		}

		public void print(Traversal traversal) {
			switch (traversal) {
			case BFS -> bfs(root);
			case PRE_ORDER -> preOrder(root);
			case POST_ORDER -> postOrder(root);
			case IN_ORDER -> inOrder(root);
			case SPIRAL -> zigZag(root);
			default -> throw new IllegalArgumentException();
			}
		}

		//O(n) where n is the number of nodes
		// space is o(n)
		private void bfs(BT<M>.Node<M> root) {
			Queue<Node<M>> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node<M> curr = queue.poll();
				if (!Objects.isNull(curr)) {
					System.out.print(curr);
					if (curr.left != null)
						queue.add(curr.left);
					if (curr.right != null)
						queue.add(curr.right);
				}
			}
		}

		// O(n) where n is the number of nodes
		// space is o(n)
		private void zigZag(Node<M> root) {
			Stack<Node<M>> leftToRight = new Stack<>();
			Stack<Node<M>> rightToLeft = new Stack<>();
			leftToRight.push(root);

			while (!leftToRight.isEmpty()) {
				Node<M> curr = leftToRight.pop();
				if (!Objects.isNull(curr)) {
					System.out.print(curr);
					rightToLeft.push(curr.right);
					rightToLeft.push(curr.left);
					if (leftToRight.isEmpty()) {
						while (!rightToLeft.isEmpty()) {
							curr = rightToLeft.pop();
							if (!Objects.isNull(curr)) {
								System.out.print(curr);
								leftToRight.push(curr.left);
								leftToRight.push(curr.right);
							}
						}
					}
				}
			}
		}

		// N,L,R
		// O(n) and space is O(n) [method calls on stack]
		private void preOrder(BT<M>.Node<M> root) {
			if (Objects.isNull(root))
				return;
			System.out.print(" " + root);
			preOrder(root.left);
			preOrder(root.right);
		}

		// L,R,N
		// O(n) and space is O(n) [method calls on stack]
		private void postOrder(BT<M>.Node<M> root) {
			if (Objects.isNull(root))
				return;
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(" " + root);
		}

		// L,N,R
		// O(n) and space is O(n) [method calls on stack]
		private void inOrder(BT<M>.Node<M> root) {
			if (Objects.isNull(root))
				return;
			inOrder(root.left);
			System.out.print(" " + root);
			inOrder(root.right);
		}

		public Node<M> getRoot() {
			return root;
		}

		//O(h) in worst case
		private void addChild(BT<M>.Node<M> root, BT<M>.Node<M> data) {
			if (data.key < root.key) {
				if (Objects.isNull(root.left)) {
					root.left = data;
				} else
					addChild(root.left, data);
			} else {
				if (Objects.isNull(root.right)) {
					root.right = data;
				} else
					addChild(root.right, data);
			}
		}

		private void addRoot(BT<M>.Node<M> data) {
			this.root = data;
		}

		public Node<M> getNode(int key, M data) {
			return new Node<>(data, key);
		}

		class Node<T> {
			private Node<T> left;
			private Node<T> right;
			private T data;
			private int key;

			public Node() {
				this(null, 0);
			}

			public Node(T data, int key) {
				this(null, null, data, key);
			}

			public Node(BT<M>.Node<T> left, BT<M>.Node<T> right, T data, int key) {
				super();
				this.left = left;
				this.right = right;
				this.data = data;
				this.key = key;
			}

			public Node<T> getLeft() {
				return left;
			}

			public void setLeft(Node<T> left) {
				this.left = left;
			}

			public Node<T> getRight() {
				return right;
			}

			public void setRight(Node<T> right) {
				this.right = right;
			}

			public T getData() {
				return data;
			}

			public void setData(T data) {
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
				return this.key == ((Node<T>) obj).getKey();
			}

			@Override
			public String toString() {
				return "[Data : " + this.data + ", key : " + this.key + "]\n";
			}
		}
	}

	public static void main(String[] args) {
		BT<Integer> bt = new BT<>();
		bt.add(bt.getNode(6, 8));
		bt.add(bt.getNode(12, 4));
		bt.add(bt.getNode(11, 10));
		bt.add(bt.getNode(8, 6));
		bt.add(bt.getNode(81, 3));
		bt.add(bt.getNode(78, 12));
		bt.add(bt.getNode(71, 9));
		bt.add(bt.getNode(2, 19));
		bt.add(bt.getNode(4, 29));
		bt.add(bt.getNode(1, 11));
		bt.add(bt.getNode(5, 9));
//		System.out.println(bt.leastComonAnsc(bt.getRoot(), bt.getNode(1, null), bt.getNode(5, null)));
//		System.out.println(bt.height(bt.getRoot()));
//		System.out.println(bt.level(bt.getRoot(), bt.getNode(71, null)));
		System.out.println(bt.distanceBwNodes(bt.getRoot(), bt.getNode(1, null), bt.getNode(11, null)));
//		bt.print(Traversal.BFS);
	}
}

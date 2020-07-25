package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class DistanceBetweenTwoNodesOfBT {

	public static void main(String[] args) {
		DistanceBetweenTwoNodesOfBT distanceBetweenTwoNodesOfBT = new DistanceBetweenTwoNodesOfBT();
		int dd = distanceBetweenTwoNodesOfBT.bstDistance(6, Arrays.asList(5, 6, 3, 1, 2, 4), 2, 26);
		System.out.println(dd);
	}

	public int bstDistance(int num, List<Integer> values, int node1, int node2) {
		BineryTree bt = new BineryTree();
		IntStream.range(0, num).forEach(x -> bt.add(values.get(x)));
		return bt.bstDistance(node1, node2);
	}

	static class BineryTree {

		private Node root;

		public void add(int value) {
			if (Objects.isNull(root))
				addRoot(value);
			else
				addChild(root, value);
		}

		public int bstDistance(int node1, int node2) {
			Node lCA = lowestCommonAncestor(root, node1, node2);
			if (Objects.isNull(lCA))
				return -1;
			try {
				return distance(lCA, node1) + distance(lCA, node2);
			} catch (NullPointerException e) {
				return -1;
			}
		}

		private int distance(Node lCA, int dest) {
			if (Objects.isNull(lCA))
				throw new NullPointerException();
			if (lCA.getKey() == dest)
				return 0;
			Node newNode = lCA.getLeft();
			if (dest > lCA.getKey())
				newNode = lCA.getRight();
			return 1 + distance(newNode, dest);
		}

		private Node lowestCommonAncestor(Node root, int node1, int node2) {
			while (true) {
				if (node1 > root.getKey() && node2 > root.getKey())
					root = root.getRight();
				else if (node1 < root.getKey() && node2 < root.getKey())
					root = root.getLeft();
				else
					return root;
			}
		}

		private void addChild(Node root, int value) {
			Objects.requireNonNull(root);
			if (value > root.getKey()) {
				if (Objects.isNull(root.getRight()))
					root.setRight(new Node(value));
				else
					addChild(root.getRight(), value);
			} else {
				if (Objects.isNull(root.getLeft()))
					root.setLeft(new Node(value));
				else
					addChild(root.getLeft(), value);
			}
		}

		private void addRoot(int value) {
			this.root = new Node(value);
		}

		class Node {
			private int key;
			private Node left;
			private Node right;

			public Node() {
				this(0);
			}

			public Node(int key) {
				this.key = key;
			}

			public int getKey() {
				return key;
			}

			public void setKey(int key) {
				this.key = key;
			}

			public Node getLeft() {
				return left;
			}

			public void setLeft(Node left) {
				this.left = left;
			}

			public void setRight(Node right) {
				this.right = right;
			}

			public Node getRight() {
				return right;
			}
		}
	}
}

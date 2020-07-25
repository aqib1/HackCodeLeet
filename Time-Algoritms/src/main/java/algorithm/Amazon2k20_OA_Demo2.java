package algorithm;

import java.util.EmptyStackException;
import java.util.List;

public class Amazon2k20_OA_Demo2 {

	public int bstDistance(int num, List<Integer> values, int node1, int node2) {
		BT bt = new BT();
		for (int x = 0; x < num; x++) {
			bt.add(values.get(x));
		}
		return bt.bstDistance(bt.root, node1, node2);
	}

	static class BT {
		private Node root;

		private BT() {
		}

		public void add(int v) {
			if (root == null)
				root = new Node(v);
			else
				addChild(root, v);
		}

		private void addChild(Node root, int v) {
			if (v < root.value) {
				if (root.left == null)
					root.left = new Node(v);
				else
					addChild(root.left, v);
			} else {
				if (root.right == null)
					root.right = new Node(v);
				else
					addChild(root.right, v);
			}

		}

		class Node {
			private int value;
			private Node left;
			private Node right;

			public Node() {

			}

			public Node(int value) {
				this.value = value;
			}

			public void setValue(int value) {
				this.value = value;
			}

			public int getValue() {
				return value;
			}

			public Node getLeft() {
				return left;
			}

			public void setLeft(Node left) {
				this.left = left;
			}

			public Node getRight() {
				return right;
			}

			public void setRight(Node right) {
				this.right = right;
			}

		}

		public int bstDistance(Node root, int from, int to) {
			if (root == null)
				return -1;
			Node targetNode = directionMovement(root, from, to);
			if (targetNode == null)
				return -1;
			try {
				return getDistance(targetNode, from) + getDistance(targetNode, to);
			} catch (EmptyStackException e) {
				return -1;
			}
		}

		private int getDistance(Node src, int dest) {
			if (src == null)
				throw new EmptyStackException();
			if (src.value == dest)
				return 0;
			Node node = src.left;
			if (src.value < dest) {
				node = src.right;
			}
			return 1 + getDistance(node, dest);
		}

		private Node directionMovement(Node root, int from, int to) {
			while (true) {
				if (root.value > from && root.value > to) {
					root = root.left;
				} else if (root.value < from && root.value < to) {
					root = root.right;
				} else {
					return root;
				}
			}
		}

	}
//		public static void main(String[] args) {
//			Amazon2k20_OA_Demo2 d = new Amazon2k20_OA_Demo2();
//			int dd = d.bstDistance(6, Arrays.asList(5, 6, 3, 1, 2, 4), 2, 4);
//			System.out.println(dd);
//
//		}
}

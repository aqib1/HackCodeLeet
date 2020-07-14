package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BTMerger {
	private Node root;

	public void add(int[] intervel) {
		if (root == null)
			addRoot(intervel);
		else
			addChild(root, intervel);
	}

	private void addRoot(int[] intervel) {
		this.root = new Node(intervel);

	}

	// [[1,3],[5, 8],[2,6],[8,10],[15,18]]
	private void addChild(Node node, int[] intervel) {
		if (intervel[1] < node.getIntervel()[0]) {
			// move left
			if (node.left == null)
				node.left = new Node(intervel);
			else
				addChild(node.left, intervel);
		} else if (intervel[0] > node.getIntervel()[1]) {
			// move right
			if (node.right == null)
				node.right = new Node(intervel);
			else
				addChild(node.right, intervel);
		} else {
			node.getIntervel()[0] = Math.min(intervel[0], node.getIntervel()[0]);
			node.getIntervel()[1] = Math.max(intervel[1], node.getIntervel()[1]);
		}
	}

	public List<int[]> getIntervelInOrder() {
		List<int[]> data = new ArrayList<>();
		prepareResults(root, data);

		return data;
	}

	private void prepareResults(Node root, List<int[]> data) {
		if (root == null)
			return;

		prepareResults(root.left, data);
		data.add(root.getIntervel());
		prepareResults(root.right, data);

	}

	class Node {
		private Node left;
		private Node right;
		private int[] intervel;

		public Node() {

		}

		public Node(int[] intervel) {
			this.intervel = intervel;
		}

		public int[] getIntervel() {
			return intervel;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void setIntervel(int[] intervel) {
			this.intervel = intervel;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
}

// Time complexity Olog(n) * O(h) with space O(n)

public class MergeIntervelsUsingBT {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(merge(new int[][] { { 3, 12 }, { 4, 8 } })));
	}

	public static int[][] merge(int[][] intervals) {
		Collections.sort(Arrays.asList(intervals), (a, b) -> Integer.compare(a[0], b[0]));
		BTMerger btMerger = new BTMerger();
		for (int[] d : intervals) {
			btMerger.add(d);
		}
		List<int[]> result = btMerger.getIntervelInOrder();
		return result.toArray(new int[result.size()][]);
	}
}

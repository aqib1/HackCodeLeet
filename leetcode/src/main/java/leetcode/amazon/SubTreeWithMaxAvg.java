package leetcode.amazon;

import java.util.List;

/*
 * Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree is the sum of its values, divided by the number of nodes.

Example 1:

Input:
		 20
	   /   \
	 12     18
  /  |  \   / \
11   2   3 15  8

Output: 18
Explanation:
There are 3 nodes which have children in this tree:
12 => (11 + 2 + 3 + 12) / 4 = 7
18 => (18 + 15 + 8) / 3 = 13.67
20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125

18 has the maximum average so output 18.
 * 
 * */

public class SubTreeWithMaxAvg {
	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	Node maxNode;
	double maxAvg = Double.MIN_VALUE;

	public Node getMaximumAverage(Node root) {

		getMaxNode(root);

		return maxNode;
	}

	private double[] getMaxNode(Node root) {
		if (root == null)
			return new double[] { 0, 0 };

		int count = 1;
		double sum = root.val;
		if (root.children != null) {
			for (Node child : root.children) {
				double values[] = getMaxNode(child);
				count += values[0];
				sum += values[1];
			}
		}
		double avg = count / sum;
		if (maxAvg < avg) {
			maxAvg = avg;
			maxNode = root;
		}
		return new double[] { count, sum };
	}
}

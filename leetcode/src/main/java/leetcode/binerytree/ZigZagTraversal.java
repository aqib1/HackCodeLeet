package leetcode.binerytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(9);
//		root.right.right.left = new TreeNode(10);
//		root.right.right.right = new TreeNode(11);

		System.out.println(zigzagLevelOrder(root));
	}

	// Time complexity O(n)2 and space is O(n)
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> leftToRight = new Stack<>();
		Stack<TreeNode> rightToLeft = new Stack<>();
		rightToLeft.push(root);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		while (!rightToLeft.isEmpty()) {
			TreeNode TreeNode = rightToLeft.pop();
			right.add(TreeNode.val);
			if (TreeNode.left != null)
				leftToRight.push(TreeNode.left);
			if (TreeNode.right != null)
				leftToRight.push(TreeNode.right);
			if (rightToLeft.isEmpty()) {
				if (!right.isEmpty()) {
					result.add(new ArrayList<Integer>(right));
					right.clear();
				}
				while (!leftToRight.isEmpty()) {
					TreeNode = leftToRight.pop();
					left.add(TreeNode.val);
					if (TreeNode.right != null)
						rightToLeft.push(TreeNode.right);
					if (TreeNode.left != null)
						rightToLeft.push(TreeNode.left);
				}
				if (leftToRight.isEmpty()) {
					if (!left.isEmpty()) {
						result.add(new ArrayList<>(left));
						left.clear();
					}
				}

			}
		}

		return result;
	}
}

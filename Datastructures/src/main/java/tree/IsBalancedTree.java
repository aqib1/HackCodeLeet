package tree;

import java.util.Objects;

/**
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 */
public class IsBalancedTree {

	// O(n) time and O(1) space complexity
	public boolean isBalanced(TreeNode root) {
		if (root == null || (root.right == null && root.left == null))
			return true;
		int r = height(root);
		return r == -1 ? false : true;
	}

	private int height(TreeNode root) {
		if (Objects.isNull(root))
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1) {
			return -1;
		} else
			return Math.max(left, right) + 1;
	}
}

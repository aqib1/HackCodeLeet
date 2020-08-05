package time90minutesalgos.set1;

import time90minutesalgos.TreeNode;

public class IsValidBST {

	public static void main(String[] args) {
		// [-2147483648,null,2147483647]
		TreeNode p = new TreeNode(-2147483648);
		TreeNode pl = new TreeNode(2147483647);
		p.right = pl;
		IsValidBST isValidBST = new IsValidBST();
		System.out.println(isValidBST.isValidBST(p));
	}

	public boolean isValidBST(TreeNode p) {
		if (p == null)
			return true;
		return isValidBST(p, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	// Time complexity O(h) and space is O(1)
	public boolean isValidBST(TreeNode root, long min_val, long max_val) {
		if (root == null)
			return true;
		if (root.val <= min_val || root.val >= max_val)
			return false;
		return isValidBST(root.left, min_val, root.val) && isValidBST(root.right, root.val, max_val);
	}

}

package leetcode.binerytree;

public class IsSymmetric {

	// O(n) and space is O(1)
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return (left.val == right.val) && //
				isSymmetric(left.left, right.right) //
				&& isSymmetric(left.right, right.left);
	}

}

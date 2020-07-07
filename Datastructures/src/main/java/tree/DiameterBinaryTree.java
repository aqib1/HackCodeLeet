package tree;

public class DiameterBinaryTree {
	int diameter;

	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		depth(root);
		return diameter;
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		diameter = Math.max(diameter, left + right);
		return Math.max(left, right) + 1;

	}
}

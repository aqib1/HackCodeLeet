package tree;

public class MaximumDepth {

	// O(h) where h is the height of tree and O(1) space
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}

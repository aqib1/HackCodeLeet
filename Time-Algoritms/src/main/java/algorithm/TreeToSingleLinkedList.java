package algorithm;

public class TreeToSingleLinkedList {
	private TreeNode previous;

	// pre-order flatten
	// O(n)
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (previous != null) {
			previous.right = root;
			previous.left = null;
		}
		previous = root;
		flatten(left);
		flatten(right);
	}

}

package algorithm;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class TreeToSingleLinkedList {
	private TreeNode previous;

	// pre-order flatten
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

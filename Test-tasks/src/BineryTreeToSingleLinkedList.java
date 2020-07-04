public class BineryTreeToSingleLinkedList {

	private TreeNode previous = null;

	// O(n) and space O(1)
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

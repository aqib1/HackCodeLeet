
public class TreeNodeToDoubleLinkedList {
	TreeNode head, previous;

	// In-order (Left-Node-right)
	public void linkedList(TreeNode root) {
		if (root == null)
			return;

		linkedList(root.left);

		if (previous == null)
			head = root;
		else {
			root.left = previous;
			previous.right = root;
		}
		previous = root;
		linkedList(root.right);

	}

	// post-order (Left-right-node)
	public void linkedListPost(TreeNode root) {
		if (root == null)
			return;

		linkedList(root.left);
		linkedList(root.right);

		if (previous == null)
			head = root;
		else {
			root.left = previous;
			previous.right = root;
			root.right = null;
		}
		previous = root;

	}

	// pre-order (node-left-right)
	public void linkedListPre(TreeNode root) {
		if (root == null)
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;

		if (previous == null)
			head = root;
		else {
			root.left = previous;
			previous.right = root;
		}
		previous = root;

		linkedList(left);
		linkedList(right);

	}
}

package algorithm;

public class TreeToSingleLinkedList {
	private Node previous;

	// pre-order flatten
	// O(n)
	public void flatten(Node root) {
		if (root == null)
			return;
		Node left = root.left;
		Node right = root.right;
		if (previous != null) {
			previous.right = root;
			previous.left = null;
		}
		previous = root;
		flatten(left);
		flatten(right);
	}

}

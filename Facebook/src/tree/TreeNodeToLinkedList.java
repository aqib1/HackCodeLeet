package tree;

import java.util.Objects;

public class TreeNodeToLinkedList {
	private TreeNode previous;

	public void flattern(TreeNode root) {
		if (Objects.isNull(root))
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;

		if (previous != null) {
			previous.right = root;
			previous.left = null;
		}

		previous = root;

		flattern(left);
		flattern(right);
	}
}

package tree;

import java.util.Objects;

public class BinaryTreeFlatter {
	private TreeNode previous = null;

	// O(n) time complexity and space is O(1)
	public void flatten(TreeNode root) {
		if (Objects.isNull(root))
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (!Objects.isNull(previous)) {
			previous.right = root;
			previous.left = null;
		}
		previous = root;
		flatten(left);
		flatten(right);
	}
}

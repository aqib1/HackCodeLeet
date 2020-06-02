package tree;

import java.util.Objects;

public class InvertBinaryTree {

	// IN-ORDER NLR O(N) time and space O(1)
	public TreeNode invertTree(TreeNode root) {
		if (Objects.isNull(root))
			return null;
		TreeNode node = root;
		if (!Objects.isNull(node)) {
			TreeNode left = node.left;
			node.left = node.right;
			node.right = left;
		}
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}

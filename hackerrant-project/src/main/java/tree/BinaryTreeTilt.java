package tree;

import java.util.Objects;

public class BinaryTreeTilt {
	private int sum = 0;

	public int findTilt(TreeNode root) {
		traverse(root);
		return sum;
	}

	public int traverse(TreeNode root) {
		if (Objects.isNull(root))
			return 0;
		int left = traverse(root.left);
		int right = traverse(root.right);
		sum += Math.abs(right - left);
		return left + right + root.val;
	}
}

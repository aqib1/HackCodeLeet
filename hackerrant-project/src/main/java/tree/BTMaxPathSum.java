package tree;

import java.util.Objects;

public class BTMaxPathSum {

	private int max_value;

	public int maxPathSum(TreeNode root) {
		max_value = Integer.MIN_VALUE;
		max_gain(root);
		return max_value;
	}

	private int max_gain(TreeNode root) {
		if (Objects.isNull(root))
			return 0;
		int left = Math.max(0, max_gain(root.left));
		int right = Math.max(0, max_gain(root.right));
		max_value = Math.max(max_value, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}

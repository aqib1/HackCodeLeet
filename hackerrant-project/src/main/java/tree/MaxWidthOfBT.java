package tree;

import java.util.HashMap;
import java.util.Objects;

public class MaxWidthOfBT {
	private HashMap<Integer, Integer> leftMostPositionsByDepth;
	private int max_width;

	// Time complexity O(n) and space complexity O(n)
	public int widthOfBinaryTree(TreeNode root) {
		if (Objects.isNull(root))
			return 0;
		leftMostPositionsByDepth = new HashMap<>();
		max_width = 0;
		findMaxWidth(root, 0, 0);
		return max_width;
	}

	private void findMaxWidth(TreeNode root, int depth, int position) {
		if (Objects.isNull(root))
			return;
		leftMostPositionsByDepth.computeIfAbsent(depth, x -> position);
		max_width = Math.max(max_width, (position - leftMostPositionsByDepth.get(depth)) + 1);
		findMaxWidth(root.left, depth + 1, position * 2); // left position will be previous x 2
		findMaxWidth(root.right, depth + 1, (position * 2) + 1); // right position will be (previous x 2) + 1
	}

}

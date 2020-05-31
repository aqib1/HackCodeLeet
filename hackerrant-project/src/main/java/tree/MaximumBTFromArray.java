package tree;

import java.util.Objects;

public class MaximumBTFromArray {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (Objects.isNull(nums))
			return null;
		if (nums.length == 1)
			return new TreeNode(nums[0]);

		return constructTree(nums, 0, nums.length);

	}

	private TreeNode constructTree(int[] nums, int start, int end) {
		if (start == end)
			return null;
		int max_Index = getMaxIndex(nums, start, end);
		TreeNode treeNode = new TreeNode(nums[max_Index]);
		treeNode.left = constructTree(nums, start, max_Index);
		treeNode.right = constructTree(nums, max_Index + 1, end);

		return treeNode;
	}

	private int getMaxIndex(int[] nums, int start, int end) {
		int index = start;
		for (int x = start; x < end; x++) {
			if (nums[index] < nums[x]) {
				index = x;
			}
		}
		return index;
	}
}

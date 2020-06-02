package tree;

public class CousinsInBinaryTree {

	// Time complexity is O2(n) = O(n) and space complexity O(n)
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;
		int[] xDepth = depthWithParents(root, null, x, 0);
		int[] yDepth = depthWithParents(root, null, y, 0);
		return xDepth[0] != yDepth[0] && xDepth[1] == yDepth[1];
	}

	private int[] depthWithParents(TreeNode root, TreeNode parent, int value, int height) {
		if (root == null)
			return null;
		if (root.val == value) {
			int parentValue = parent == null ? 0 : parent.val;
			return new int[] { parentValue, height };
		}
		int[] leftData = depthWithParents(root.left, root, value, height + 1);
		int[] rightData = depthWithParents(root.right, root, value, height + 1);
		return leftData == null ? rightData : leftData;
	}
}

package time90minutesalgos.set1;

public class IsValidBSTUsingInOrder {
	static class TreeNodeHandler {
		long val;
	}

	// LNR -> 6,(8),9,(10),(22),32,(35),42
	// Time complexity is O(h) and space complexity is O(1)
	public boolean isValidBST(TreeNode p) {
		if (p == null)
			return true;
		TreeNodeHandler tr = new TreeNodeHandler();
		tr.val = Long.MIN_VALUE;
		return isValidBSTByInOrder(p, tr);
	}

	private boolean isValidBSTByInOrder(TreeNode p, TreeNodeHandler prev) {
		if (p == null)
			return true;
		boolean left = isValidBSTByInOrder(p.left, prev);
		if (p.val <= prev.val)
			return false;
		prev.val = p.val;
		return left && isValidBSTByInOrder(p.right, prev);
	}

}

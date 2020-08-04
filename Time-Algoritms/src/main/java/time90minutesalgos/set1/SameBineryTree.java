package time90minutesalgos.set1;

public class SameBineryTree {
	public static void main(String[] args) {
		SameBineryTree s = new SameBineryTree();
		TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		TreeNode q = new TreeNode(1, null, new TreeNode(3));
		System.out.println(s.isSameTree(p, q));
	}

	// Time complexity is O(h) and sapce is O(1)
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return InOrder(p, q);
	}

	// LNR
	public boolean InOrder(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		boolean left = InOrder(p.left, q.left);
		if (p.val != q.val)
			return false;
		boolean right = InOrder(p.right, q.right);
		return left && right;
	}

}

package tree;

public class LinkedListInBineryTree {

	public boolean isSubPath(ListNode head, TreeNode root) {
		if (root == null)
			return false;

		if (head.val == root.val && checkMatch(head, root))
			return true;

		if (isSubPath(head, root.right))
			return true;

		return isSubPath(head, root.left);
	}

	private boolean checkMatch(ListNode head, TreeNode root) {
		if (head.next == null)
			return true;
		if(root == null || root.val != head.val)
			return false;
		if (root.right != null && head.next.val == root.right.val && checkMatch(head.next, root.right))
			return true;
		if (root.left != null && head.next.val == root.left.val && checkMatch(head.next, root.left))
			return true;
		return false;
	}

}

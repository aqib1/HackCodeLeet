package time90minutesalgos.set2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import time90minutesalgos.TreeNode;

public class BineryTreeInOrder {

	// LNR -> 1,3,2
	public static void main(String[] args) {
		BineryTreeInOrder i = new BineryTreeInOrder();
		TreeNode p = new TreeNode(1);
		TreeNode pr = new TreeNode(2);
		p.right = pr;
		pr.left = new TreeNode(3);

		System.out.println(i.inorderTraversal(p));
	}

	// LNR InOrder trivial O(h) and space is O(1)
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> result = new ArrayList<>();
//		inOrder(root, result);
//		return result;
//	}
//
//	private void inOrder(TreeNode root, List<Integer> result) {
//		if (root == null)
//			return;
//		inOrder(root.left, result);
//		result.add(root.val);
//		inOrder(root.right, result);
//	}

	// Iterative O(h) and space is O(n)
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode curr = root;
		while (curr != null || !queue.isEmpty()) {
			while (curr != null) {
				queue.push(curr);
				curr = curr.left;
			}
			curr = queue.pop();
			result.add(curr.val);
			curr = curr.right;
		}
		return result;
	}
}

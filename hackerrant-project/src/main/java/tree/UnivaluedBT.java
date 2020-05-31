package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class UnivaluedBT {

	// Time complexity O(h) and space complexity O(n) where n is the number of nodes
	public boolean isUnivalTree(TreeNode root) {
		int value = root.val;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (!Objects.isNull(node)) {
				if (value != node.val) {
					return false;
				}
				if (!Objects.isNull(node.left))
					queue.add(node.left);
				if (!Objects.isNull(node.right))
					queue.add(node.right);
			}
		}

		return true;
	}
}

package tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderBottom {
	private List<List<Integer>> result;

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		result = new ArrayList<>();
		levelOrderBottom(root, 0);
		return result;
	}

	private void levelOrderBottom(TreeNode root, int level) {
		if (root == null)
			return;
		if (level >= result.size())
			result.add(0, new ArrayList<Integer>());

		result.get(result.size() - 1 - level).add(root.val);

		levelOrderBottom(root.left, level + 1);
		levelOrderBottom(root.right, level + 1);

	}
}

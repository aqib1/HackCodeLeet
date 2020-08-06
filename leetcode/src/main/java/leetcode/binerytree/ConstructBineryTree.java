package leetcode.binerytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBineryTree {
	private Map<Integer, Integer> inOrderToIndexMap = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int x = 0; x < inorder.length; x++)
			inOrderToIndexMap.put(inorder[x], x);

		return null;
	}
}

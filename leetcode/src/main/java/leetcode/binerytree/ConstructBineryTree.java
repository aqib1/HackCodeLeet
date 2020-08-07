package leetcode.binerytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBineryTree {
	private Map<Integer, Integer> inOrderToIndexMap = new HashMap<>();
	private int preorderIndex;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int x = 0; x < inorder.length; x++)
			inOrderToIndexMap.put(inorder[x], x);

		return buildTree(preorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
		if (start > end)
			return null;
		TreeNode node = new TreeNode(preorder[preorderIndex++]);
		if (start == end)
			return node;
		int inOrderFound = inOrderToIndexMap.get(node.val);
		node.left = buildTree(preorder, inorder, start, inOrderFound - 1);
		node.right = buildTree(preorder, inorder, inOrderFound + 1, end);
		return node;
	}
}

package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class PrintBinaryTreeIn2D {
	static class Row {
		int row;
		TreeNode node;
		int start;
		int end;

		Row(int row, int start, int end, TreeNode node) {
			this.row = row;
			this.start = start;
			this.end = end;
			this.node = node;
		}
	}

	public List<List<String>> printTree(TreeNode root) {
		int height = getHeight(root);
		String[][] data = new String[height + 1][getMaxNodesByHeight(height)];
		for (int x = 0; x < data.length; x++)
			for (int y = 0; y < data[x].length; y++)
				data[x][y] = "";
		nodeValueInIndex(data, root, 0, 0, data[0].length);
		return Arrays.stream(data).map(Arrays::asList).collect(Collectors.toList());
	}

	private void nodeValueInIndex(String[][] data, TreeNode root, int row, int start, int end) {
		Queue<Row> queue = new LinkedList<>();
		queue.add(new Row(row, start, end, root));

		while (!queue.isEmpty()) {
			Row r = queue.poll();
			int column = (r.start + r.end) / 2;
			data[r.row][column] = r.node.val + "";
			if (!Objects.isNull(r.node.left))
				queue.add(new Row(r.row + 1, r.start, column, r.node.left));
			if (!Objects.isNull(r.node.right))
				queue.add(new Row(r.row + 1, column, r.end, r.node.right));
		}

	}

	// Time complexity O(h) and space complexity is O(1)
	private int getHeight(TreeNode treeNode) {
		if (Objects.isNull(treeNode))
			return -1;
		int leftHeight = getHeight(treeNode.left);
		int rightHeight = getHeight(treeNode.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// A balance binary tree have max no of node = 2 ^ (height + 1) - 1
	private int getMaxNodesByHeight(int height) {
		return (int) (Math.pow(2, height + 1) - 1);
	}

}

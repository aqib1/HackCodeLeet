package time90minutesalgos.set2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import time90minutesalgos.TreeNode;

public class ModeOfBineryTree {
	public static void main(String[] args) {
		ModeOfBineryTree bt = new ModeOfBineryTree();
		TreeNode p = new TreeNode(1);
		TreeNode pr = new TreeNode(2);
		p.right = pr;
		pr.left = new TreeNode(2);
		System.out.println(Arrays.toString(bt.findMode(p)));
	}

	// Time O(h) with space O(n)
	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> valueByCount = new HashMap<>();
		dfs(root, valueByCount);
		int max_val = valueByCount.values().stream().mapToInt(x -> x).max().orElse(-1);
		List<Integer> result = valueByCount.entrySet().stream().filter(entry -> entry.getValue() == max_val)
				.map(Entry::getKey).collect(Collectors.toList());
		return result.stream().mapToInt(x -> x).toArray();
	}

	private void dfs(TreeNode root, Map<Integer, Integer> valueByCount) {
		if (root == null)
			return;
		dfs(root.left, valueByCount);
		valueByCount.putIfAbsent(root.val, 0);
		valueByCount.put(root.val, valueByCount.get(root.val) + 1);
		dfs(root.right, valueByCount);
	}
}

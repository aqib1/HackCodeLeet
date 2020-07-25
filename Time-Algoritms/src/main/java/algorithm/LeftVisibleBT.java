package algorithm;

import java.util.List;

public class LeftVisibleBT {

	public static void main(String[] args) {

	}

	private int MAX_LEVEL = -1;

	public void rightSideView(List<Integer> data, Node root, int currentLevel) {
		if (root == null)
			return;

		if (currentLevel > MAX_LEVEL) {
			data.add(root.val);
			MAX_LEVEL = currentLevel;
		}

		rightSideView(data, root.right, currentLevel + 1);
		rightSideView(data, root.left, currentLevel + 1);
	}

//	public static void leftSideView(TreeNode root, int currentLevel) {
//		if (root == null)
//			return;
//
//		if (currentLevel > MAX_LEVEL) {
//			System.out.println(root.val);
//			MAX_LEVEL = currentLevel;
//		}
//
//		leftSideView(root.left, currentLevel + 1);
//		leftSideView(root.right, currentLevel + 1);
//	}

}

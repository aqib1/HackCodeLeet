import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class PrintRightView {
	private static int MAX_LEVEL = -1;

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<>();
		rightSideView(rightView, root, 0);
		return rightView;
	}

	private static void rightSideView(List<Integer> rightView, TreeNode root, int level) {
		if (Objects.isNull(root))
			return;

		if (MAX_LEVEL < level) {
			rightView.add(root.val);
			MAX_LEVEL = level;
		}

		rightSideView(rightView, root.right, level + 1);
		rightSideView(rightView, root.left, level + 1);
	}
	

	public static void main(String[] args) {

	}
}

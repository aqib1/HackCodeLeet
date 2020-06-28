package algorithm;

public class TreeNodeToDoubleLinkedList {

	public static void main(String[] args) {
		TreeNode bt = new TreeNode();
		bt.val = 2;
		bt.left = new TreeNode();
		bt.left.val = 3;
		bt.right = new TreeNode();
		bt.right.val = 5;

		TreeNodeToDoubleLinkedList treeNodeToDoubleLinkedList = new TreeNodeToDoubleLinkedList();
		treeNodeToDoubleLinkedList.toDoubleLinkedList(bt);

	}

	private TreeNode head, previous;

	public void toDoubleLinkedList(TreeNode treeNode) {
		toDoubleLinkedListPostOrder(treeNode);
		System.out.println(print(head));
	}

	private void toDoubleLinkedListPostOrder(TreeNode treeNode) {
		if (treeNode == null)
			return;
		toDoubleLinkedListPostOrder(treeNode.left);
		toDoubleLinkedListPostOrder(treeNode.right);
		if (treeNode != null) {
			if (previous == null)
				head = treeNode;
			else {
				previous.right = treeNode;
				treeNode.left = previous;
				treeNode.right = null;
			}
			previous = treeNode;
		}
	}

	private String print(TreeNode node) {
		TreeNode pointer = node;
		String print = "";
		while (pointer != null) {
			print += pointer.val + " ";
			pointer = pointer.right;
		}
		return print;
	}

	private void toDoubleLinkedListInOrder(TreeNode treeNode) {
		if (treeNode == null)
			return;
		toDoubleLinkedListInOrder(treeNode.left);
		if (previous == null)
			head = treeNode;
		else {
			previous.right = treeNode;
			treeNode.left = previous;
		}
		previous = treeNode;

		toDoubleLinkedListInOrder(treeNode.right);

	}

	private void toDoubleLinkedListPreOrder(TreeNode treeNode) {
		if (treeNode == null)
			return;
		TreeNode left = treeNode.left;
		TreeNode right = treeNode.right;
		if (previous == null)
			head = treeNode;
		else {
			previous.right = treeNode;
			treeNode.left = previous;
		}
		previous = treeNode;
		toDoubleLinkedListPreOrder(left);
		toDoubleLinkedListPreOrder(right);

	}

}

package algorithm;

public class TreeNodeToDoubleLinkedList {

	public static void main(String[] args) {
		Node bt = new Node();
		bt.val = 2;
		bt.left = new Node();
		bt.left.val = 3;
		bt.right = new Node();
		bt.right.val = 5;

		TreeNodeToDoubleLinkedList treeNodeToDoubleLinkedList = new TreeNodeToDoubleLinkedList();
		treeNodeToDoubleLinkedList.toDoubleLinkedList(bt);

	}

	private Node head, previous;

	public void toDoubleLinkedList(Node treeNode) {
		toDoubleLinkedListPostOrder(treeNode);
		System.out.println(print(head));
	}

	private void toDoubleLinkedListPostOrder(Node treeNode) {
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

	private String print(Node node) {
		Node pointer = node;
		String print = "";
		while (pointer != null) {
			print += pointer.val + " ";
			pointer = pointer.right;
		}
		return print;
	}

	private void toDoubleLinkedListInOrder(Node treeNode) {
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

	private void toDoubleLinkedListPreOrder(Node treeNode) {
		if (treeNode == null)
			return;
		Node left = treeNode.left;
		Node right = treeNode.right;
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

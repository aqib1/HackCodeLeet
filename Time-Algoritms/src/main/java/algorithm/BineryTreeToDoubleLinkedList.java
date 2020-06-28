package algorithm;

class BT {
	int value;
	BT leftNode;
	BT rightNode;

}

public class BineryTreeToDoubleLinkedList {
	public String print(BT bt) {
		BT pointer = bt;
		String print = "";
		while (pointer != null) {
			print += pointer.value + " ";
			pointer = pointer.rightNode;
		}
		return print;
	}

	public static void main(String[] args) {
		BineryTreeToDoubleLinkedList bineryTreeToDoubleLinkedList = new BineryTreeToDoubleLinkedList();
		BT bt = new BT();
		bt.value = 2;
		bt.leftNode = new BT();
		bt.leftNode.value = 3;
		bt.rightNode = new BT();
		bt.rightNode.value = 5;

		System.out.println(bineryTreeToDoubleLinkedList.print(bineryTreeToDoubleLinkedList.toDoubleLinkedList(bt)));
	}

	/**
	 * 2 3 5 1 4 3 6
	 * 
	 * 1,3,4,2,3,5,6
	 */
	private BT previous, head;

	private BT toDoubleLinkedList(BT bt) {
		byInOrder(bt);
		return head;
	}

	private void byInOrder(BT bt) {
		if (bt == null)
			return;

		byInOrder(bt.leftNode);
		if (previous == null)
			head = bt;
		else {
			bt.leftNode = previous;
			previous.rightNode = bt;
		}

		previous = bt;

		byInOrder(bt.rightNode);
	}

}

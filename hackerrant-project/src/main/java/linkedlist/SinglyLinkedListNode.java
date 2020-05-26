package linkedlist;

import java.util.Objects;

public class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	public SinglyLinkedListNode() {
		this(0);
	}

	public SinglyLinkedListNode(int data) {
		this.data = data;
	}

	// Time complexity O(n) and space complexity O(1)
	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
		while (node != null) {
			System.out.print(node.data);

			node = node.next;

			if (node != null) {
				System.out.print(sep);
			}
		}
	}

	@Override
	public String toString() {
		SinglyLinkedListNode pointer = this;
		String value = "";
		while (!Objects.isNull(pointer)) {
			value += " " + pointer.data;
			pointer = pointer.next;
		}
		return value;
	}
}

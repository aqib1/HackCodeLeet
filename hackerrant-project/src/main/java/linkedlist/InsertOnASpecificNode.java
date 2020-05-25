package linkedlist;

import java.util.EmptyStackException;

public class InsertOnASpecificNode {

	// 1->2->3->4
	SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
		if (position < 0)
			throw new IllegalArgumentException();
		SinglyLinkedListNode pointer = head;
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
		if (position == 0) {
			newNode.next = pointer;
			return newNode;
		}
		try {
			for (int x = 0; x < position - 1; x++) {
				pointer = pointer.next;
			}

			newNode.next = pointer.next;
			pointer.next = newNode;
		} catch (NullPointerException e) {
			throw new EmptyStackException();
		}
		return head;
	}
}

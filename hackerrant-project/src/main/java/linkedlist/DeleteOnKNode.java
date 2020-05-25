package linkedlist;

import java.util.EmptyStackException;
import java.util.Objects;

public class DeleteOnKNode {

	// 1->2->3->4
	SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
		if (position < 0)
			throw new IllegalArgumentException();
		if (position == 0)
			return head.next;
		SinglyLinkedListNode pointer = head;
		for (int x = 0; x < position - 1; x++) {
			pointer = pointer.next;
		}
		if (Objects.isNull(pointer) || Objects.isNull(pointer.next)) {
			throw new EmptyStackException();
		}
		if (Objects.isNull(pointer.next.next)) {
			pointer.next = null;
		} else {
			pointer.next = pointer.next.next;
		}

		return head;
	}
}

package linkedlist;

import java.util.Objects;

public class MergeTwoLinkedList {

	// Time complexity O(N) and Space complexity O(n)
	SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		if (Objects.isNull(head1) && Objects.isNull(head2))
			return null;
		SinglyLinkedListNode result = new SinglyLinkedListNode();
		SinglyLinkedListNode pointer = result;
		while (!Objects.isNull(head2) && !Objects.isNull(head1)) {
			if (head1.data < head2.data) {
				pointer.next = head1;
				head1 = head1.next;
			} else {
				pointer.next = head2;
				head2 = head2.next;
			}
			pointer = pointer.next;
		}

		while (!Objects.isNull(head1)) {
			pointer.next = head1;
			head1 = head1.next;
			pointer = pointer.next;
		}
		while (!Objects.isNull(head2)) {
			pointer.next = head2;
			head2 = head2.next;
			pointer = pointer.next;
		}
		return result.next;
	}
}

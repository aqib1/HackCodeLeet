package linkedlist;

import java.util.Objects;

public class CompareTwoLinkedList {
	// Time complexity O(n) Space Complexity O(1)
	boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		while (!Objects.isNull(head1) && !Objects.isNull(head2)) {
			if (head1.data != head2.data) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}

		if (Objects.isNull(head1) && Objects.isNull(head2)) {
			// System.out.println(1);
			return true;
		}
		// System.out.println(0);
		return false;
	}
}

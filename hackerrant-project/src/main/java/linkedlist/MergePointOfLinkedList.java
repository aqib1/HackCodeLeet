package linkedlist;

import java.util.Objects;

public class MergePointOfLinkedList {
	int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		if (Objects.isNull(head1) || Objects.isNull(head2))
			return -1;
		SinglyLinkedListNode pointer1 = head1, pointer2 = null;
		while (!Objects.isNull(pointer1)) {
			pointer2 = head2;
			while (!Objects.isNull(pointer2)) {
				if (pointer1 == pointer2)
					return pointer1.data;
				pointer2 = pointer2.next;
			}
			pointer1 = pointer1.next;
		}
		return -1;
	}
}

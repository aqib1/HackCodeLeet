package linkedlist;

import java.util.Objects;

public class PrintLinkedList {
	void printLinkedList(SinglyLinkedListNode head) {
		while (!Objects.isNull(head)) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

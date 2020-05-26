package linkedlist;

import java.util.Objects;

public class ReversePrintLinkedList {
	// 1->2->3->4
	// Time complexity O(n) and space complexity O(n)
	static void reversePrint(SinglyLinkedListNode head) {
		SinglyLinkedListNode reverse = null;
		while (!Objects.isNull(head)) {
			SinglyLinkedListNode newNode = new SinglyLinkedListNode(head.data);
			newNode.next = reverse;
			reverse = newNode;

			head = head.next;
		}

		SinglyLinkedListNode.printSinglyLinkedList(reverse, "\n");
		System.out.println();
	}

}

package linkedlist;

import java.util.Objects;

public class LinkedListCycleDetection {
	// Using floyd's hare and tortoise approach
	boolean hasCycle(SinglyLinkedListNode head) {
		SinglyLinkedListNode hare = head;
		SinglyLinkedListNode tortoise = head;
		while (!Objects.isNull(hare) && !Objects.isNull(hare.next)) {
			hare = hare.next.next;
			tortoise = tortoise.next;
			if (hare == tortoise) {
				// System.out.println(1);
				return true;
			}
		}
		// System.out.println(0);
		return false;
	}
}

package challenges;

import java.util.Objects;

public class LinkedListHasCycle {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Using floyd's hare and tortoise approach
	public boolean hasCycle(ListNode head) {
		if(Objects.isNull(head) || Objects.isNull(head.next)) {
			return false;
		}
		ListNode tortoise = head.next, hare = head.next.next;
		while(!Objects.isNull(tortoise) && !Objects.isNull(hare)) {
			if(tortoise == hare) {
				return true;
			} else {
				tortoise = tortoise.next;
				hare = hare.next.next;
			}
		}
		return false;
	}
}

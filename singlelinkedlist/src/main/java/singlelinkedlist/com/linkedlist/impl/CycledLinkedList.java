package singlelinkedlist.com.linkedlist.impl;

import java.util.Objects;

public class CycledLinkedList {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Using floyd's hare and tortoise algorithm
	// Time complexity O(n) and space is O(1)
	public ListNode detectCycle(ListNode root) {
		if (Objects.isNull(root) || Objects.isNull(root.next))
			return null;
		ListNode slow = root, fast = root;
		do {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		} while (!Objects.isNull(fast) && !Objects.isNull(fast.next));
		if (slow != fast)
			return null;
		slow = root;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}

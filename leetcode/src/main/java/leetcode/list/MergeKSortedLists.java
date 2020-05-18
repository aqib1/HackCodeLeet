package leetcode.list;

import java.util.Objects;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		String result = "";
		ListNode pointer = this;
		while (pointer != null) {
			result += " " + pointer.val;
			pointer = pointer.next;
		}
		return result;
	}
}

public class MergeKSortedLists {
	// solve using min heap
	// Time complexity of min heap is Olog(n) nd space O(n)
	public ListNode mergeKLists(ListNode[] lists) {
		if (Objects.isNull(lists) || lists.length == 0)
			return new ListNode();
		ListNode result = new ListNode();
		ListNode pointer = result;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
		// adding head
		for (int x = 0; x < lists.length; x++) {
			if (lists[x] != null)
				minHeap.add(lists[x]);
		}
		while (!minHeap.isEmpty()) {
			pointer.next = minHeap.poll();
			if (pointer.next.next != null)
				minHeap.add(pointer.next.next);
			pointer = pointer.next;
		}
		return result.next;
	}
}

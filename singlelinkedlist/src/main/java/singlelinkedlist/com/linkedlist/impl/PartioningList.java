package singlelinkedlist.com.linkedlist.impl;

import java.util.Objects;

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
		String r = "";
		ListNode pointer = this;
		while (pointer != null) {
			r += pointer.val + " ";
			pointer = pointer.next;
		}
		return r;
	}
}

public class PartioningList {

	public ListNode partition(ListNode head, int x) {
		if (Objects.isNull(head))
			return null;
		ListNode min = null, pointMin = null, max = null, pointMax = null, equal = null, pointEqual = null;
		while (!Objects.isNull(head)) {
			if (x == head.val) {
				if (Objects.isNull(equal)) {
					equal = new ListNode(head.val);
					pointEqual = equal;
				} else {
					pointEqual.next = new ListNode(head.val);
					pointEqual = pointEqual.next;
				}
			} else if (x < head.val) {
				if (Objects.isNull(max)) {
					max = new ListNode(head.val);
					pointMax = max;
				} else {
					pointMax.next = new ListNode(head.val);
					pointMax = pointMax.next;
				}
			} else {
				if (Objects.isNull(min)) {
					min = new ListNode(head.val);
					pointMin = min;
				} else {
					pointMin.next = new ListNode(head.val);
					pointMin = pointMin.next;
				}
			}

			head = head.next;
		}
		if (Objects.isNull(min)) {
			if (Objects.isNull(equal))
				return max;
			else {
				pointEqual.next = max;
				return equal;
			}
		} else if (Objects.isNull(max)) {
			if (Objects.isNull(min)) {
				return equal;
			} else {
				pointMin.next = equal;
				return min;
			}
		}
		pointMin.next = equal;
		pointEqual.next = max;
		return min;
	}

}

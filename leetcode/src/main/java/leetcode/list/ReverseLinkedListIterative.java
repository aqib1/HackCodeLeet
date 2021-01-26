package leetcode.list;

import java.util.Objects;

public class ReverseLinkedListIterative {
	static class ListNode {
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
			ListNode curr = this;
			String toString = "[";
			while (!Objects.isNull(curr)) {
				toString += curr.val + " ";
				curr = curr.next;
			}
			toString += "]";
			return toString;
		}
	}

	//	O(N) time with space O(1)
	public static ListNode reverse(ListNode list) {
		ListNode rev = null;
		while (list != null) {
			ListNode temp = list.next;
			list.next = rev;
			rev = list;
			list = temp;
		}
		return rev;
	}
	
	public static void main(String[] args) {
		ListNode li = new ListNode(2);
		li.next = new ListNode(3);
		li.next.next = new ListNode(4);
		System.out.println(reverse(li));
	}
}

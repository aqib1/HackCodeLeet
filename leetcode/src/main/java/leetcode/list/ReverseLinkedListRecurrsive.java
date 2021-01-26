package leetcode.list;

import java.util.Objects;

public class ReverseLinkedListRecurrsive {
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

	// -> recursive call until curr = null or curr.next = null
	// -> curr.next.next = curr
	// -> curr.next = null
	
	//	O(N) time with space O(N)
	public static ListNode reverse(ListNode curr) {
		if(curr == null || curr.next == null)
			return curr;
		ListNode last = reverse(curr.next);
		curr.next.next = curr;
		curr.next = null;
		return last;
	}
	
	public static void main(String[] args) {
		ListNode li = new ListNode(2);
		li.next = new ListNode(3);
		li.next.next = new ListNode(4);
		System.out.println(reverse(li));
	}

}

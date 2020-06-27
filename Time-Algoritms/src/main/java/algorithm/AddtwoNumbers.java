package algorithm;

import java.util.Objects;

//  Definition for singly-linked list.
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
}

public class AddtwoNumbers {

	// (2 -> 4 -> 3) + (5 -> 6 -> 4)
	// 7 -> 0 -> 8
	// O2(n) and space complexity is O(n)
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode pointer = result;
		int carry = 0;
		while (!Objects.isNull(l1) || !Objects.isNull(l2)) {
			int sum = (Objects.isNull(l1) ? l2.val : Objects.isNull(l2) ? l1.val : l2.val + l1.val) + carry;
			pointer.next = new ListNode(sum % 10);
			carry = sum / 10;
			l1 = Objects.isNull(l1) ? l1 : l1.next;
			l2 = Objects.isNull(l2) ? l2 : l2.next;
			pointer = pointer.next;
		}
		if (carry > 0)
			pointer.next = new ListNode(carry);

		return result.next;
	}

	public static void main(String[] args) {
		ListNode li = new ListNode(2);
		li.next = new ListNode(4);
		li.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		System.out.println(addTwoNumbers(li, l2));
	}

}

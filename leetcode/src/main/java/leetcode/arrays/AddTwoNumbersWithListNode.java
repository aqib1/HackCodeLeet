package leetcode.arrays;

import java.util.EmptyStackException;
import java.util.Objects;

public class AddTwoNumbersWithListNode {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (Objects.isNull(l1) || Objects.isNull(l2))
			throw new EmptyStackException();
		ListNode result = new ListNode(-1);
		ListNode pointer = result;
		int carry = 0;
		while (!Objects.isNull(l1) || !Objects.isNull(l2)) {
			int sum = !Objects.isNull(l1) && !Objects.isNull(l2) ? (l1.val + l2.val)
					: !Objects.isNull(l1) ? l1.val : !Objects.isNull(l2) ? l2.val : -1;
			sum += carry;
			carry = sum / 10;
			pointer.next = new ListNode(sum % 10);
			pointer = pointer.next;
			l1 = !Objects.isNull(l1) ? l1.next : l1;
			l2 = !Objects.isNull(l2) ? l2.next : l2;
		}
		if (carry > 0)
			pointer.next = new ListNode(carry);
		return result.next;
	}
}

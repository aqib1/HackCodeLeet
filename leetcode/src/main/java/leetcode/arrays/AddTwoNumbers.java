package leetcode.arrays;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Objects;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (Objects.isNull(l1) || Objects.isNull(l2))
			throw new EmptyStackException();
		return reverseListNodeFromNumber(getReverseNumberFromListNode(l1).add(getReverseNumberFromListNode(l2)));
	}

	public ListNode reverseListNodeFromNumber(BigDecimal number) {
		if (number.compareTo(BigDecimal.valueOf(9)) < 0 || number.compareTo(BigDecimal.valueOf(9)) == 0)
			return new ListNode(number.intValue());
		BigDecimal reversed = number.remainder(BigDecimal.valueOf(10));
		number = number.divide(BigDecimal.valueOf(10));
		ListNode li = new ListNode(reversed.intValue());
		ListNode pointer = li;
		number.divide(BigDecimal.valueOf(10));
		while (number.intValue() != 0) {
			reversed = number.remainder(BigDecimal.valueOf(10));
			pointer.next = new ListNode(reversed.intValue());
			pointer = pointer.next;
			number = number.divide(BigDecimal.valueOf(10));
		}
		return li;
	}

	public BigDecimal getReverseNumberFromListNode(ListNode li) {
		if (Objects.isNull(li))
			throw new EmptyStackException();
		if (Objects.isNull(li.next))
			return BigDecimal.valueOf(li.val);
		ListNode pointer = li;
		BigDecimal number = BigDecimal.ZERO, mul = BigDecimal.ONE;
		do {
			number = number.add(BigDecimal.valueOf(pointer.val).multiply(mul));
			mul = mul.multiply(BigDecimal.valueOf(10));
			pointer = pointer.next;
		} while (!Objects.isNull(pointer));
		return number;
	}

}

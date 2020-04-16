package leetcode.arrays;

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
		return null;
	}

	public int getReverseNumberFromListNode(ListNode li) {
		if (Objects.isNull(li))
			throw new IllegalArgumentException();
		if (Objects.isNull(li.next))
			return li.val;
		ListNode pointer = li;
		int number = 0, mul = 1;
		do {
			number += pointer.val * mul;
			mul *= 10;
			pointer = pointer.next;
		} while (!Objects.isNull(pointer));
		return number;
	}

	public static void main(String[] args) {

	}

}

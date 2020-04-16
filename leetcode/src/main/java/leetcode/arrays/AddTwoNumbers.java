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
		int number = 0;
		int mul = 1;
		do {
			number += li.val * mul;
			mul *= 10;
		} while (!Objects.isNull(li.next));
		return number;
	}

	public static void main(String[] args) {

	}

}

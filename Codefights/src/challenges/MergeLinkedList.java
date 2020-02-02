package challenges;

class ListNode<T> {
	ListNode(T x) {
		value = x;
	}

	T value;
	ListNode<T> next;

	@Override
	public String toString() {
		String result = "";
		ListNode<T> POINTER = this;
		while (POINTER.next != null) {
			result += POINTER.value + ", ";
			POINTER = POINTER.next;
		}
		return result;
	}
}

public class MergeLinkedList {

	// Singly-linked lists are already defined with this interface:

	static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;

		ListNode<Integer> first = null;
		if (l1.value > l2.value) {
			first = new ListNode<>(l2.value);
			l2 = l2.next;
		} else {
			first = new ListNode<>(l1.value);
			l1 = l1.next;
		}
		ListNode<Integer> result = first;
		ListNode<Integer> POINTER = result;
		while (l1 != null && l2 != null) {
			if (l1.value < l2.value) {
				POINTER.next = new ListNode<>(l1.value);
				l1 = l1.next;
			} else {
				POINTER.next = new ListNode<>(l2.value);
				l2 = l2.next;
			}
			POINTER = POINTER.next;
		}

		while (l1 != null) {
			POINTER.next = new ListNode<>(l1.value);
			l1 = l1.next;
			POINTER = POINTER.next;
		}

		while (l2 != null) {
			POINTER.next = new ListNode<>(l2.value);
			l2 = l2.next;
			POINTER = POINTER.next;
		}

		return result;
	}

	public static void main(String[] args) {
		ListNode<Integer> l1 = new ListNode<Integer>(1);
		l1.next = new ListNode<Integer>(2);
		l1.next.next = new ListNode<Integer>(3);

		ListNode<Integer> l2 = new ListNode<Integer>(4);
		l2.next = new ListNode<Integer>(5);
		l2.next.next = new ListNode<Integer>(6);

		System.out.println(mergeTwoLinkedLists(l1, l2));

	}

}

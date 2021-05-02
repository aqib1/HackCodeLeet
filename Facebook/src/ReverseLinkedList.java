import java.util.Objects;

public class ReverseLinkedList {
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

	public static ListNode reverse(ListNode li) {
		ListNode reverse = null;
		ListNode current = li;
		while (current != null) {
			ListNode tmp = current.next;
			current.next = reverse;
			reverse = current;
			current = tmp;
		}

		return reverse;
	}

	public static ListNode withRecursion(ListNode li) {
		if (li == null || li.next == null)
			return li;
		ListNode last = withRecursion(li.next);
		li.next.next = li;
		li.next = null;
		return last;
	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null)
			return head;
		ListNode prev = null, curr = head;
		for (int x = 1; x < left; x++) {
			prev = curr;
			curr = curr.next;
		}
		
		ListNode con = prev,  tail = curr;
		
		for(int i = left; i <= right; i++) {
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		
		if(con != null) {
			con.next = prev;
		} else {
			head = prev;
		}
		
		tail.next = curr;
		
		return head;
	}

	// 1->2->3->4->5
	public static void main(String[] args) {
		ListNode li = new ListNode(1);
		li.next = new ListNode(2);
		li.next.next = new ListNode(3);
		li.next.next.next = new ListNode(4);
		li.next.next.next.next = new ListNode(5);
		System.out.println(reverseBetween(li, 2, 4));
	}
}

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

public class ReverseLinkedList {

	// O(n) time with space O(n)
	public static ListNode reverseRecursive(ListNode curr) {
		if(curr == null || curr.next == null)
			return curr;
		ListNode last = reverse(curr.next);
		curr.next.next = curr;
		curr.next = null;
		return last;
	}
	// O(n) time with space O(1
	public static ListNode reverse(ListNode li) {
		ListNode rev = null;
		ListNode curr = li;
		while(!Objects.isNull(curr)) {
			ListNode temp = curr.next;
			curr.next = rev;
			rev = curr;
			curr = temp;
		}
		return rev;
	}

	
	// without recursion
	public static ListNode normalReverse(ListNode li) {
		ListNode reverse = null;
		ListNode curr = li;
		
		while(!Objects.isNull(curr)) {
			ListNode temp = curr.next;
			curr.next = reverse;
			reverse = curr;
			curr = temp;
		}
		
		return reverse;
	}
	
	public static ListNode withRecursion(ListNode li) {
		if(li == null || li.next == null)
			return li;
		ListNode last = withRecursion(li.next);
		li.next.next = li;
		li.next = null;
		return last;
	}
	
	public static void main(String[] args) {
		ListNode li = new ListNode(2);
		li.next = new ListNode(3);
		li.next.next = new ListNode(4);
		System.out.println(withRecursion(li));
	}
}

import java.util.Objects;

class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	@Override
	public String toString() {
		SinglyLinkedListNode pointer = this;
		String value = "";
		while (!Objects.isNull(pointer)) {
			value += " " + pointer.data;
			pointer = pointer.next;
		}
		return value;
	}
}

public class ReverseSingleLinkedList {
	public static void main(String[] args) {
		SinglyLinkedListNode li = new SinglyLinkedListNode();
		li.data = 2;
		SinglyLinkedListNode li1 = new SinglyLinkedListNode();
		li1.data = 3;
		li.next = li1;
		SinglyLinkedListNode li2 = new SinglyLinkedListNode();
		li2.data = 4;
		li.next.next = li2;

		System.out.println(reverse(li));
	}

	static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
		SinglyLinkedListNode reverse = null;
		while (!Objects.isNull(head)) {
			SinglyLinkedListNode newNode = new SinglyLinkedListNode();
			newNode.data = head.data;
			newNode.next = reverse;
			reverse = newNode;
			head = head.next;
		}
		return reverse;
	}
}

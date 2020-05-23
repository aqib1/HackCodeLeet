package linkedlist;

import java.util.Objects;

public class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	public SinglyLinkedListNode() {
		this(0);
	}

	public SinglyLinkedListNode(int data) {
		this.data = data;
	}

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

package linkedlist;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class InsertIntoTailLinkedList {
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}

		@Override
		public String toString() {
			SinglyLinkedListNode pointer = this;
			String val = "";
			while (!Objects.isNull(pointer)) {
				val += pointer.data;
				pointer = pointer.next;
			}
			return val;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;

		public SinglyLinkedList() {
			this.head = null;
		}

	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the insertNodeAtTail function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
		if (Objects.isNull(head)) {
			head = new SinglyLinkedListNode(data);
		} else {
			SinglyLinkedListNode pointer = head;
			while (!Objects.isNull(pointer.next)) {
				pointer = pointer.next;
			}
			pointer.next = new SinglyLinkedListNode(data);
		}
		return head;
	}

	public static void main(String[] args) {
		SinglyLinkedListNode head = new SinglyLinkedListNode(1);
		head.next = new SinglyLinkedListNode(3);

		System.out.println((insertNodeAtTail(head, 4)));
	}

}

package tree;

import java.util.Objects;
import java.util.Stack;

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	public Node(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		Node pointNode = this;
		String str = "";
		while (!Objects.isNull(pointNode)) {
			str += pointNode.val + " ";
			pointNode = pointNode.next;
		}
		return str;
	}
}

public class FlatternAMultilevelDoublyLinkedList {
	// O(n) time complexity and O(n) space where n is the no of child
	public Node flatten(Node head) {
		if (Objects.isNull(head))
			return null;
		Stack<Node> nodeStack = new Stack<>();
		Node pointer = head;
		while (!Objects.isNull(pointer)) {
			if (!Objects.isNull(pointer.child)) {
				if (!Objects.isNull(pointer.next))
					nodeStack.push(pointer.next);
				createDoublyLinked(pointer, pointer.child);
			}
			if (Objects.isNull(pointer.next) && !nodeStack.isEmpty()) {
				createDoublyLinked(pointer, nodeStack.pop());
			}
			pointer = pointer.next;
		}
		return head;
	}

	private void createDoublyLinked(Node pointer, Node newNode) {
		pointer.next = newNode;
		pointer.next.prev = pointer;
		pointer.child = null;
	}
}

package linkedlist;

public class InsertIntoHead {

	// Time complexity O(1) and Space complexity O(1)
	SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
		SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
		singlyLinkedListNode.next = llist;
		return singlyLinkedListNode;
	}
}

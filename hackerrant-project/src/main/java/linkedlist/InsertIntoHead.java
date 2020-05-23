package linkedlist;

public class InsertIntoHead {

	SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
		SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
		singlyLinkedListNode.next = llist;
		return singlyLinkedListNode;
	}
}

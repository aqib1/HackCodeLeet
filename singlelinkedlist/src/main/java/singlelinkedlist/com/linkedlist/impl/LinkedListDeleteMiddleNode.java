package singlelinkedlist.com.linkedlist.impl;

public class LinkedListDeleteMiddleNode {

	public <T> void deleteMiddle(LinkedList<T> li) {
		if (li.getSize() == 2)
			throw new RuntimeException("list size is less or equals to 2");
		int middle = li.getSize() / 2;
		LinkedList<T>.Node<T> pointer = li.getHead();
		for (int x = 0; x < middle; x++) {
			if (x + 1 == middle) {
				pointer.setNext(pointer.getNext().getNext());
				li.sizeDecrement();
			}
			pointer = pointer.getNext();
		}

	}
}

package singlelinkedlist.com.linkedlist.impl;

import java.util.EmptyStackException;
import java.util.Objects;

public class LinkedList<T> {

	private Node<T> head;

	private int size;

	public LinkedList() {
		this(null);
	}

	public LinkedList(Node<T> head) {
		this.head = head;
		initailizeSizeWithNewHead();
	}
	
	private void initailizeSizeWithNewHead() {
		Node<T> pointer = this.head;
		while (!Objects.isNull(pointer)) {
			pointer = pointer.next;
			sizeIncrement();
		}

	}
	
	public Node<T> getHead() {
		return head;
	}

	// O(1) with space complexity O(N) where N is the number of calls of push
	public void push(T data) {
		Node<T> node = new Node<>(data);
		node.next = head;
		head = node;
		sizeIncrement();
	}

	public void sizeIncrement() {
		size++;
	}

	public void sizeDecrement() {
		size--;
	}

	public int getSize() {
		return size;
	}

	// O(n) where n is the number in LinkedList
	public T delete(T value) {
		if (size == 0)
			throw new EmptyStackException();

		boolean isFound = false;
		Node<T> pointer = head;
		if (pointer.data == value) {
			head = head.next;
			sizeDecrement();
			return value;
		} else {
			while (!Objects.isNull(pointer) && !Objects.isNull(pointer.next)) {
				if (pointer.next.data == value) {
					pointer.next = pointer.next.next;
					sizeDecrement();
					isFound = true;
				}
				pointer = pointer.next;
			}
		}
		if (!isFound)
			throw new EmptyStackException();
		return value;
	}

	// O(1)
	public T peek() {
		if (size == 0)
			throw new EmptyStackException();
		return head.data;
	}

	// O(1)
	public T pop() {
		if (size == 0)
			throw new EmptyStackException();
		sizeDecrement();
		Node<T> node = head;
		head = head.next;
		return node.data;
	}

	// Distinct method remove duplicate values
	// Time complexity O(2)
	public void distinct() {
		if (size <= 1)
			return;
		Node<T> current = head, next = null;
		while (!Objects.isNull(current)) {
			next = current;
			while (!Objects.isNull(next) && !Objects.isNull(next.next)) {
				if (current.data == next.next.data) {
					next.next = next.next.next;
					sizeDecrement();
				}
				next = next.next;
			}
			current = current.next;
		}
	}
	
	

	// O(n)
	@Override
	public String toString() {
		Node<T> pointer = head;
		String string = "[";
		while (!Objects.isNull(pointer)) {
			string += pointer.data;
			if (!Objects.isNull(pointer.next))
				string += ", ";
			pointer = pointer.next;
		}
		string += "]";
		return string;
	}

	// O(n)
	public LinkedList<T> subLinkedList(int kth) {
		if (kth < 0 || kth > getSize())
			throw new IllegalArgumentException();
		Node<T> pointer = this.head;
		for (int x = kth; x > 0; x--) {
			pointer = pointer.next;
		}

		return new LinkedList<T>(pointer);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		LinkedList<T> rLinkedList = ((LinkedList<T>) obj);
		if (rLinkedList.getSize() != this.getSize())
			return false;
		Node<T> rNode = rLinkedList.head;
		Node<T> cNode = this.head;
		while (!Objects.isNull(rNode) && !Objects.isNull(cNode)) {
			if (rNode.data != cNode.data)
				return false;
			rNode = rNode.next;
			cNode = cNode.next;

		}
		return true;
	}

	class Node<M> {
		private Node<M> next;
		private M data;

		public Node() {
			this(null);
		}

		public Node(M data) {
			this.data = data;
		}

		public M getData() {
			return data;
		}

		public void setData(M data) {
			this.data = data;
		}

		public Node<M> getNext() {
			return next;
		}

		public void setNext(Node<M> next) {
			this.next = next;
		}
	}
}

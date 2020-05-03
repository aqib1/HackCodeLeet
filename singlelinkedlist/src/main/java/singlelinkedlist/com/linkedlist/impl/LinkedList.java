package singlelinkedlist.com.linkedlist.impl;

import java.util.EmptyStackException;
import java.util.Objects;

public class LinkedList<T> {

	private Node<T> head;

	private int size;

	// O(1) with space complexity O(N) where N is the number of calls of push
	public void push(T data) {
		Node<T> node = new Node<>(data);
		node.next = head;
		head = node;
		sizeIncrement();
	}

	private void sizeIncrement() {
		size++;
	}
	
	private void sizeDecrement() {
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
		if(size <= 1)
			return;
		Node<T> current = head, next = null;
		while(!Objects.isNull(current)) {
			next = current;
			while(!Objects.isNull(next) && !Objects.isNull(next.next)) {
				if(current.data == next.next.data) {
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

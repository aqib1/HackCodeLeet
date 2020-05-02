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
		size++;
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
			size--;
			return value;
		} else {
			while (!Objects.isNull(pointer) && !Objects.isNull(pointer.next)) {
				if (pointer.next.data == value) {
					pointer.next = pointer.next.next;
					size--;
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
		size--;
		Node<T> node = head;
		head = head.next;
		return node.data;
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

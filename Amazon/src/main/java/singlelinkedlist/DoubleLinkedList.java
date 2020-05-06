package singlelinkedlist;

import java.util.EmptyStackException;
import java.util.Objects;

public class DoubleLinkedList<T> {
	private Node<T> root;
	private int size;

	public DoubleLinkedList() {

	}

	// Push O(1)
	public void push(T data) {
		Node<T> current = new Node<>(data);
		current.next = root;
		root = current;
		size++;
	}

	// Peek O(1)
	public T peek() {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		return root.data;
	}

	// Pop O(1)
	public T pop() {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		Node<T> remove = root;
		root = root.next;
		size--;
		return remove.data;
	}

	@Override
	public String toString() {
		Node<T> point = root;
		String toString = "[";
		while (!Objects.isNull(point)) {
			toString += point.data;
			if (!Objects.isNull(point.next))
				toString += ", ";
			point = point.next;
		}
		toString += "]";
		return toString;
	}

	public int getSize() {
		return size;
	}

	class Node<M> {
		private M data;
		private Node<M> next;

		public Node() {
			this(null);
		}

		public Node(M data) {
			this(data, null);
		}

		public Node(M data, Node<M> next) {
			this.data = data;
			this.next = next;
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

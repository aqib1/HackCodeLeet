package singlelinkedlist;

import java.util.EmptyStackException;
import java.util.Objects;

public class DoubleLinkedList<T> {
	private Node<T> root, first;
	private int size;

	public DoubleLinkedList() {

	}

	// Push O(1)
	public void push(T data) {
		Node<T> current = new Node<>(data);
		if (Objects.isNull(first))
			first = current;
		current.next = root;
		if (!Objects.isNull(root))
			root.previous = current;
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
		root.previous = null;
		root = root.next;
		size--;
		return remove.data;
	}

	public T poll() {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		return first.data;
	}

	public T popFirst() {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		Node<T> remove = first;
		first = first.previous;
		if (!Objects.isNull(first))
			first.next = null;
		size--;
		return remove.data;
	}

	public String toFifoString() {
		Node<T> point = first;
		String toString = "[";
		while (!Objects.isNull(point)) {
			toString += point.data;
			if (!Objects.isNull(point.previous))
				toString += ", ";
			point = point.previous;
		}
		toString += "]";
		return toString;
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
		private Node<M> previous;

		public Node() {
			this(null);
		}

		public Node(M data) {
			this(data, null);
		}

		public Node(M data, Node<M> next) {
			this(data, next, null);
		}

		public Node(M data, Node<M> next, Node<M> previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
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

		public void setPrevious(Node<M> previous) {
			this.previous = previous;
		}

		public Node<M> getPrevious() {
			return previous;
		}

	}
}

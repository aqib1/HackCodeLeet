package stack;

import java.util.EmptyStackException;
import java.util.Objects;

// Stack is a LIFO structure
public class Stack<T> {
	private Node<T> root;
	private int size;

	public Stack() {

	}

	// Push O(1)
	public void push(T t) {
		Node<T> node = new Node<>(t);
		node.next = root;
		size++;
		root = node;
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

	// O(n)
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

	public boolean isEmpty() {
		return size == 0;
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

package datastructure;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Queue is a FIFO (First in first out) data structure
 * 
 */
public class QueueDS<T> {
	private Node<T> first, last;
	private int size = 0;

	// O(1)
	public void push(T data) {
		if (Objects.isNull(data)) {
			throw new IllegalArgumentException();
		}
		if (Objects.isNull(first)) {
			last = first = new Node<>(data);
		} else {
			last.next = new Node<>(data);
			last = last.next;
		}
		size++;
	}

	// O(1)
	public T peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return first.getData();
	}

	// O(1)
	public T pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		size--;
		Node<T> current = first;
		first = first.getNext();
		return current.getData();
	}

	// O(n)
	@Override
	public String toString() {
		String toString = "[";
		Node<T> pointer = first;
		while (!Objects.isNull(pointer)) {
			toString += pointer.data;
			toString += Objects.isNull(pointer.next) ? "" : ", ";
			pointer = pointer.next;
		}
		toString += "]";
		return toString;
	}

	public class Node<M> {
		private Node<M> next;
		private M data;

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

		public Node<M> getNext() {
			return next;
		}
	}

	public static void main(String[] args) {
		QueueDS<Integer> queue = new QueueDS<>();
		IntStream.range(0, 2).forEach(x -> {
			queue.push(x);
		});

		System.out.println(queue.peek());
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
//		System.out.println(queue.pop());
//		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
	}
}

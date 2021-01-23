package datastructure;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * LIFO -> LAST IN FIRST OUT node -> node -> node
 * 
 */
public class SLinkedList<T> {
	private Node<T> root;
	private int size;

	//O(1)
	public void push(T data) {
		if (Objects.isNull(data)) {
			throw new IllegalArgumentException();
		}
		root = new Node<>(data, root);
		size++;
	}

	//O(1)
	public T peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return root.getData();
	}

	//O(1)
	public T pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		Node<T> current = root;
		root = root.next;
		size--;
		return current.getData();
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
		SLinkedList<Integer> out = new SLinkedList<>();
		// O(5) -> in the case of N it will be O(n)
		IntStream.range(0, 5).forEach(x -> {
			out.push(x);
		});
		
		System.out.println(out.peek());
		System.out.println(out);
		System.out.println(out.pop());
		System.out.println(out);
		System.out.println(out.pop());
		System.out.println(out);
		System.out.println(out.pop());
		System.out.println(out);
		System.out.println(out.pop());
		System.out.println(out);
		System.out.println(out.pop());
		System.out.println(out);
		System.out.println(out.pop());
		System.out.println(out);
	}
}

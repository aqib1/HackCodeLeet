package datastructure;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Its a LIFO root -> null newNode.next = root, root = newNod, structure newNode
 * -> root(null) => root -> null
 * 
 */

public class StackDS<T> {
	private Node<T> root;
	private int size = 0;

	public void push(T data) {
		if (Objects.isNull(data)) {
			throw new IllegalArgumentException();
		}
		root = new Node<>(data, root);
		size++;
	}

	public T peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return root.getData();
	}

	public T pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		size--;
		Node<T> current = root;
		root = root.next;
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
			this(null, null);
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
		StackDS<Integer> stackDS = new StackDS<>();
		IntStream.range(0, 5).forEach(x -> {
			stackDS.push(x);
		});
		
		System.out.println(stackDS.peek());
		System.out.println(stackDS);
		System.out.println(stackDS.pop());
		System.out.println(stackDS);
		System.out.println(stackDS.pop());
		System.out.println(stackDS);
		System.out.println(stackDS.pop());
		System.out.println(stackDS);
		System.out.println(stackDS.pop());
		System.out.println(stackDS);
		System.out.println(stackDS.pop());
		System.out.println(stackDS);
		System.out.println(stackDS.pop());
		System.out.println(stackDS);
	}
}

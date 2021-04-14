import java.util.EmptyStackException;
import java.util.Objects;

public class DoublyLinkedList<K> {
	private Node<K> root;

	public void push(K k) {
		if (Objects.isNull(root)) {
			root = new Node<>(k);
		} else {
			addChild(k);
		}
	}

	private void addChild(K k) {
		root.next = new Node<>(k);
		root.next.previous = root;
		root = root.next;
	}

	public K pop() {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		Node<K> last = root;
		root = root.previous;
		root.next = null;
		return last.getData();
	}

	public K peek() {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		return root.getData();
	}

	public void delete(K k) {
		if (Objects.isNull(root))
			throw new EmptyStackException();
		if (root.getData() == k) {
			root = root.previous;
			root.next = null;
		}

		Node<K> curr = root.previous;

		while (!Objects.isNull(curr)) {
			if (curr.getData() == k) {
				curr.next.previous = curr.previous;
				if (!Objects.isNull(curr.previous))
					curr.previous.next = curr.next;

			}
			curr = curr.previous;
		}

	}

	@Override
	public String toString() {
		Node<K> point = root;
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

	class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> previous;

		public Node() {
			this(null, null, null);
		}

		public Node(T data) {
			this(data, null, null);
		}

		public Node(T data, Node<T> next) {
			this(data, next, null);
		}

		public Node(T data, Node<T> next, Node<T> previous) {
			super();
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}

	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
		doublyLinkedList.push(1);
		doublyLinkedList.push(2);
		doublyLinkedList.push(3);
		System.out.println(doublyLinkedList);
		doublyLinkedList.delete(3);
		System.out.println(doublyLinkedList);
	}
}

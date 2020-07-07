package queue;

import java.util.EmptyStackException;
import java.util.Objects;

public class Queue<T> {

	private QueueNode<T> first, last;
	private int size = 0;

	// O(1)
	public void add(T item) {
		if (Objects.isNull(first)) {
			first = new QueueNode<>(item);
			last = first;
		} else {
			last.next = new QueueNode<>(item);
			last = last.next;
		}
		size++;
	}

	public T remove() {
		if (size == 0)
			throw new EmptyStackException();
		T data = first.data;
		first = first.next;
		size--;
		if (Objects.isNull(first) && size == 0)
			last = null;
		return data;
	}

	// O(n)
	@Override
	public String toString() {
		String toString = "[";
		QueueNode<T> pointer = first;
		while (!Objects.isNull(pointer)) {
			toString += pointer.data;
			toString += Objects.isNull(pointer.next) ? "" : ", ";
			pointer = pointer.next;
		}
		toString += "]";
		return toString;
	}

	class QueueNode<N> {
		private N data;
		private QueueNode<N> next;

		public QueueNode() {
			this(null);
		}

		public QueueNode(N data) {
			this(data, null);
		}

		public QueueNode(N data, QueueNode<N> next) {
			this.data = data;
			this.next = next;
		}

		public N getData() {
			return data;
		}

		public void setData(N data) {
			this.data = data;
		}

		public QueueNode<N> getNext() {
			return next;
		}

		public void setNext(QueueNode<N> next) {
			this.next = next;
		}

	}
}

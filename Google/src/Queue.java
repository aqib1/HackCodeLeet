import java.util.EmptyStackException;
import java.util.Objects;

public class Queue<T> {

//	add (item): Add an item to the end of the list.
//	remove(): Remove the first item in the list.
//	peek() : Return the top of the queue. 
//	isEmpty(): Return true if and only if the queue is empty. 

	private QueueNode<T> top, end;

	public Queue() {

	}

	public boolean isEmpty() {
		return Objects.isNull(top);
	}

	public T peek() {
		return top.data;
	}

	public T remove() {
		if (Objects.isNull(top))
			throw new EmptyStackException();
		T data = top.data;
		top = top.next;
		return data;
	}

	public void add(T data) {
		if (Objects.isNull(data))
			throw new NullPointerException("data is null");
		if (Objects.isNull(top)) {
			top = new QueueNode<>(data);
			end = top;
		} else {
			end.next = new QueueNode<>(data);
			end = end.next;
		}
	}
	
	@Override
	public String toString() {
		String toString = "[";
		QueueNode<T> node = top;
		while (!Objects.isNull(node)) {
			toString += node.data;
			node = node.next;
			if (!Objects.isNull(node))
				toString += ", ";
		}
		return toString + "]";

	}
	
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this(data, null);
		}

		public QueueNode(T data, QueueNode<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		queue.add("this");
		queue.add("is");
		queue.add("it");
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());
		
	}
}

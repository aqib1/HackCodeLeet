import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack<T> {

//	pop() : Remove the top item from the stack. 
//	push(item): Add an item to the top of the stack. 
//	peek(): Return the top of the stack. 
//	isEmpty(): Return true if and only if the stack is empty.
	private StackNode<T> top;

	public MyStack() {

	}

	public MyStack(T t) {

	}

	public T pop() {
		if (Objects.isNull(top))
			throw new EmptyStackException();
		T pop = top.data;
		top = top.next;
		return pop;
	}

	public void push(T t) {
		if (Objects.isNull(t))
			throw new NullPointerException("value can't be null");
		StackNode<T> node = new StackNode<>(t);
		node.next = top;
		top = node;
	}

	public T peek() {
		return top.data;
	}

	public boolean isEmpty() {
		return Objects.isNull(top);
	}

	@Override
	public String toString() {
		String toString = "[";
		StackNode<T> node = top;
		while (!Objects.isNull(node)) {
			toString += node.data;
			node = node.next;
			if (!Objects.isNull(node))
				toString += ", ";
		}
		return toString + "]";

	}

	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data, StackNode<T> next) {
			this.data = data;
			this.next = next;
		}

		public StackNode(T data) {
			this(data, null);
		}

	}

	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<>();
		stack.push("This");
		stack.push("is");
		stack.push("it");
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
	}

}

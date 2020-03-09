import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.stream.IntStream;

public class KNoOfStacksFromArray<T> {

	/**
	 * k = no of stacks n = no of elements in stack
	 * 
	 * lets make 3 arrays 1 - array -> going to store data 2- top -> going to store
	 * top element of stack 3- next -> going to store next element of to element
	 * 
	 * and free_index will going to store free next index
	 * 
	 */
	private T[] arrays;
	private int[] top;
	private int[] next;
	private int current;

	@SuppressWarnings("unchecked")
	public KNoOfStacksFromArray(int k, int n) {
		arrays = (T[]) new Object[n];
		top = new int[k];
		next = new int[n];
		Arrays.fill(top, -1);
		IntStream.range(0, next.length - 1).forEach(x -> next[x] = x + 1);
		next[next.length - 1] = -1;
	}

	public void push(T value, int stack) {
		if (isEmpty())
			throw new EmptyStackException();
		arrays[current] = value;
		int previous_index = top[stack];
		top[stack] = current;

		int next_free_index = next[current];
		next[current] = previous_index;
		current = next_free_index;
	}

	public boolean isNStackIsEmpty(int stack) {
		return top[stack] == -1;
	}

	public T pop(int stack) {
		if (isNStackIsEmpty(stack))
			throw new EmptyStackException();
		int top_value = top[stack];
		top[stack] = next[top_value];
		next[top_value] = current;
		current = top_value;
		return arrays[top_value];
	}

	private boolean isEmpty() {
		return current == -1;
	}

	public static void main(String[] args) {
		KNoOfStacksFromArray<Integer> k = new KNoOfStacksFromArray<>(3, 13);
		k.push(1, 0);
		k.push(4, 0);
		k.push(2, 1);
		k.push(6, 1);
		k.push(3, 2);
		k.push(8, 2);
		System.out.println(k.pop(0));
		System.out.println(k.pop(1));
		System.out.println(k.pop(0));
		System.out.println(k.pop(2));
//		System.out.println(k.pop(0));
	}
}

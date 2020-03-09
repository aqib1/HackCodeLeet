import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;
import java.util.stream.IntStream;

public class EfficientKStacksUsingArray<T> {

	private T[] array;
	private int[] top;
	private int[] last;
	private int current;

	
	
	
	@SuppressWarnings("unchecked")
	public EfficientKStacksUsingArray(int k, int stacks) {
		array = (T[]) new Object[k];
		top = new int[stacks];
		last = new int[k];
		initData();
	}
	
	public void push(T t, int stack) {
		if(Objects.isNull(t))
			throw new NullPointerException();
		if(isEmpty())
			throw new EmptyStackException();
		
		array[current] = t;
		int last_index = top[stack];
		top[stack] = current;
		int next = last[current];
		last[current] = last_index;
		current = next;
	}
	/**
	 * array = {}
	 * top = {}
	 * last = {}
	 * current = 0
	 * */
	
	public T pop(int stack) {
		if(stack < 0)
			throw new IndexOutOfBoundsException();
		if(isCurrentStackIsEmpty(stack))
			throw new EmptyStackException();
		int top_index = this.top[stack];
		int last_index = last[top_index];
		top[stack] = last_index;
		last[top_index] = current;
		current = top_index;
		return array[top_index];
	}
	
	private boolean isCurrentStackIsEmpty(int stack) {
		return top[stack] == -1;
	}

	private boolean isEmpty() {
		return current == -1;
	}

	private void initData() {
		Arrays.fill(top, -1);
		IntStream.range(0, last.length - 1).forEach(x -> last[x] = x+1);
		last[last.length -1] = -1;
	}
	
	public static void main(String[] args) {
		EfficientKStacksUsingArray<Integer> e = new EfficientKStacksUsingArray<Integer>(10, 3);
		e.push(1, 0);
		e.push(2, 0);
		e.push(4, 1);
		e.push(11, 1);
		System.out.println(e.pop(0));
		System.out.println(e.pop(1));
		System.out.println(e.pop(1));
		System.out.println(e.pop(0));
	}

}

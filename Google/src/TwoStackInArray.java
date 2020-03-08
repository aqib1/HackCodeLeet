import java.util.EmptyStackException;
import java.util.Objects;

public class TwoStackInArray<T> {
	private T[] stack;
	private int lastIndexStack1, lastIndexStack2;
	private int size = 0;

	@SuppressWarnings("unchecked")
	public TwoStackInArray(int size) {
		stack = (T[]) new Object[size];
		lastIndexStack1 = 0;
		lastIndexStack2 = size - 1;
		this.size = size;
	}

	public void push1(T t) {
		if (Objects.isNull(t))
			throw new NullPointerException();
		if (lastIndexStack1 >= lastIndexStack2)
			throw new EmptyStackException();
		stack[lastIndexStack1++] = t;
	}

	public T pop1() {
		if (lastIndexStack1 < 0)
			throw new EmptyStackException();
		return stack[--lastIndexStack1];
	}

	public void push2(T t) {
		if (Objects.isNull(t))
			throw new NullPointerException();
		if (lastIndexStack2 <= lastIndexStack1)
			throw new EmptyStackException();
		stack[lastIndexStack2--] = t;
	}
	
	public T pop2() {
		if(lastIndexStack2 >= size)
			throw new EmptyStackException();
		return stack[++lastIndexStack2];
	}

	public static void main(String[] args) {
			TwoStackInArray<Integer> s = new TwoStackInArray<Integer>(10);
			s.push1(1);
			s.push1(2);
			s.push2(3);
			s.push2(5);
			System.out.println(s.pop1());
			s.push1(15);
			System.out.println(s.pop1());
			System.out.println(s.pop2());
			System.out.println(s.pop2());
			

	}

}

import java.util.Arrays;
import java.util.stream.IntStream;

public class Fibonacci {

	public int fibonacci(int number) {
		if (number == 0)
			return 0;
		if (number <= 2)
			return 1;

		return fibonacci(number - 2) + fibonacci(number - 1);
	}

	public void print(int range) {
		IntStream.range(0, range).forEach(x -> {
			System.out.print(fibonacci(x) + " ");
		});
	}

	public void printByArr(int range) {
		int fib[] = new int[range];
		fib[0] = 0;
		fib[1] = 1;

		for (int x = 2; x < range; x++) {
			fib[x] = fib[x-2] + fib[x-1];
		}
		
		System.out.println(Arrays.toString(fib));
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.printByArr(7);
	}

}

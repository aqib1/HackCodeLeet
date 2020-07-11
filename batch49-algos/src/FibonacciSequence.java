import java.util.HashMap;
import java.util.Map;

public class FibonacciSequence {
	private static Map<Integer, Integer> indexToFib;

	public static void main(String[] args) {

		printFibonacci(10);
	}

	// Time complexity O(n) and space complexity O(n)
	public static void printFibonacci(int k) {
		indexToFib = new HashMap<>();
		for (int x = 0; x <= k; x++)
			System.out.print(fibonacci(x) + " ");
	}

	public static int fibonacci(int k) {
		if (k == 0)
			return 0;
		if (k == 1)
			return 1;
		if (indexToFib.containsKey(k))
			return indexToFib.get(k);
		indexToFib.put(k, fibonacci(k - 1) + fibonacci(k - 2));
		return indexToFib.get(k);
	}
}

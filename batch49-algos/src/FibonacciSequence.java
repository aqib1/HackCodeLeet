import java.util.HashMap;
import java.util.Map;

public class FibonacciSequence {
	public static void main(String[] args) {

		printFibonacci(20);
	}

	public static void printFibonacci(int k) {
		for (int x = 0; x <= k; x++)
			System.out.print(fibonacci(x, new HashMap<>()) + " ");
	}

	public static int fibonacci(int k, Map<Integer, Integer> indexToFib) {
		if (k == 0)
			return 0;
		if (k == 1)
			return 1;
		if (indexToFib.containsKey(k))
			return indexToFib.get(k);
		indexToFib.put(k, fibonacci(k - 1, indexToFib) + fibonacci(k - 2, indexToFib));
		return indexToFib.get(k);
	}
}

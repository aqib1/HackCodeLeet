package algorithm;

public class PrintUsingRecursion {

	// Direct recursion
	// Time complexity O(n) and space is O(n)
	public static void print(int[] x, int start, int end) {
		if (start < end) {
			System.out.print(x[start] + " ");
			print(x, start + 1, end);
		}

	}

	public static void main(String[] args) {
		int x[] = { 1, 2, 3, 4, 5, 6 };
		print(x, 0, x.length);
	}
}

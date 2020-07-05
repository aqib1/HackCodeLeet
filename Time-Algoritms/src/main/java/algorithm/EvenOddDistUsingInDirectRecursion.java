package algorithm;

public class EvenOddDistUsingInDirectRecursion {

	// Indirect recursion
	public static int even(int n) {
		if (n % 2 == 0) {
			return n - 1;
		} else
			return odd(n);
	}

	public static int odd(int n) {
		if (n % 2 != 0) {
			return n + 1;
		} else
			return even(n);
	}

	public static void main(String[] args) {
		int numb = 10;
		for (int x = 1; x < numb; x++) {
			System.out.print(even(x) + " ");
		}
	}
}

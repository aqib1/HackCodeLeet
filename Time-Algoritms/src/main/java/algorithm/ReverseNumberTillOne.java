package algorithm;

public class ReverseNumberTillOne {

	// Tail recursion as recursive call is on last and there is nothing
	// evaluating after that
	// Time complexity O(N) space in O(N)
	public static void print(int N) {
		if (N == 1)
			return;
		else {
			System.out.print(N + " ");
			print(N - 1);
		}
	}

	public static void main(String[] args) {
		print(5);
	}

}

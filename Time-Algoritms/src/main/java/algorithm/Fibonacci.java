package algorithm;

public class Fibonacci {

	// 1, 1, 2, 3, 5, 8 ....

	// its a non tail recursive function as
	// in the last we are evaluating sum after return of recursive call

	public static int fib(int N) {
		if (N == 0)
			return 0;
		if (N == 1 || N == 2) {
			return 1;
		}
		return fib(N - 1) + fib(N - 2);
	}

	public static void printFibonacci(int limit) {
		for (int x = 0; x <= limit; x++)
			System.out.print(fib(x) + " ");
	}

	public static void main(String[] args) {
		printFibonacci(8);
	}

}

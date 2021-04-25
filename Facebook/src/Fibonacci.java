
public class Fibonacci {
	private static long MAX_MOD = 1000000007;

	public static int fibonacci(int A) {
		if (A == 0)
			return 0;
		if (A <= 2)
			return 1;
		return fibonacci(A - 2) + fibonacci(A - 1);
	}

	/**
	 * F | 1 1 | M | 1 1 | | 1 0 | | 1 0 |
	 * 
	 */
	public static void mul(long F[][], long M[][]) {
		long a = F[0][0] % MAX_MOD * M[0][0] % MAX_MOD + F[0][1] % MAX_MOD * M[1][0] % MAX_MOD;
		long b = F[0][0] % MAX_MOD * M[0][1] % MAX_MOD + F[0][1] % MAX_MOD * M[1][1] % MAX_MOD;
		long c = F[1][0] % MAX_MOD * M[0][0] % MAX_MOD + F[1][1] % MAX_MOD * M[1][0] % MAX_MOD;
		long d = F[1][0] % MAX_MOD * M[0][1] % MAX_MOD + F[1][1] % MAX_MOD * M[1][1] % MAX_MOD;
		F[0][0] = a;
		F[0][1] = b;
		F[1][0] = c;
		F[1][1] = d;
	}

	public static void pow(long[][] F, int k) {
		if (k == 1)
			return;
		pow(F, k / 2);
		mul(F, F);
		if (k % 2 == 1)
			mul(F, new long[][] { { 1, 1 }, { 1, 0 } });
	}

	public static int fibonacciFastest(int A) {
		if (A == 0)
			return 0;
		long[][] fib = new long[][] { { 1, 1 }, { 1, 0 } };
		pow(fib, A - 1);
		return (int) (fib[0][0] % MAX_MOD);
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(10));
		System.out.println(fibonacciFastest(10));
	}
}

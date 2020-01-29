package GlovoTest;

import java.math.BigInteger;

public class BinomialCoafficient {

	public static int solution(int N, int K) {
		try {
			int MAX_LIMIT = 1000_000_000;
			BigInteger divider = factorial(BigInteger.valueOf(K)).multiply(factorial(BigInteger.valueOf(N - K)));
			BigInteger result = factorial(BigInteger.valueOf(N)).divide(divider);
			return result.compareTo(BigInteger.valueOf(MAX_LIMIT)) > 0 ? -1 : result.intValue();
		} catch (Throwable e) {
			return -1;
		}
	}

	public static BigInteger factorial(BigInteger number) {
		if (number.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else
			return number.multiply(factorial(number.subtract(BigInteger.ONE)));
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 5));
	}

}

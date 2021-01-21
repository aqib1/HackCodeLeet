package leetcode.arrays;

import java.math.BigDecimal;

public class BinominalCoafficent {

	// (K, N) -> K! / N! (K-N)!
	public static int binominalCoafficent(int K, int N) {
		int MAX_LIMIT = 1000_000_000;
		try {
			BigDecimal divider = fictorial(BigDecimal.valueOf(N)).multiply(fictorial(BigDecimal.valueOf(K - N)));
			BigDecimal result = fictorial(BigDecimal.valueOf(K)).divide(divider);
			return result.compareTo(BigDecimal.valueOf(MAX_LIMIT)) > 0 ? -1 : result.intValue();
		} catch (Exception e) {
			return -1;
		}
	}

	public static BigDecimal fictorial(BigDecimal value) {
		if (value.equals(BigDecimal.ZERO))
			return BigDecimal.ONE;
		else
			return value.multiply(fictorial(value.subtract(BigDecimal.ONE)));
	}
}

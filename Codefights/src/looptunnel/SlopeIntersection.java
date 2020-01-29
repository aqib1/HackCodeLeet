package looptunnel;

import java.math.BigInteger;

public class SlopeIntersection {
	static int countBlackCells(int n, int m) {
		int gcd = BigInteger.valueOf(n).gcd(BigInteger.valueOf(m)).intValue();
		 return n + m + gcd - 2;
}

	public static void main(String[] args) {

	}

}

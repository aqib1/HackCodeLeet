package CornersOf0sAnd1s;

import java.math.BigInteger;

public class KillKthBit {

	static int killKthBit(int n, int k) {
		return BigInteger.valueOf(n).clearBit(k-1).intValue();
	}

	public static void main(String[] args) {
		System.out.println(killKthBit(37, 3));
	}

}

package algorithm;

import java.util.EmptyStackException;
import java.util.Objects;

public class GCD {
	public static void main(String[] args) {
		GCD gcd = new GCD();
		System.out.println(gcd.generalizedGCD(5, new int[] { 12, 4, 6, 8, 10 }));
	}

	public int generalizedGCD(int num, int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0)
			throw new EmptyStackException();
		int gcd = 0;
		for (int number = 0; number < num; number++) {
			gcd = gcd(gcd, arr[number]);
			if (gcd == 1)
				return 1;
		}
		return gcd;
	}

	public int gcd(int first, int second) {
		if (first == 0)
			return second;
		return gcd(second % first, first);
	}
}

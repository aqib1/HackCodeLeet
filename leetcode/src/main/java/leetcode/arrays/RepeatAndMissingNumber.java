package leetcode.arrays;

import java.util.Arrays;
import java.util.Objects;

public class RepeatAndMissingNumber {

	//OnLog(n) with space O(2)
	public int[] repeatedNumber(final int[] A) {
		if (Objects.isNull(A) || A.length == 0)
			return new int[] {};
		int[] result = new int[2];
		Arrays.sort(A);
		int count = 1;
		for (int x = 0; x < A.length; x++) {
			if (A[x] != count) {
				result[0] = A[x];
				result[1] = count;
				break;
			}
			count++;
		}
		return result;
	}
}

package algorithms;

import java.util.Objects;

public class MaxSumUsingEfficientKadane {

	// KADANE's algorithm with Time complexity O(n) and space O(1)
	// Kadane's algorithm state that we have to get max sub array sum in O(n)
	// on a specific index max sum will be either index value or sum of val,
	// and last max of sub array
	// KADANE'S Algorithm max(a{i} , sum + a{i}) where sum = a{0}
	// [-2,1,-3,4,-1,2,1,-5,4]
	// O(n) solution using KADANE'S Algorithm
	public int maxSubArray(int[] A) {
		if (Objects.isNull(A))
			return -1;
		int maxValue = A[0], sum = A[0];
		for (int x = 1; x < A.length; x++) {
			sum = Math.max(A[x], sum + A[x]);
			if (sum > maxValue)
				maxValue = sum;
		}
		return maxValue;
	}

	// KADANE'S with O(n)2 -> finding sub array of max sum and then fetch
	public int maxSubArrayOn2(int[] A) {
		if (Objects.isNull(A))
			return -1;
		int max_val = Integer.MIN_VALUE;
		for (int x = 0; x < A.length; x++) {
			int sum = 0;
			for (int y = x; y >= 0; y--) {
				sum += A[y];
				max_val = Math.max(sum, max_val);
			}
		}
		return max_val;
	}
}

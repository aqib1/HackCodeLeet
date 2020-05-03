package algorithms;

import java.util.Objects;

public class MaxSumContigousSubArray {

	// A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
	// The subarray [4,-1,2,1] has the maximum possible sum of 6.
	
	// kADANE'S Algorithms
	// KADANE'S Algorithms states that we have to find 
	// all sub arrays till a specific index s and we have to select only
	// sub array with max index
	// Time complexity O(n)2 and space O(1)
	public int maxSubArray(int[] A) {
		if (Objects.isNull(A))
			return -1;
		int max_sum = Integer.MIN_VALUE;
	
		for(int x=0; x< A.length; x++) {
			int sum = 0;
			for(int y=x; y >= 0; y--) {
				sum += A[y];
				max_sum = Math.max(sum, max_sum);
			}
		}
		return max_sum;
	}
	public static void main(String[] args) {
		MaxSumContigousSubArray max = new MaxSumContigousSubArray();
		System.out.println(max.maxSubArray(new int[] {1, -3, 2, 1, -1}));
	}
}

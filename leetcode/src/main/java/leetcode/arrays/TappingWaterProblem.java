package leetcode.arrays;

import java.util.Objects;

public class TappingWaterProblem {
	
	
	// Dynamic programming approach space complexity O(n) with time complexity O(n)
	public int trap(int[] height) {
		if (Objects.isNull(height) || height.length == 0)
			return 0;
		int[] maxFromLeft = new int[height.length];
		int[] maxFromRight = new int[height.length];

		int max_from_right = Integer.MIN_VALUE;
		for (int x = height.length - 1; x >= 0; x--) {
			maxFromRight[x] = (max_from_right = Math.max(max_from_right, height[x]));
		}
		int max_from_left = Integer.MIN_VALUE;
		for (int x = 0; x < height.length; x++) {
			maxFromLeft[x] = (max_from_left = Math.max(max_from_left, height[x]));
		}
		int sum = 0;
		for (int x = 0; x < height.length; x++) {
			sum += Math.min(maxFromRight[x], maxFromLeft[x]) - height[x];
		}

		return sum;
	}
}

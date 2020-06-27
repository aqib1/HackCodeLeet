package algorithm;

import java.util.Objects;

public class WaterTappingProblem {

	// [1,8,6,2,5,4,8,3,7] -> 49
	// Time complexity O(n) and space complexity O(1)
	public static int maxArea(int[] height) {
		if (Objects.isNull(height) || height.length == 0)
			return 0;

		int i = 0;
		int j = height.length - 1;
		int maxArea = Integer.MIN_VALUE;
		while (i < j) {
			maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j])
				i++;
			else
				j--;
		}

		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

}

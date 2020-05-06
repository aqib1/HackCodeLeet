package leetcode.arrays;

import java.util.Objects;

public class TrappingWaterDoublePointer {

	public int trap(int[] height) {
		if(Objects.isNull(height) || height.length == 0)
			return 0;
		int left = 0, right = height.length -1;
		int last_max_height = Integer.MIN_VALUE;
		int ans = 0;
		while(left < right) {
			int min_bar = height[height[left] < height[right] ? left++ : right--];
			last_max_height = Math.max(last_max_height, min_bar);
			ans += last_max_height - min_bar;
		}
		return ans;
	}
}

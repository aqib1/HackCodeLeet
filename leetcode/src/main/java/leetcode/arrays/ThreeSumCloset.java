package leetcode.arrays;

import java.util.Arrays;

public class ThreeSumCloset {
	public static void main(String[] args) {
		ThreeSumCloset threeSumCloset = new ThreeSumCloset();
		System.out.println(threeSumCloset.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int sub = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				int cal = (int) Math.abs(target - sum);
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (cal < sub) {
					sub = cal;
					result = sum;
				} else if (sum == target) {
					return target;
				}

			}
		}

		return result;
	}
}

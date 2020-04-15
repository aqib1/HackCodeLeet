package leetcode.arrays;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		if (Objects.isNull(nums) || nums.length == 0)
			throw new EmptyStackException();
		if (nums.length < 2)
			throw new IllegalArgumentException();

		for (int x = 0; x < nums.length; x++) {
			for (int y = x + 1; y < nums.length; y++) {
				if (nums[x] + nums[y] == target)
					return new int[] { x, y };
			}
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		TwoSum s = new TwoSum();
		System.out.println(Arrays.toString(s.twoSum(new int[] { 3, 1, 3 }, 6)));

	}

}

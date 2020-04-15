package leetcode.arrays;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Objects;

public class TwoSumEffientSolution {

	// Time complexity is O(n) and Space Complexity is O(n) where n no of elements
	public int[] twoSum(int[] nums, int target) {
		if (Objects.isNull(nums) || nums.length == 0)
			throw new EmptyStackException();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x = 0; x < nums.length; x++) {
			int diff = target - nums[x];
			if (map.containsKey(diff) && map.get(diff) != x)
				return new int[] { map.get(diff), x };
			map.put(nums[x], x);
		}

		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		TwoSumEffientSolution ef = new TwoSumEffientSolution();
		System.out.println(Arrays.toString(ef.twoSum(new int[] { 3, 3 }, 6)));
	}

}

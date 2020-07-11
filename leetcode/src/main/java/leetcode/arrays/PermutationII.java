package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationII {

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0)
			Arrays.asList();
		Set<List<Integer>> data = new HashSet<>();
		permutation(nums, 0, nums.length - 1, data);
		return data.stream().collect(Collectors.toList());

	}

	public static void permutation(int[] nums, int left, int right, Set<List<Integer>> data) {
		if (left == right)
			data.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
		else {
			for (int x = left; x <= right; x++) {
				swap(nums, x, left);
				permutation(nums, left + 1, right, data);
				swap(nums, x, left);
			}
		}

	}

	private static void swap(int[] nums, int x, int left) {
		int temp = nums[x];
		nums[x] = nums[left];
		nums[left] = temp;
	}
}

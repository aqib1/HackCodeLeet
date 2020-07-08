package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CanPartitionWithEqualSum {

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 2, 5, 11 }));
	}

	public static boolean canPartition(int[] nums) {

		if (nums == null || nums.length <= 1)
			return false;
		int total = IntStream.range(0, nums.length).map(x -> nums[x]).sum();

		if (total % 2 != 0)
			return false;
		return canPartition(nums, 0, 0, total, new HashMap<>());
	}

	private static boolean canPartition(int[] nums, int index, int sum, int total, Map<String, Boolean> result) {
		String key = index + "," + sum;
		if (result.containsKey(key)) {
			return result.get(key);
		}
		if (sum > total / 2 || index >= nums.length)
			return false;
		if (sum * 2 == total)
			return true;
		boolean r = canPartition(nums, index + 1, sum, total, result) ||

				canPartition(nums, index + 1, sum + nums[index], total, result);
		result.put(key, r);
		return r;
	}
}

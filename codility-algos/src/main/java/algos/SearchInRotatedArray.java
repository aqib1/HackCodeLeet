package algos;

import java.util.stream.IntStream;

public class SearchInRotatedArray {

	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		if (nums.length == 1)
			return nums[0] == target;
		if (nums[0] < nums[nums.length - 1] || haveAllSameNumbers(nums))
			// not rotated
			return binerySearch(nums, 0, nums.length - 1, target);

		int pivot = pivot(nums);
		if (nums[pivot] == target)
			return true;
		if (target >= nums[0])
			return binerySearch(nums, 0, pivot - 1, target);

		return binerySearch(nums, pivot + 1, nums.length - 1, target);
	}

	private static boolean haveAllSameNumbers(int[] nums) {
		return IntStream.of(nums).distinct().count() == 1;
	}

	// 1,1, 3, 1
	private static int pivot(int[] nums) {
		for (int x = 0; x < nums.length - 1; x++) {
			if (nums[x] > nums[x + 1]) {
				return x;
			}
		}
		return 0;
	}

	private static boolean binerySearch(int[] nums, int low, int high, int target) {
		if (low > high)
			return false;
		int mid = low + (high - low) / 2;
		if (target == nums[mid])
			return true;
		if (target > nums[mid])
			return binerySearch(nums, mid + 1, high, target);
		return binerySearch(nums, low, mid - 1, target);
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 2, 1, 1, 2, 2, 2, 2 }, 2));
	}
}

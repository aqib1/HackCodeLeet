package algos;

public class FindMinimumInSortedRotatedArray {

	// Time complexity log(n) and space O(1)
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		if (nums.length == 1)
			return nums[0];

		// not sorted
		if (nums[0] < nums[nums.length - 1])
			return nums[0];

		int pivot = pivot(nums, 0, nums.length - 1);

		return nums[pivot + 1];

	}

	// [4,5,6,7,0,1,2]
	private int pivot(int[] nums, int low, int heigh) {
		int mid = low + (heigh - low) / 2;
		if (mid > low && nums[mid - 1] > nums[mid])
			return mid - 1;
		if (mid < heigh && nums[mid] > nums[mid + 1])
			return mid;
		if (nums[0] > nums[mid])
			return pivot(nums, low, mid - 1);
		return pivot(nums, mid + 1, heigh);
	}
}

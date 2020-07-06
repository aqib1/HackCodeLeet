package algos;

public class SearchInRotatedArray {

	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		if (nums.length == 1)
			return nums[0] == target;
		int pivot = pivot(nums);
		if (pivot == -1)
			// not rotated
			return binerySearch(nums, 0, nums.length - 1, target);
		if (nums[pivot] == target)
			return true;
		if (target >= nums[0])
			return binerySearch(nums, 0, pivot - 1, target);

		return binerySearch(nums, pivot + 1, nums.length - 1, target);
	}

	// 3,1
	private static int pivot(int[] nums) {
		for (int x = 0; x < nums.length - 1; x++) {
			if (nums[x] > nums[x + 1]) {
				return x;
			}
		}
		return -1;
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
		System.out.println(search(new int[] { 3, 1 }, 1));
	}
}

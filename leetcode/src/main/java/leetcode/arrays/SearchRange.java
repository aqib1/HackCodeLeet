package leetcode.arrays;

/**
 * 
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 10^5 -10^9 <= nums[i] <= 10^9 nums is a non decreasing
 * array. -10^9 <= target <= 10^9
 */
public class SearchRange {

	public int[] searchRange(int[] nums, int target) {
		int low = searchRange(nums, target, true);
		return null;
	}

	private int searchRange(int[] nums, int target, boolean left) {
		int low = 0;
		int heigh = nums.length - 1;
		while (low < heigh) {
			int mid = (low + heigh) / 2;
		}
		return 0;
	}
}

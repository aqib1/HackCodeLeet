package leetcode.arrays;

import java.util.Arrays;

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

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 3, 3, 3, 3, 3, 3, 3, 3 }, 3)));
	}

	// Time complexity is Log(n) + Log(n) = 2Log(n) = Log(n) and space is O(2)
	public static int[] searchRange(int[] nums, int target) {
		int low = searchRange(nums, target, true);
		int heigh = searchRange(nums, target, false);
		return new int[] { low, heigh };
	}

	private static int searchRange(int[] nums, int target, boolean left) {
		int low = 0;
		int heigh = nums.length - 1;
		while (low <= heigh) {
			if (low == heigh && nums[low] == target)
				return low;
			int mid = (low + heigh) / 2;
			if (nums[mid] == target) {
				if (left) {
					if (mid - 1 < 0 || nums[mid - 1] != target) {
						return mid;
					}
				} else {
					if (mid + 1 > nums.length - 1 || nums[mid + 1] != target) {
						return mid;
					}
				}
			}
			if (nums[mid] > target) {
				heigh = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				if (left) {
					heigh = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}

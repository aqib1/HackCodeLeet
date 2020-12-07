package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {

		int[] nums = { 0, 0, 0 };
		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.threeSum(nums));
	}

	/**
	 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] // -4,-1,-1,0,1,2
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int low = i + 1;
				int heigh = nums.length - 1;
				int sum = 0 - nums[i];
				while (low < heigh) {
					if (sum == (nums[low] + nums[heigh])) {
						result.add(Arrays.asList(nums[i], nums[low], nums[heigh]));
						while(low < heigh && nums[low] == nums[low + 1]) low++;
						while (low < heigh && nums[heigh] == nums[heigh - 1]) heigh--; 
						low++;
						heigh--;
					}  else if ((nums[low] + nums[heigh]) > sum) {
						heigh--;
					} else if ((nums[low] + nums[heigh]) < sum) {
						low++;
					}
				}
			}
		}
		return result;
	}

}

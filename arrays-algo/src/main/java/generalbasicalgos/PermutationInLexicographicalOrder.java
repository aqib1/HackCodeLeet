package generalbasicalgos;

public class PermutationInLexicographicalOrder {

	/**
	 * -> 1,2,3 => 1,3,2 -> 1,3,2 => 2,1,3 -> 2,1,3 => 2,3,1 -> 2,3,1 => 3,1,2 By
	 * using discrete math
	 * 
	 * 1- find max p(x) where p(x) < p(x+1) 2- find max p(y) where p(x) < p(y)
	 * 
	 * 3- swap p(x) with p(y)
	 * 
	 * 4- reverse p(x+1), p(x+2) ..... p(x+n)
	 * 
	 * Time complexity O(n) and space is O(1)
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int minX = -1;
		for (int x = nums.length - 2; x >= 0; x--) {
			if (nums[x] < nums[x + 1]) {
				minX = x;
				break;
			}
		}

		if (minX == -1)
			// already biggest permutation so reverse it
			reverse(nums, 0, nums.length - 1);
		else {
			for (int y = nums.length - 1; y >= 0; y--) {
				if (nums[minX] < nums[y]) {
					int temp = nums[minX];
					nums[minX] = nums[y];
					nums[y] = temp;
					reverse(nums, minX + 1, nums.length - 1);
					break;
				}
			}
		}

	}

	private void reverse(int[] nums, int l, int r) {
		while (l < r) {
			int temp = nums[r];
			nums[r] = nums[l];
			nums[l] = temp;
			l++;
			r--;
		}

	}
}

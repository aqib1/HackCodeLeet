package algos;

import java.util.Objects;

public class NextPermutationInLexicographicalOrder {
	public static void main(String[] args) {
		nextPermutation(new int[] { 2, 3, 1 });
	}

	// Time complexity O(n) and space is O(1)
	public static void nextPermutation(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0) {
			return;
		}
		if (nums.length == 1) {
			return;
		}

		// find maximum x where p(x) < p(x+1) if not found
		// then reverse all array

		int maxX = -1;
		for (int x = nums.length - 2; x >= 0; x--) {
			if (nums[x] < nums[x + 1]) {
				maxX = x;
				break;
			}
		}
		if (maxX == -1)
			reverse(nums, 0, nums.length - 1);
		else { // --------------------> found max x
				// find max y where p(x) < p(y)
			int maxY = -1;
			for (int y = nums.length - 1; y >= 0; y--) {
				if (nums[maxX] < nums[y]) {
					maxY = y;
					break;
				}
			}

			// setp 3 swap p[x] and p[y]
			int temp = nums[maxX];
			nums[maxX] = nums[maxY];
			nums[maxY] = temp;

			// reverse p[x+1] ....
			reverse(nums, maxX + 1, nums.length - 1);

		}
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}

	}
}

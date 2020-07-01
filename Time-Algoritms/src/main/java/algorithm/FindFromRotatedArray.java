package algorithm;

public class FindFromRotatedArray {
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1)
			return nums[0] == target ? 0 : -1;
		int index = -1;
		int i = nums.length / 2;
		if (nums[i] == target)
			return i;
		boolean leftVisit = //
				nums[nums.length - 1] > nums[0] ? //
						!(target >= nums[i]) : //
						target >= nums[0] && target <= nums[i - 1];
		int start = leftVisit ? 0 : i + 1;
		int limit = leftVisit ? i : nums.length;
		while (start < limit) {
			if (target == nums[start])
				return start;
			start++;
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 7, 8, 1, 2, 3, 4, 5, 6 }, 2));
	}

}

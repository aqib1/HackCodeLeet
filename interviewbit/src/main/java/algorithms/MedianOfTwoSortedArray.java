package algorithms;

import java.util.EmptyStackException;

public class MedianOfTwoSortedArray {

	// Time complexity log(min(n,m)) and space complexity is O(1)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if ((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0)) {
			throw new EmptyStackException();
		}
		// fix the first min prob
		if (nums1.length > nums2.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}

		double min_median = 0.0;
		int j = 0, i = 0, min_index = 0, max_index = nums1.length;
		boolean isOdd = (nums1.length + nums2.length) % 2 != 0;

		while (min_index <= max_index) {
			i = (min_index + max_index) / 2; // ---------------------1
			j = ((nums1.length + nums2.length + 1) / 2) - i; // -----------------2
			if (i > 0 && j < nums2.length && nums1[i - 1] > nums2[j]) {
				// move left
				max_index = i - 1;
			} else if (j > 0 && i < nums1.length && nums2[j - 1] > nums1[i]) {
				// move right
				min_index = i + 1;
			} else {
				if (i == 0)
					min_median = nums2[j - 1];
				else if (j == 0)
					min_median = nums1[i - 1];
				else
					min_median = Math.max(nums1[i - 1], nums2[j - 1]);
				break;
			}
		}

		if (isOdd)
			return min_median;
		if (i == nums1.length)
			return (min_median + nums2[j]) / 2;
		if (j == nums2.length)
			return (min_median + nums1[i]) / 2;
		return (min_median + Math.min(nums1[i], nums2[j])) / 2;

	}
}

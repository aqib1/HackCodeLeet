package algos;

import java.util.EmptyStackException;

public class MedianOfTwoSortedArrayEffiecientSolution {

	// Time complexity Olong(min(n,m)) and space complexity O(1)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if ((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0))
			throw new EmptyStackException();
		if (nums2.length < nums1.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}

		int i = 0, j = 0, min_index = 0, max_index = nums1.length;
		double min_median = 0.0;
		boolean isOdd = (nums1.length + nums2.length) % 2 != 0;
		while (min_index <= max_index) {
			i = (min_index + max_index) / 2; //
			j = ((nums1.length + nums2.length + 1) / 2) - i;

			if (i > 0 && j < nums2.length && nums1[i - 1] > nums2[j]) {
				// go to left
				max_index = i - 1;
			} else if (j > 0 && i < nums1.length && nums2[j - 1] > nums1[i]) {
				// go to right
				min_index = i + 1;
			} else {
				// found
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
			return (min_median + nums2[j]) / 2.0;
		if (j == nums2.length)
			return (min_median + nums1[i]) / 2.0;
		return (min_median + Math.min(nums1[i], nums2[j])) / 2.0;
	}
}

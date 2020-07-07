package algos;

public class MedianOfTwoSortedArray {
	// Time complexity O(n) and space O(n+m)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] merge = merge(nums1, nums2);
		int half = merge.length / 2;
		return merge.length % 2 != 0 ? merge[half] : //
				((double) merge[half - 1] + merge[half]) / 2;
	}

	private int[] merge(int[] nums1, int[] nums2) {
		int[] merge = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j])
				merge[k++] = nums1[i++];
			else
				merge[k++] = nums2[j++];
		}
		while (i < nums1.length) {
			merge[k++] = nums1[i++];
		}

		while (j < nums2.length) {
			merge[k++] = nums2[j++];
		}

		return merge;
	}
}

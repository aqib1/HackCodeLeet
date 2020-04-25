package leetcode.arrays;

import java.util.Objects;

public class MediamSortedArrayEffcientAlgo {

	/**
	 * 1, 4, | 10, 11, 12 2, 3, | 7, 9
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (Objects.isNull(nums1) || Objects.isNull(nums2) || (nums1.length == 0 && nums2.length == 0))
			return 0.0;
		boolean isEven = (nums1.length + nums2.length) % 2 == 0 ? true : false;
		int num1Pivot = nums1.length / 2;
		int num2Pivot = nums2.length / 2;
		while (true) {
			if (nums1[num1Pivot] < nums2[num2Pivot + 1] && nums2[num2Pivot] < nums1[num1Pivot + 1]) {
				if (!isEven)
					return Math.max(nums1[num1Pivot], nums2[num2Pivot]);
				else
					return (double) (Math.max(nums1[num1Pivot], nums2[num2Pivot])
							+ Math.min(nums1[num1Pivot + 1], nums2[num2Pivot + 1])) / 2;
			} else if (nums2[num2Pivot] > nums1[num1Pivot + 1]) {
				num2Pivot--;
			} else if (nums1[num1Pivot] > nums2[num2Pivot + 1]) {
				num1Pivot--;
			}
		}
	}

	public static void main(String[] args) {
		MediamSortedArrayEffcientAlgo mediam = new MediamSortedArrayEffcientAlgo();
		double ans = mediam.findMedianSortedArrays(new int[] { 1, 3, 5 }, new int[] { 2, 4, 7 });
		System.out.println(ans);
	}
}

package leetcode.arrays;

import java.util.Objects;

public class MediamSortedArray {
	/*
	 * We have to find the median of two sorted array, e.g -> a= [1,3] , b= [2] =
	 * [1,2,3] -> 2 is median -> a= [1,2] , b= [3,4] = [1,2,3,4] -> 2+3/2 = 2.5 is
	 * median Logic, if both array are empty or null - return 0 if both array have
	 * only one element return (a[0] + b[0]) /2 now what we can do here is to check
	 * if the length of array is even or odd, - in the case of even - just save
	 * len(a+b)/2 in to var pointer, which will point median index, - now take two
	 * pointers x,y and iterate through both arrays like that it should maintain
	 * their sorted order
	 */

	//Brute-force solution with time complexity O(n+m) with space O(n+m)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (Objects.isNull(nums1) || Objects.isNull(nums2) || (nums1.length == 0 && nums2.length == 0))
			return 0;
		if (nums1.length == 1 && nums2.length == 1)
			return (double)(nums1[0] + nums2[0]) / 2;
		int i = 0, j = 0, current = 0, n = (nums1.length + nums2.length);
		int pointer = n / 2;
		boolean isEven = n % 2 == 0 ? true : false;
		int result[] = new int[n];
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				result[current++] = nums1[i++];
			} else {
				result[current++] = nums2[j++];
			}
		}
		while (i < nums1.length) {
			result[current++] = nums1[i++];
		}
		while (j < nums2.length) {
			result[current++] = nums2[j++];
		}
		return (!isEven) ? result[pointer] : (double)(result[pointer] + result[pointer - 1]) / 2;
	}
}

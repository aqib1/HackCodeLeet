package leetcode.arrays;

import java.util.Objects;

public class MediamSortedArrayEffcientAlgo {

	/**
	 * 1, 4, | 10, 11, 12 2, 3, | 7, 9
	 * 
	 * time complexity is Olog(min(a,b)) and space complexity is O(1)
	 */
	public double findMedianSortedArrays(int[] arr1, int[] arr2) {
		if (Objects.isNull(arr1) || Objects.isNull(arr2) || (arr1.length == 0 && arr2.length == 0))
			return 0.0;

		// replace arr1 with arr2 and arr2 with arr1 if arr2 < arr1
		if (arr1.length > arr2.length) {
			int[] temp = arr2;
			arr2 = arr1;
			arr1 = temp;
		}
		// step 1: create min_index, max_index, i and j => i & j are the middle point of
		// array arr1 and arr2
		// -> min_index = 0
		// -> max_index = len of 1st array (min array)
		boolean isEven = (arr1.length + arr2.length) % 2 == 0 ? true : false;
		int min_index = 0;
		int max_index = arr1.length;
		int i = 0, j = 0;
		double median = 0.0;
		while (min_index <= max_index) {
			// step 2: i will be calculated with: (min_index + max_index / 2)
			i = (min_index + max_index) / 2;
			// Step 3: j will be calculated with: (len(arr1) + len(arr2) + 1 / 2) - i
			j = ((arr1.length + arr2.length + 1) / 2) - i;

			// Step 4: if arr1[i] > arr2[j+1] then we have to move on left side
			if (i > 0 && j < arr2.length && arr1[i - 1] > arr2[j]) {
				max_index = i - 1;
			} else
			// Step 5: if arr2[j] > arr1[i+1]
			if (i < arr1.length && j > 0 && arr2[j - 1] > arr1[i]) {
				min_index = i + 1;
			} else {
				// Step 6: if i == 0 its mean there is no more element on the left of arr1
				// so median will be arr2[j - 1]
				if (i == 0)
					median = arr2[j - 1];
				// Step 7: if j == 0 its mean there is no more element on the left of arr2
				// so median will be arr1[i - 1]
				else if (j == 0)
					median = arr1[i - 1];
				else
					// Step 6: get the right partition where,
					// arr1[i] <= arr2[j+1] && arr2[j] <= arr1[i+1]
					// return median here
					median = Math.max(arr1[i - 1], arr2[j - 1]);
				break;
			}
		}
		if (!isEven) {
			return median;
		} else {
			if (i == arr1.length)
				return (median + arr2[j]) / 2.0;
			if (j == arr2.length)
				return (median + arr1[i]) / 2.0;
			return (median + Math.min(arr1[i], arr2[j])) / 2;
		}

	}

	public static void main(String[] args) {
		MediamSortedArrayEffcientAlgo mediam = new MediamSortedArrayEffcientAlgo();
		double ans = mediam.findMedianSortedArrays(new int[] { 1, 2, 5, 6 }, new int[] { 3, 4 });
		System.out.println(ans);
	}
}

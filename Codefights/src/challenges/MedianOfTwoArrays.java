package challenges;

import java.util.Objects;

public class MedianOfTwoArrays {

	// Time complexity Olog(min(n,m)) and space complexity is O(1)
	public double findMedianSortedArrays(int[] arr1, int[] arr2) {
		// Step 1: if both are null or both are empty return 0.0
		if ((Objects.isNull(arr1) && Objects.isNull(arr2)) || (arr1.length == 0 && arr2.length == 0))
			return 0.0;
		// Step 2: shift small array to arr1 for maintaining Olog(min(n,m))
		if (arr1.length > arr2.length) {
			int[] temp = arr2;
			arr2 = arr1;
			arr1 = temp;
		}
		// Step 3: find partition in both arrays where arr1[a-1] < arr2[b] && arr2[b-1]
		// <
		// arrr1[a]
		int min_index = 0;
		int max_index = arr1.length; // len of small array
		int i = 0, j = 0;
		double median = 0.0;
		boolean isOdd = (arr1.length + arr2.length) % 2 == 1 ? true : false;
		while (min_index <= max_index) {
			i = (min_index + max_index) / 2; // i = (min+max)/2
			j = ((arr1.length + arr2.length + 1) / 2) - i; // j = ((len(arr1) + len(arr2) + 1) / 2) - i

			// in the case if arr1[a-1] > arr2[b] the find partition on left
			if (i > 0 && j < arr2.length && arr1[i - 1] > arr2[j]) {
				max_index = i - 1;
			} else if (j > 0 && i < arr1.length && arr2[j - 1] > arr1[i]) {
				min_index = i + 1;
			} else {
				if (i == 0)
					median = arr2[j - 1];
				else if (j == 0)
					median = arr1[i - 1];
				else
					median = Math.max(arr1[i - 1], arr2[j - 1]);
				break;
			}
		}
		// if sum of both array is odd then median is max(arr1[a-1], arr2[j-1])
		if(isOdd)
			return median;
		// if its even then max(arr1[a-1], arr2[b-1]) + min(arr1[a], arr2[b]) / 2;
		if(i == arr1.length)
			return (median + arr2[j]) / 2.0;
		if(j == arr2.length)
			return (median + arr1[i]) / 2.0;
		
		return (median + Math.min(arr1[i], arr2[j])) / 2.0;
	}
}

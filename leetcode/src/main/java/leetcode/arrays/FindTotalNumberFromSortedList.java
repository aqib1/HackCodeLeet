package leetcode.arrays;

import java.util.Arrays;
import java.util.Objects;

public class FindTotalNumberFromSortedList {

	public static int binarySearch(int[] data, int key) {
		if (Objects.isNull(data) || data.length == 0)
			return -1;
		int left = 0;
		int right = data.length - 1;
		while(left <= right) {
			 int mid = left + (right - left) / 2;
			 if(data[mid] == key)
				 return mid;
			 if(data[mid] > key) {
				 right = mid - 1;
			 } else {
				 left = mid + 1;
			 }
		}
		return -1;
	}

	public static int count(int[] data, int numb) {
		if (Objects.isNull(data) || data.length == 0)
			return 0;
		var index = binarySearch(data, numb); // Olog(n) -> O(1)if all elements are same and we requested the
														// same element
		if (index < 0)
			return 0;
		var count = 1;
		for (var start = index - 1; start >= 0; start--) {
			if (data[start] != numb)
				break;
			count++;
		}
		for (var end = index + 1; end < data.length; end++) {
			if (data[end] != numb)
				break;
			count++;
		} // O(K) where k is the number of occurrence in array
		return count; // total will be klog(n)
	}

	public static void main(String[] args) {
//		int mid = 1 + (10-1) / 2;
//		System.out.println(2 + 12 >>> 1);
		System.out.println(count(new int[] { 1, 1, 1, 1, 1, 2, 2, 3 }, 2));
	}
}

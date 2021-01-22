package leetcode.arrays;

import java.util.Arrays;

public class RearrangeArrayInSpecifiedPattren {

	// Rearrange the given array in specified fashion — a1<a2>a3<a4
	public static int[] array(int[] arr) {
		Arrays.sort(arr); // O(N LOG N)
		for (int x = 1; x < arr.length - 1; x += 2) {
			arr[x] = arr[x] + arr[x + 1];
			arr[x + 1] = arr[x] - arr[x + 1];
			arr[x] = arr[x] - arr[x + 1];
		} // O(N)
		return arr; // O (2N LOG N) -> O(N LOG N)
	}

	// with O(N)
	public static int[] zigZagArray(int[] arr) {
		boolean reverseComparison = false;

		for (int x = 0; x < arr.length - 1; x++) {
			if (!reverseComparison) {
				swap(x, x + 1, arr);
				reverseComparison = true;
			} else {
				swap(x + 1, x, arr);
				reverseComparison = false;
			}
		}

		return arr;
	}

	private static void swap(int x, int x1, int[] arr) {
		if (arr[x] > arr[x1]) {
			arr[x] = arr[x] + arr[x1];
			arr[x1] = arr[x] - arr[x1];
			arr[x] = arr[x] - arr[x1];
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(zigZagArray(new int[] { 2, 3, 4, 5, 6, 7 })));
	}
}

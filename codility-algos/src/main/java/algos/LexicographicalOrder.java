package algos;

import java.util.Arrays;

public class LexicographicalOrder {

	public static void sort(String[] arr) {
		byBubbleSort(arr);

	}

	// Time complexity O(n)2 and space is O(1)
	private static void byBubbleSort(String[] arr) {
		int limit = arr.length;
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;

			for (int x = 0; x < limit - 1; x++) {
				if (arr[x].compareTo(arr[x + 1]) > 0) {
					String temp = arr[x + 1];
					arr[x + 1] = arr[x];
					arr[x] = temp;
					isSorted = false;
				}
			}

			if (!isSorted)
				limit--;
		}

	}

	public static void main(String[] args) {
		String arr[] = { "A", "BA", "AB", "ABCD", "CBAD" };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

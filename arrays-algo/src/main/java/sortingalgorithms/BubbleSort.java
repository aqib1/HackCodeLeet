package sortingalgorithms;

import java.util.EmptyStackException;
import java.util.Objects;

public class BubbleSort {

	// Time complexity O(n)2 and space complexity O(1)
	public int[] bubbleSort(int[] array) {
		if (Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if (array.length == 1)
			return array;
		boolean isSorted = false;
		int lastSorted = array.length - 1;
		while (!isSorted) {
			isSorted = true;
			for (int x = 0; x < lastSorted; x++) {
				if (array[x] > array[x + 1]) {
					int temp = array[x];
					array[x] = array[x + 1];
					array[x + 1] = temp;
					isSorted = false;
				}
			}
			if (!isSorted)
				--lastSorted;
		}
		return array;
	}

	public static void main(String[] args) {

	}

}

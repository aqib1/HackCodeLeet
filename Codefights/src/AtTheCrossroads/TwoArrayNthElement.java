package AtTheCrossroads;

import java.util.Arrays;

public class TwoArrayNthElement {

	static int twoArraysNthElement(int[] array1, int[] array2, int n) {
		int[] merger = null;
		if (n >= (array1.length + array2.length))
			throw new IllegalArgumentException("illegal index");

		merger = merge(array1, array2);
		System.out.println(Arrays.toString(merger));
		return merger[n];
	}

	private static int[] merge(int[] array1, int[] array2) {
		int merger[] = new int[array1.length + array2.length];
		int xOf1 = 0, xOf2 = 0, xOfMerger = 0;
		while (xOf1 < array1.length && xOf2 < array2.length) {
			if (array1[xOf1] < array2[xOf2])
				merger[xOfMerger++] = array1[xOf1++];
			else
				merger[xOfMerger++] = array2[xOf2++];
		}
		while (xOf1 < array1.length) {
			merger[xOfMerger++] = array1[xOf1++];
		}
		while (xOf2 < array2.length) {
			merger[xOfMerger++] = array2[xOf2++];
		}
		return merger;
	}

	public static void main(String[] args) {
		System.out.println(twoArraysNthElement(new int[] { 2, 4, 9 }, new int[] { 1, 3, 6 }, 3));

	}

}

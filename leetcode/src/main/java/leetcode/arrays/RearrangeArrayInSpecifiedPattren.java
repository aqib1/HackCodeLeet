package leetcode.arrays;

import java.util.Arrays;

public class RearrangeArrayInSpecifiedPattren {

	// Rearrange the given array in specified fashion — a1<a2>a3<a4
	public static int[] array(int[] arr) {
		Arrays.sort(arr);
		for (int x = 1; x < arr.length - 1; x+=2) {
			arr[x] = arr[x] + arr[x+1];
			arr[x+1] = arr[x] - arr[x+1];
			arr[x] = arr[x] - arr[x+1];
		}
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(array(new int[] {2,3,4,5,6,7})));
	}
}

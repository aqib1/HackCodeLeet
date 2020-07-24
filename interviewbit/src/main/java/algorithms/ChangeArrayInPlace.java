package algorithms;

import java.util.Arrays;

public class ChangeArrayInPlace {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 0, 1 };
		changeArrInPlace(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void changeArrInPlace(int[] arr) {
		int len = arr.length;
		for (int x = 0; x < len; x++) {
			arr[x] += (arr[arr[x]] % len) * len;
		}
		for (int x = 0; x < len; x++) {
			arr[x] /= len;
		}
	}

}

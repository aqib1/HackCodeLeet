package Divingdeeper;

import java.util.Arrays;

public class FindAndReplace {

	static int[] findAndReplace(int[] arr, int f) {
		for (int x = 0; x < arr.length; x++)
			if (arr[x] == f)
				arr[x] = 0;
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findAndReplace(new int[] { 1, 2, 2, 3, 4 }, 2)));
	}
}

package algos;

import java.util.Arrays;
import java.util.LinkedList;

public class FindNextNumberAfterAdd {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(returnAfterAdd(new int[] { 1, 9, 9 })));
	}

	// time complexity O(n) and space is O(n)
	private static Integer[] returnAfterAdd(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		arr[arr.length - 1]++;
		LinkedList<Integer> stack = new LinkedList<>();
		int carry = 0;
		for (int x = arr.length - 1; x >= 0; x--) {
			arr[x] = arr[x] + carry;
			int value = (arr[x] / 10 == 0 ? arr[x] : arr[x] % 10);
			carry = arr[x] / 10;
			stack.push(value);
		}

		return stack.toArray(new Integer[stack.size()]);
	}
}

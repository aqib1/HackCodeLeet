package listForestEdge;

import java.util.Arrays;

public class RemoveArrayPart {

	static int[] removeArrayPart(int[] inputArray, int l, int r) {
		int[] arr = new int[inputArray.length - (r - l + 1)];
		int pointer = 0;
		for (int x = 0; x < inputArray.length; x++) {
			if (!(x >= l && x <= r)) {
				arr[pointer++] = inputArray[x];
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(removeArrayPart(new int[] { 2, 3, 2, 3, 4, 5 }, 2, 4)));
	}

}

package algorithm;

import java.util.stream.IntStream;

public class LoadBalance {

	public static void main(String[] args) {
		System.out.println(loadBalance(new int[] { 2, 4, 5, 5, 3, 9, 2, 2, 2 }));
	}

	// [2, 4, 5, 3, 3, 9, 2, 2, 2]
	// Time complexity O(n) -> for sum i am using streams
	public static boolean loadBalance(int[] arr) {
		int i = 1, j = arr.length - 2;
		long sumI = arr[0], sumJ = arr[arr.length - 1];

		while (i < j) {
			if (sumI == sumJ) {
				if (sumI == sum(arr, i + 1, j - 1))
					return true;
			}
			if (sumI < sumJ) {
				sumI += arr[i++];
			} else {
				sumJ += arr[j--];
			}
		}

		return false;
	}

	private static long sum(int[] arr, int i, int j) {
		if (i > arr.length || j < 0)
			return 0;
		return IntStream.range(i, j + 1).mapToObj(x -> arr[x]).reduce(0, (a, b) -> a + b);
	}
}

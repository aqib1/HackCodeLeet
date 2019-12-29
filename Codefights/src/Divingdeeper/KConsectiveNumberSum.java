package Divingdeeper;

public class KConsectiveNumberSum {
	static int arrayMaxConsecutiveSum(int[] inputArray, int k) {
		int max = Integer.MIN_VALUE;
		for (int x = 0; x < inputArray.length; x++) {
			int sum = 0;
			if ((x + (k - 1)) < inputArray.length)
				for (int y = x; y < (x + k); y++)
					sum += inputArray[y];
			if (sum > max) {
				max = sum;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(arrayMaxConsecutiveSum(new int[] { 1, 3, 2, 4 }, 3));
	}
}

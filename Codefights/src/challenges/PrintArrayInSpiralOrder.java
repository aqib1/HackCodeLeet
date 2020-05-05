package challenges;

import java.util.Arrays;

public class PrintArrayInSpiralOrder {

	/*
	 * 1, 2, 3, 4, 5 6, 7, 8, 9, 1 1, 2, 3, 4, 1 3, 3, 3, 3, 1 9, 9, 2, 1, 5
	 **/

	public static void main(String[] args) {
		System.out.println(Arrays.toString(spiralOrder(new int[][] { { 1, 2 }, {3, 4} , { 5, 6 } })));
	}

	public static int[] spiralOrder(final int[][] A) {
		int[] result = new int[A.length * A[0].length];
		int index = 0;
		/**
		 * k -> starting row index, l -> starting column index, m -> last index of row,
		 * n -> last index of col
		 */
		int k = 0, l = 0, m = A.length - 1, n = A[0].length - 1;

		while (k <= m && l <= n) {
			for (int x = l; x <= n; x++) {
				result[index++] = A[k][x];
			}
			k++;

			for (int x = k; x <= m; x++) {
				result[index++] =A[x][n];
			}
			n--;

			if (k <= m) {
				for (int x = n; x >= l; x--) {
					result[index++] =A[m][x];
				}
				--m;
			}

			if (l <= n) {
				for (int x = m; x >= k; x--) {
					result[index++] = A[x][l];
				}

				l++;
			}
		}

		return result;
	}
}

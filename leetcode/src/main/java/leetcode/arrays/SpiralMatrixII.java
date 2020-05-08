package leetcode.arrays;

public class SpiralMatrixII {

	public int[][] generateMatrix(int s) {
		int[][] result = new int[s][s];
		int index = 0;
		int k = 0, l = 0, m = s, n = s;
		while (k < m && l < n) {
			for (int x = k; x < m; x++) {
				result[k][x] = index++;
			}
			k++;
			for (int x = k; x < n; x++) {
				result[x][n - 1] = index++;
			}
			n--;
			if (k < m) {
				for (int x = (n - 1); x >= l; x--) {
					result[m - 1][x] = index++;
				}
				m--;
			}

			if (l < n) {
				for (int x = (m - 1); x >= k; x--) {
					result[x][l] = index++;
				}
				l++;
			}
		}
		return result;
	}
}

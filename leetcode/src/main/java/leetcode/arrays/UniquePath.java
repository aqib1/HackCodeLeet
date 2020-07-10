package leetcode.arrays;

public class UniquePath {
	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 3));
	}

	public static int uniquePaths(int m, int n) {
		int[][] matrix = new int[m][n];

		for (int x = 0; x < m; x++) {
			matrix[x][0] = 1;
		}

		for (int x = 1; x < n; x++) {
			matrix[0][x] = 1;
		}

		for (int x = 1; x < m; x++) {
			for (int y = 1; y < n; y++) {
				matrix[x][y] = matrix[x - 1][y] + matrix[x][y - 1];
			}
		}

		return matrix[m - 1][n - 1];
	}
}

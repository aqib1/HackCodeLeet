package algos;

public class RotateImage {
	// take transpose of matrix
	// swap first column with last

	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		// transpose
		for (int x = 0; x < matrix.length; x++) {
			for (int y = x; y < matrix[x].length; y++) {
				int temp = matrix[x][y];
				matrix[x][y] = matrix[y][x];
				matrix[y][x] = temp;
			}
		}

		int i = 0, j = matrix.length - 1;

		while (i < j) {

			for (int x = 0; x < matrix.length; x++) {
				int temp = matrix[x][i];
				matrix[x][i] = matrix[x][j];
				matrix[x][j] = temp;
			}

			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		rotate(new int[][] { //
				{ 1, 2, 3 }, //
				{ 4, 5, 6 }, //
				{ 7, 8, 9 } }); //
	}
}

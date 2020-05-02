package leetcode.arrays;

import java.util.Objects;

public class RotateImageLinearSolution {

	// O(n) solution with space O(1)
	// Two pointer solution
	// First transpose the matrix
	// then replace first column with last column

	public void rotateImage(int[][] array) {
		if (Objects.isNull(array))
			throw new IllegalArgumentException();
		int len = array.length;
		// transpose matrix
		for (int x = 0; x < len; x++) {
			for (int y = x; y < len; y++) {
				int temp = array[x][y];
				array[x][y] = array[y][x];
				array[y][x] = temp;
			}
		}
		for (int x = 0; x < len; x++) {
			for (int y = 0; y < (len / 2); y++) {
				int temp = array[x][y];
				array[x][y] = array[x][len - 1 - y];
				array[x][len - 1 - y] = temp;
			}
		}
	}
}

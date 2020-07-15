package algos;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixI {
	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] { //
				{ 2, 5, 8 }, //
				{ 4, 0, -1 }//
		}));
	}

	// time complexity O(n) and space is O(n)
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> data = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return data;

		int row = 0;
		int colLimit = matrix[row].length - 1;
		int rowLimit = matrix.length - 1;
		int col = 0;
		while (row <= rowLimit && col <= colLimit) {
			for (int x = col; x <= colLimit; x++) {
				data.add(matrix[row][x]);
			}
			row++;
			for (int x = row; x <= rowLimit; x++) {
				data.add(matrix[x][colLimit]);
			}
			colLimit--;

			if (row <= rowLimit) {
				for (int x = colLimit; x >= col; x--) {
					data.add(matrix[rowLimit][x]);
				}
				rowLimit--;
			}
			if (col <= colLimit) {
				for (int x = rowLimit; x >= row; x--) {
					data.add(matrix[x][col]);
				}
				col++;
			}
		}
		return data;
	}

}

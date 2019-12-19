package rainsofreasons;

import java.util.Arrays;

public class Minesweeper {

	static int[][] minesweeper(boolean[][] matrix) {
		int[][] sol = new int[matrix.length][matrix[0].length];
		for (int x = 0; x < sol.length; x++) {
			for (int y = 0; y < sol[x].length; y++) {
				if (matrix[x][y]) {
					incrementAdjusent(sol, x, y);
				}
			}
		}

		return sol;
	}

	private static void incrementAdjusent(int[][] sol, int row, int col) {
		// upper check
		int x = row - 1;
		if (x >= 0 && x < sol.length) {
			for (int y = (col - 1); y <= (col + 1); y++) {
				if (y >= 0 && y < sol[x].length)
					sol[x][y]++;
			}
		}
		// row check
		int y = col - 1;
		x = row;
		if (y >= 0)
			sol[x][y]++;
		y = col + 1;
		if (y < sol[x].length)
			sol[x][y]++;

		// down check
		x = row + 1;
		if (x >= 0 && x < sol.length) {
			for (y = (col - 1); y <= (col + 1); y++) {
				if (y >= 0 && y < sol[x].length)
					sol[x][y]++;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(minesweeper(
				new boolean[][] { {true,false}, 
					 {true,false}, 
					 {false,true}, 
					 {false,false}, 
					 {false,false} })));
	}
}

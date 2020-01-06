package LandOfLogics;

import java.util.HashSet;
import java.util.Set;

public class DifferentSquares {

	static int differentSquares(int[][] matrix) {
		Set<String> set = new HashSet<String>();
		for (int x = 0; x < matrix.length - 1; x++) {
			for (int y = 0; y < matrix[x].length - 1; y++) {
				set.add(String.valueOf(matrix[x][y]) + String.valueOf(matrix[x][y + 1])
						+ String.valueOf(matrix[x + 1][y]) + String.valueOf(matrix[x + 1][y + 1]));
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		System.out.println(
				differentSquares(new int[][] { { 1, 2, 1 }, { 2, 2, 2 }, { 2, 2, 2 }, { 1, 2, 3 }, { 2, 2, 1 } }));
	}

}

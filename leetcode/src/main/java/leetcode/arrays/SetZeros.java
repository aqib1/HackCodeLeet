package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class SetZeros {
//	[
//	  [1,1,1],
//	  [1,0,1],
//	  [1,1,1]
//	]
	public void setZeroes(int[][] matrix) {
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();

		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				if (matrix[x][y] == 0) {
					rows.add(x);
					cols.add(y);
				}
			}
		}

		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				if(rows.contains(x) || cols.contains(y)) {
					matrix[x][y] = 0;
				}
			}
		}
	}
}

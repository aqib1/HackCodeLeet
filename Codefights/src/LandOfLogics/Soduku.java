package LandOfLogics;

import java.util.ArrayList;
import java.util.List;

public class Soduku {

//	grid = [[1, 3, 2, 5, 4, 6, 9, 8, 7],
//	        [4, 6, 5, 8, 7, 9, 3, 2, 1],
//	        [7, 9, 8, 2, 1, 3, 6, 5, 4],
//	        [9, 2, 1, 4, 3, 5, 8, 7, 6],
//	        [3, 5, 4, 7, 6, 8, 2, 1, 9],
//	        [6, 8, 7, 1, 9, 2, 5, 4, 3],
//	        [5, 7, 6, 9, 8, 1, 4, 3, 2],
//	        [2, 4, 3, 6, 5, 7, 1, 9, 8],
//	        [8, 1, 9, 3, 2, 4, 7, 6, 5]]

	static boolean sudoku(int[][] grid) {
		int[] count = new int[10];
		for (int x = 0; x < grid.length; x++) {
			for (int t = 0; t < grid.length; t++) {
				count[grid[x][t]]++;
				count[grid[t][x]]++;
			}
			for (int z = 1; z < count.length; z++) {
				if (count[z] == 2) {
					count[z] = 0;
				} else {
					return false;
				}
			}
		}
		for (int x = 0; x < grid.length; x += 3) {
			for (int y = 0; y < grid[x].length; y += 3) {
				List<Integer> li = new ArrayList<>();
				for (int t = x; t < (x + 3); t++) {
					for (int l = y; l < (y + 3); l++) {
						if (grid[t][l] < 0 || grid[t][l] > 9 || li.contains(grid[t][l])) {
							return false;
						} else {
							li.add(grid[t][l]);
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(sudoku(new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
				{ 7, 8, 9, 1, 2, 3, 4, 5, 6 }, { 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 3, 4, 5, 6, 7, 8, 9, 1, 2 },
				{ 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
				{ 9, 1, 2, 3, 4, 5, 6, 7, 8 } }));
	}

}

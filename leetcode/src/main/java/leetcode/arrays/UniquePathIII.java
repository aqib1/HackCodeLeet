package leetcode.arrays;

public class UniquePathIII {

	/**
	 * [[1,0,0,0], [0,0,0,0], [0,0,2,-1]]
	 * 
	 * 
	 */

	public static void main(String[] args) {
//		System.out.println(uniquePathsIII(new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } }));
	}

	int count = 0;

	public int uniquePathsIII(int[][] grid) {
		int zeroCounts = 0;
		for (int x = 0; x < grid.length; x++)
			for (int y = 0; y < grid[x].length; y++)
				if (grid[x][y] == 0)
					zeroCounts++;

		for (int x = 0; x < grid.length; x++)
			for (int y = 0; y < grid[x].length; y++)
				if (grid[x][y] == 1)
					countAllPaths(grid, x, y, zeroCounts);
		return count;
	}

	private void countAllPaths(int[][] grid, int x, int y, int zeroCounts) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == -1 || grid[x][y] == -99
				|| (grid[x][y] == 2 && zeroCounts != 0)) {
			return;
		}
		if (grid[x][y] == 2 && zeroCounts == 0) {
			count++;

		}
		if (grid[x][y] == 0)
			zeroCounts--;
		int temp = grid[x][y];
		grid[x][y] = -99;

		countAllPaths(grid, x + 1, y, zeroCounts);
		countAllPaths(grid, x - 1, y, zeroCounts);
		countAllPaths(grid, x, y + 1, zeroCounts);
		countAllPaths(grid, x, y - 1, zeroCounts);

		grid[x][y] = temp;

	}

}

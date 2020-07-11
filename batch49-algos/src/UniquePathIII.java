
public class UniquePathIII {

	int count = 0;

	public int uniquePathsIII(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int zeroCounts = 0;
		for (int x = 0; x < grid.length; x++)
			for (int y = 0; y < grid[x].length; y++)
				if (grid[x][y] == 0)
					++zeroCounts;

		for (int x = 0; x < grid.length; x++)
			for (int y = 0; y < grid[x].length; y++)
				if (grid[x][y] == 1)
					countUniquePath(grid, x, y, zeroCounts);

		return count;
	}

	private void countUniquePath(int[][] grid, int x, int y, int zeroCounts) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == Integer.MIN_VALUE
				|| grid[x][y] == -1 || (grid[x][y] == 2 && zeroCounts != 0))
			return;
		if (grid[x][y] == 2 && zeroCounts == 0)
			count++;
		if (grid[x][y] == 0)
			zeroCounts--;
		int temp = grid[x][y];
		grid[x][y] = Integer.MIN_VALUE;

		countUniquePath(grid, x + 1, y, zeroCounts);
		countUniquePath(grid, x - 1, y, zeroCounts);
		countUniquePath(grid, x, y + 1, zeroCounts);
		countUniquePath(grid, x, y - 1, zeroCounts);

		grid[x][y] = temp;

	}
}

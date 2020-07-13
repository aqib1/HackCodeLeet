package algos;

public class NoOfIsland {
	private int direction[] = { 0, -1, 0, 1, 0 };

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int count = 0;
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				if (grid[x][y] == '1') {
					count++;
					invadeIsland(grid, x, y);
				}
			}
		}
		return count;
	}

	private void invadeIsland(char[][] grid, int x, int y) {
		grid[x][y] = '0';

		for (int d = 0; d < direction.length - 1; d++) {
			int newX = x + direction[d];
			int newY = y + direction[d + 1];
			if (newX >= 0 && newX < grid.length && //
					newY >= 0 && newY < grid[newX].length && //
					grid[newX][newY] == '1') {
				invadeIsland(grid, newX, newY);
			}

		}

	}
}

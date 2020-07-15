package leetcode.arrays;

public class MinPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][] { //
				{ 1, 3, 1 }, //
				{ 1, 5, 1 }, //
				{ 4, 2, 1 } //
		}));
	}

	public static int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		for (int x = 0; x < grid[0].length - 1; x++)
			grid[0][x + 1] += grid[0][x];
		for (int x = 0; x < grid.length - 1; x++)
			grid[x + 1][0] += grid[x][0];

		for (int x = 1; x < grid.length; x++) {
			for (int y = 1; y < grid[x].length; y++) {
				grid[x][y] += Math.min(grid[x][y - 1], grid[x - 1][y]);
			}
		}

		return grid[grid.length - 1][grid[0].length - 1];
	}
}

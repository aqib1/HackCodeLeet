package leetcode.arrays;

public class NoOfIslands {
	private static final int[] DIRECTIONS = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) {
		NoOfIslands noOfIslands = new NoOfIslands();
		System.out.println(noOfIslands.numIslands(new char[][] {
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}
		}));
	}
	
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == '1') {
					manageIsland(row, col, grid);
					count++;
				}
			}
		}
		return count;

	}

	private void manageIsland(int row, int col, char[][] grid) {
		grid[row][col] = '0';

		for (int d = 0; d < DIRECTIONS.length - 1; d++) {
			int newRow = row + DIRECTIONS[d];
			int newCol = col + DIRECTIONS[d+1];
			if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[newRow].length && grid[newRow][newCol] == '1') {
				manageIsland(newRow, newCol, grid);	
			}
		}

	}
}

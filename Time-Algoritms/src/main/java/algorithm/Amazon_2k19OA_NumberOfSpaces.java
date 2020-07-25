package algorithm;

public class Amazon_2k19OA_NumberOfSpaces {
	private static boolean spaceFound;

	private static final int[] directions = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) {
		System.out.println(getNoStore(new int[][] { //
				{ 1, 1, 0, 0 }, //
				{ 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0 }, //
				{ 1, 1, 0, 1 }, //
				{ 1, 1, 1, 1 }//

		}, 5, 4));
	}

	// Time complexity is O(n)2 and space is O(1)
	private static int getNoStore(int[][] grid, int rows, int columns) {
		int count = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				spaceFound = false;
				if (grid[row][col] == 1) {
					findSpaceInCluster(grid, row, col);
				}
				if (spaceFound)
					count++;
			}
		}

		return count;
	}

	private static void findSpaceInCluster(int[][] grid, int row, int col) {
		if (grid[row][col] == 1)
			grid[row][col] = -1;

		for (int d = 0; d < directions.length - 1; d++) {
			int newRow = row + directions[d];
			int newCol = col + directions[d + 1];
			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[newRow].length)
				if (grid[newRow][newCol] == 1)
					findSpaceInCluster(grid, newRow, newCol);
				else if (grid[newRow][newCol] == 0) {
					spaceFound = true;
				}
		}

	}
}

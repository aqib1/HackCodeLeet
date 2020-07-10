package leetcode.arrays;

public class UniquePathII {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0 }, { 1, 1 }, { 0, 0 } }));
	}

	// time complexity is O(n) and space is O(1)
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;
		if (obstacleGrid[0][0] == 1)
			return 0;
		obstacleGrid[0][0] = 1;
		for (int x = 1; x < obstacleGrid[0].length; x++)
			obstacleGrid[0][x] = (obstacleGrid[0][x] == 0 && obstacleGrid[0][x - 1] == 1) ? 1 : 0;
		for (int x = 1; x < obstacleGrid.length; x++)
			obstacleGrid[x][0] = (obstacleGrid[x][0] == 0 && obstacleGrid[x - 1][0] == 1) ? 1 : 0;
		for (int x = 1; x < obstacleGrid.length; x++)
			for (int y = 1; y < obstacleGrid[x].length; y++)
				if (obstacleGrid[x][y] == 1)
					obstacleGrid[x][y] = 0;
				else
					obstacleGrid[x][y] = obstacleGrid[x - 1][y] + obstacleGrid[x][y - 1];
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1];

	}
}

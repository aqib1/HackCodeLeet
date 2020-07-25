package algorithm;

public class NumberOfIsland {
	// -1,0
	// 1,0
	// 0,1
	// 0,-1
	// d -> 0, -1, 0, 1, 0

	public static void main(String[] args) {
		int[][] land = { //
				{ 1, 0, 0, 1 }, //
				{ 1, 0, 0, 1 }, //
				{ 0, 1, 1, 1 }, //
				{ 1, 0, 0, 0 }

		};
		System.out.println(noOfIsland(land));
	}

	static int[] direction = { 0, -1, 0, 1, 0 };

	public static int noOfIsland(int[][] land) {
		int count = 0;

		for (int x = 0; x < land.length; x++) {
			for (int y = 0; y < land[x].length; y++) {
				if (land[x][y] == 1) {
					bfs(land, x, y);
					count++;
				}
			}
		}

		return count;

	}

	private static void bfs(int[][] land, int x, int y) {
		land[x][y] = -1;

		for (int d = 0; d < direction.length - 1; d++) {
			int newX = x + direction[d];
			int newY = y + direction[d + 1];
			if (newX >= 0 && newX < land.length && newY >= 0 && newY < land[newX].length && land[newX][newY] == 1)
				bfs(land, newX, newY);
		}
	}
}

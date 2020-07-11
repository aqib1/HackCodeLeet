package leetcode.arrays;

public class TreasureIsland {

	public static void main(String[] args) {
		TreasureIsland treasureIsland = new TreasureIsland();
		char[][] treasure = new char[][] { //
				{ 'O', 'O', 'O', 'O' }, //
				{ 'D', 'O', 'D', 'X' }, //
				{ 'O', 'O', 'O', 'O' }, //
				{ 'O', 'D', 'D', 'O' } };
		System.out.println(treasureIsland.minSteps(treasure));
	}

	private int minRoute = Integer.MAX_VALUE;

	private int[] direction = new int[] { 0, -1, 0, 1, 0 };

	public int minSteps(char[][] island) {
		if (island == null || island.length == 0)
			return -1;
		boolean[][] visited = new boolean[island.length][island[0].length];
		minimumRoute(island, visited, 0, 0, 0);
		return minRoute;
	}

	private void minimumRoute(char[][] island, boolean[][] visited, int x, int y, int count) {
		if (island[x][y] == 'X') {
			minRoute = Math.min(minRoute, count);
			return;
		}
		visited[x][y] = true;
		for (int d = 0; d < direction.length - 1; d++) {
			int xNew = x + direction[d];
			int yNew = y + direction[d + 1];
			if (isValidMove(island, visited, xNew, yNew)) {
				minimumRoute(island, visited, xNew, yNew, count + 1);
			}

		}

		visited[x][y] = false;
	}

	private boolean isValidMove(char[][] island, boolean[][] visited, int xNew, int yNew) {
		return xNew >= 0 //
				&& xNew < island.length //
				&& yNew >= 0 //
				&& yNew < island[xNew].length //
				&& !visited[xNew][yNew] //
				&& island[xNew][yNew] != 'D'; //
	}
}

package leetcode.arrays;

import java.util.Objects;

public class NosOfIsland {

	// Time complexity O(n)2 for two d array, and O(n) for recursive algorithm, over all O(n)3 
	// Space complexity O(n) where n is the no of elements of array [using boolean array]
	public int numIslands(char[][] islands) {
		if (Objects.isNull(islands)) {
			throw new IllegalArgumentException();
		}
		if (islands.length == 0)
			return 0;
		boolean[][] isVisited = new boolean[islands.length][islands[0].length];
		return numIslands(islands, isVisited);
	}

	private int numIslands(char[][] islands, boolean[][] isVisited) {
		int count = 0;
		for (int x = 0; x < islands.length; x++) {
			for (int y = 0; y < islands[x].length; y++) {
				if (!isVisited[x][y] && islands[x][y] == '1') {
					foundIsland(islands, isVisited, x, y);
					count++;
				}
			}
		}
		return count;
	}

	private void foundIsland(char[][] islands, boolean[][] isVisited, int pointerX, int pointerY) {
		isVisited[pointerX][pointerY] = true;
		if (pointerX - 1 >= 0 && !isVisited[pointerX - 1][pointerY] && islands[pointerX - 1][pointerY] == '1')
			foundIsland(islands, isVisited, pointerX - 1, pointerY);
		if (pointerX + 1 < islands.length && !isVisited[pointerX + 1][pointerY]
				&& islands[pointerX + 1][pointerY] == '1')
			foundIsland(islands, isVisited, pointerX + 1, pointerY);
		if (pointerY - 1 >= 0 && !isVisited[pointerX][pointerY - 1] && islands[pointerX][pointerY - 1] == '1')
			foundIsland(islands, isVisited, pointerX, pointerY - 1);
		if (pointerY + 1 < islands[pointerX].length && !isVisited[pointerX][pointerY + 1]
				&& islands[pointerX][pointerY + 1] == '1')
			foundIsland(islands, isVisited, pointerX, pointerY + 1);
	}
}

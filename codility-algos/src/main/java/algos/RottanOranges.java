package algos;

import java.util.LinkedList;
import java.util.Queue;

public class RottanOranges {

	public static void main(String[] args) {
		System.out.println(orangesRotting(new int[][] { //

				{ 2, 1, 1 }, //
				{ 1, 1, 0 }, //
				{ 0, 1, 1 }//

		}));
	}

	// [[2,1,1],
	// [0,1,1],
	// [1,0,1]]
	/**
	 * the value 0 representing an empty cell. the value 1 representing a fresh
	 * orange. the value 2 representing a rotten orange.
	 */
	private static int directions[] = { 0, -1, 0, 1, 0 };

	// time complexity O(n) + O(m) * 5 which become O(n) overall
	// space is O(n) because we are using queue
	public static int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return -1;
		int minutes = 0;
		int freshOranges = 0;
		Queue<int[]> rottons = new LinkedList<>();
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				if (grid[x][y] == 2)
					rottons.add(new int[] { x, y });
				else if (grid[x][y] == 1)
					freshOranges++;
			}
		}
		if (freshOranges == 0)
			return 0;
		while (!rottons.isEmpty()) {
			int size = rottons.size();
			for (int x = 0; x < size; x++) {
				int[] rotton = rottons.poll();
				for (int d = 0; d < directions.length - 1; d++) {
					int newX = rotton[0] + directions[d];
					int newY = rotton[1] + directions[d + 1];
					if (newX >= 0 && newX < grid.length && //
							newY >= 0 && newY < grid[newX].length && //
							grid[newX][newY] == 1) {
						grid[newX][newY] = 2;
						freshOranges--;
						rottons.add(new int[] { newX, newY });
					}

				}
			}
			minutes++;
		}

		return freshOranges == 0 ? minutes - 1 : -1;

	}

}

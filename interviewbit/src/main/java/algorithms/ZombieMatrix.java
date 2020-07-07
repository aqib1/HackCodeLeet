package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieMatrix {
	private static int[] direction = { 0, -1, 0, 1, 0 };

	// Time complexity O(n)2 and space O(n)
	public static int humanDays(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return -1;
		}
		Queue<int[]> indexes = new LinkedList<>();
		int allSpace = matrix.length * matrix[0].length;
		int zombieCounts = 0, daysCount = 0;
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				if (matrix[x][y] == 1) {
					indexes.add(new int[] { x, y });
					zombieCounts++;
				}
			}
		}
		if (zombieCounts == 0)
			return -1;

		while (!indexes.isEmpty()) {
			// all zombies exists
			if (zombieCounts == allSpace)
				return daysCount;
			int size = indexes.size();
			for (int x = 0; x < size; x++) {
				int[] indexs = indexes.poll();
				for (int d = 0; d < direction.length - 1; d++) {
					int xMove = indexs[0] + direction[d];
					int yMove = indexs[1] + direction[d + 1];
					if (xMove >= 0 && yMove >= 0 && xMove < matrix.length && yMove < matrix[0].length
							&& matrix[xMove][yMove] == 0) {
						matrix[xMove][yMove] = 1;
						zombieCounts++;
						indexes.add(new int[] { xMove, yMove });
					}

				}
			}

			daysCount++;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };

		System.out.println(humanDays(matrix));
	}
}

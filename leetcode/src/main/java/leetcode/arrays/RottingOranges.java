package leetcode.arrays;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class RottingOranges {

	public int orangesRotting(int[][] oranges) {
		if (Objects.isNull(oranges) || oranges.length == 0)
			return 0;
		int rows = oranges.length;
		int cols = oranges[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int freshOranges = 0;
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				if (oranges[x][y] == 2) {
					queue.offer(new int[] { x, y });
				} else if (oranges[x][y] == 1) {
					freshOranges++;
				}
			}
		}
		if (freshOranges == 0)
			return 0;
		int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		int timeElapsed = 0;
		while (!queue.isEmpty()) {
			timeElapsed++;
			int size = queue.size();
			for (int x = 0; x < size; x++) {
				int[] rottenOrange = queue.poll();
				for (int[] dir : directions) {
					int a = rottenOrange[0] + dir[0];
					int b = rottenOrange[1] + dir[1];
					if (a < 0 || b < 0 || a >= rows || b >= cols || oranges[a][b] == 0 || oranges[a][b] == 2)
						continue;
					oranges[a][b] = 2;
					queue.offer(new int[] { a, b });
					freshOranges--;
				}
			}
		}

		return freshOranges == 0 ? timeElapsed - 1 : -1;
	}
}

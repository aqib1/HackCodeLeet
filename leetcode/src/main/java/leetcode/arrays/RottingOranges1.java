package leetcode.arrays;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class RottingOranges1 {
	public int orangesRotting(int[][] oranges) {
		if (Objects.isNull(oranges) || oranges.length == 0)
			return 0;
		int rows = oranges.length;
		int cols = oranges[0].length;
		Queue<int[]> queue = new LinkedList<int[]>();
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
		int timeElapsed = 0;
		int directions[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		while (!queue.isEmpty()) {
			timeElapsed++;
			int size = queue.size();
			for (int a = 0; a < size; a++) {
				int[] pointer = queue.poll();
				for (int[] direction : directions) {
					int x = pointer[0] + direction[0];
					int y = pointer[1] + direction[1];
					if (x < 0 || y < 0 || x >= rows || y >= cols || oranges[x][y] == 0 || oranges[x][y] == 2)
						continue;
					oranges[x][y] = 2;
					queue.offer(new int[] { x, y });
					freshOranges--;
				}
			}
		}
		return freshOranges == 0 ? timeElapsed - 1 : -1;
	}
}

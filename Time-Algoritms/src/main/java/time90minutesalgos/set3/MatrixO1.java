package time90minutesalgos.set3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[0,0,0], [0,1,0], [0,0,0]]
 * 
 * Output: [[0,0,0], [0,1,0], [0,0,0]] Example 2:
 * 
 * Input: [[0,0,0], [0,1,0], [1,1,1]]
 * 
 * Output: [[0,0,0], [0,1,0], [1,2,1]]
 * 
 * 
 */

public class MatrixO1 {
	private static final int[] directions = { 0, -1, 0, 1, 0 };

	// Time complexity is O(n)2 and space is O(n)
	public static int[][] updateMatrix(int[][] matrix) {
		Queue<int[]> indexesToBeConsider = new LinkedList<>();
		boolean[][] isVisited = new boolean[matrix.length][];
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				if (matrix[x][y] == 0) {
					indexesToBeConsider.add(new int[] { x, y });
				} else
					matrix[x][y] = Integer.MAX_VALUE;
			}
			isVisited[x] = new boolean[matrix[x].length];
		}

		while (!indexesToBeConsider.isEmpty()) {
			int[] indexes = indexesToBeConsider.poll();
			bfs(indexesToBeConsider, matrix, isVisited, indexes[0], indexes[1]);
		}

		return matrix;
	}

	private static void bfs(Queue<int[]> indexesToBeConsider, int[][] matrix, boolean[][] isVisited, int x, int y) {
		for (int d = 0; d < directions.length - 1; d++) {
			int newX = x + directions[d];
			int newY = y + directions[d + 1];
			if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[newX].length
					&& !isVisited[newX][newY]) {
				matrix[newX][newY] = Math.min(matrix[x][y] + 1, matrix[newX][newY]);
				isVisited[newX][newY] = true;
				indexesToBeConsider.add(new int[] { newX, newY });
			}
		}

	}

}
